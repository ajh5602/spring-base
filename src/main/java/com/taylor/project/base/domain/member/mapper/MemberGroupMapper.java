package com.taylor.project.base.domain.member.mapper;

import com.taylor.project.base.domain.member.dto.MemberGroupRequest;
import com.taylor.project.base.domain.member.dto.MemberGroupResponse;
import com.taylor.project.base.entity.MemberGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberGroupMapper {

    MemberGroupMapper instance = Mappers.getMapper(MemberGroupMapper.class);

    MemberGroupResponse toMemberGroupResponse(MemberGroup group);

    MemberGroup toMemberGroupRequest(MemberGroupRequest memberGroupRequest);
}
