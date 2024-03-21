package com.taylor.project.base.domain.member.mapper;

import com.taylor.project.base.domain.member.dto.MemberResponse;
import com.taylor.project.base.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper instance = Mappers.getMapper(MemberMapper.class);

    MemberResponse toMemberResponse(Member member);
}
