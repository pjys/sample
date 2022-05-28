package com.pjys.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // IFrame 동작하도록 설정
        http.headers().frameOptions().disable();

        http
                // /login에 대한 익명 액세스를 허용
                // /admin을 ADMIN 역할로 제한 하고 다른 모든 것을 보호
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/**").permitAll(); // 임시
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/css/**", "/scripts/**", "image/**", "/fonts/**", "lib/**");
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/js/**","/css/**","/fonts/**","/images/**","/favicon.ico").permitAll()
                    .antMatchers("/**").permitAll() //개발용
                    .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
    }*/
}
