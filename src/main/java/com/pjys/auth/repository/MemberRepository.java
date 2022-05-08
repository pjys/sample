package com.pjys.auth.repository;

import com.pjys.auth.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
