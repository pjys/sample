package com.pjys.auth.controller;

import com.pjys.auth.domain.Member;
import com.pjys.auth.domain.MemberRole;
import com.pjys.auth.dto.SignUpRequest;
import com.pjys.auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class SignUpController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String signUp(Model model) {

        model.addAttribute("member", new SignUpRequest());
        return "auth/signUp";
    }

    @PostMapping("/signup")
    public String create(@ModelAttribute SignUpRequest signUpRequest) {

        Member member = Member.builder()
                .username(signUpRequest.getUserName())
                .useremail(signUpRequest.getUserEmail())
                .password(bCryptPasswordEncoder.encode(signUpRequest.getUserPassword()))
                .role(signUpRequest.getRole())
                .build();

        memberRepository.save(member);

        return "redirect:/login";
    }

    @ModelAttribute("roles")
    public Map<String, MemberRole> roles() {

        Map<String, MemberRole> map = new LinkedHashMap<>();
        map.put("관리자", MemberRole.ROLE_ADMIN);
        map.put("매니저", MemberRole.ROLE_MANAGER);
        map.put("일반 사용자", MemberRole.ROLE_MEMBER);

        return map;
    }

}
