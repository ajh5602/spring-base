package com.taylor.project.base.domain.member.mapper;

import com.taylor.project.base.domain.auth.dto.JoinRequest;
import com.taylor.project.base.domain.auth.dto.LoginResponse;
import com.taylor.project.base.domain.member.dto.MemberDto;
import com.taylor.project.base.domain.member.dto.MemberResponse;
import com.taylor.project.base.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper instance = Mappers.getMapper(MemberMapper.class);

    MemberResponse toMemberResponse(Member member);

    @Mapping(source = "joinRequest.memberGroupId", target = "memberGroup", ignore = true)
    MemberDto toJoinResponse(JoinRequest joinRequest);

    Member toMember(MemberDto memberDto);

    @Mapping(target = "token", ignore = true)
    LoginResponse toMember(Member member);
}
