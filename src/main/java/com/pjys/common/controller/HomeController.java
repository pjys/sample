package com.pjys.common.controller;

import com.pjys.auth.domain.SecurityMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    //@GetMapping
    public String homeV1(Authentication authentication, Model model) {
        if (authentication != null) {
            SecurityMember principal = (SecurityMember) authentication.getPrincipal();
            model.addAttribute("principal", principal.getMember());
            model.addAttribute("role", principal.getMember().getRole().getDescription());
        }
        return "home";
    }

    @GetMapping
    public String homeV2(@AuthenticationPrincipal SecurityMember principal, Model model) {
        if (principal != null) {
            model.addAttribute("principal", principal.getMember());
            model.addAttribute("role", principal.getMember().getRole().getDescription());
        }
        return "home";
    }
}
