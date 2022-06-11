package com.pjys.auth.service;

import com.pjys.auth.domain.Member;
import com.pjys.auth.domain.SecurityMember;
import com.pjys.auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 반환 타입이 Member와 맞지 않아 일치시켜 줘야 함 -> SecurityMember
        Optional<Member> member = memberRepository.findByUserName(username);

        if (!member.isPresent()) {
            throw new UsernameNotFoundException("존재하지 않는 아이디입니다.");
        }

        log.info("loadUserByUsername : {}", username);

        return new SecurityMember(member.get());
    }
}
