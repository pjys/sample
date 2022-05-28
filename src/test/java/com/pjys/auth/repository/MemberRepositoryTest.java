package com.pjys.auth.repository;

import com.pjys.auth.domain.Member;
import com.pjys.auth.domain.MemberRole;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@Log
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void insertTest() {
        for (int i = 0; i < 100; i++) {
            Member member = new Member();
            member.setUserId("user" + i);
            member.setUserPassword("pw" + i);
            member.setUserEmail("user" + i + "@test.com");
            MemberRole role = new MemberRole();
            if (i <= 80) {
                role.setRoleName("BASIC");
            } else if (i <= 90) {
                role.setRoleName("MANAGER");
            } else {
                role.setRoleName("ADMIN");
            }
            member.setRoles(Arrays.asList(role));
            memberRepository.save(member);
        }
    }

}