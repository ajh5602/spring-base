package com.taylor.project.base.repository;

import com.taylor.project.base.entity.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    Optional<Member> findByLoginId(String loginId);

    Optional<Member> findByMemberGroup_Id(Long memberGroupId);

    List<Member> findByLoginIdOrPhoneOrEmail(String loginId, String phone, String email);

}
