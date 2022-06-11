package com.pjys.auth.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Slf4j
@Getter @Setter
public class SecurityMember extends User {

    private Member member;

    public SecurityMember(Member member) {
        super(member.getUserName(), member.getUserPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));

        log.info("SecurityUser member.username = {}", member.getUserName());
        log.info("SecurityUser member.password = {}", member.getUserPassword());
        log.info("SecurityUser member.role = {}", member.getRole().toString());

        this.member = member;
    }

}
