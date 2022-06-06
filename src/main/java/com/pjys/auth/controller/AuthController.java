package com.pjys.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/signup")
    public String signUp() {
        return "auth/signUp";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}
