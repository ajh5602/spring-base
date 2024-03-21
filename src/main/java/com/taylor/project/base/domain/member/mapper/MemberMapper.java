package com.taylor.project.base.domain.member.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper instance = Mappers.getMapper(MemberMapper.class);

//    MemberResponse toMemberResponse(Member member);
}
