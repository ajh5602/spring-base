package com.taylor.project.base.repository;

import com.taylor.project.base.domain.member.dto.MemberSearchRequest;
import com.taylor.project.base.entity.Member;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {

    Page<Member> findByMemberSearchRequest(MemberSearchRequest memberSearchRequest,
        Pageable pageable);

    List<Member> findDuplicationMember(String loginId, String phone, String email);

}
