package com.pjys.common.config;

import com.pjys.auth.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // IFrame 동작하도록 설정
        http.headers().frameOptions().disable();

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/", "/signup", "/login", "/css/**","/temp/**").permitAll()
                .antMatchers("/member/**").authenticated() // 일반사용자 접근 가능
                .antMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN") // 매니저, 관리자 접근 가능
                .antMatchers("/admin/**").hasRole("ADMIN"); // 관리자만 접근 가능
        // 인증 필요 시 로그인 페이지와 로그인 성공 시 리다이렉팅 페이지 설정 + 이메일 로그인 설정
        http.formLogin().loginPage("/login").usernameParameter("userName").passwordParameter("userPassword").defaultSuccessUrl("/", true);
        // 로그인 수행 uri 지정
        http.formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/", true);
        // 인증된 사용자지만 인가된 uri가 아닌 경우 리다이렉트 설정
        http.exceptionHandling().accessDeniedPage("/forbidden");
        // 로그아웃
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");

        http.userDetailsService(customUserDetailsService);
    }
}
