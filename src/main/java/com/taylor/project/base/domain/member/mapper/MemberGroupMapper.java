package com.taylor.project.base.domain.member.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberGroupMapper {

    MemberGroupMapper instance = Mappers.getMapper(MemberGroupMapper.class);

//    MemberGroupResponse toMemberGroupResponse(MemberGroup group);
}
