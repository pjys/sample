package com.pjys.auth.service;

import com.pjys.auth.domain.SecurityMember;
import com.pjys.auth.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 반환 타입이 Member와 맞지 않아 일치시켜 줘야 함 -> SecurityMember
        return Optional.ofNullable(memberRepository.findByUserEmail(email))
                .filter(m -> m != null)
                .map(m -> new SecurityMember(m)).get();
    }
}
