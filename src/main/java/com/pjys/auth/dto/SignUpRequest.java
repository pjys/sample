package com.pjys.auth.dto;

import com.pjys.auth.domain.MemberRole;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUpRequest {

    private String userName;
    private String userEmail;
    private String userPassword;
    private MemberRole role = MemberRole.ROLE_MEMBER;
}
