package com.pjys.auth.repository;

import com.pjys.auth.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByUserName(String userName);
}
