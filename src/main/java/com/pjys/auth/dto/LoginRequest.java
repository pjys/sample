package com.pjys.auth.dto;

import com.pjys.auth.domain.MemberRole;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {

    private String userName;
    private String userPassword;
    private MemberRole role;
}
