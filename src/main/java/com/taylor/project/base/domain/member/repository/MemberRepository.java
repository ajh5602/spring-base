package com.taylor.project.base.domain.member.repository;

import com.taylor.project.base.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

}
