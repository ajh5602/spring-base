package com.taylor.project.base.domain.member.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.taylor.project.base.common.constant.enumtype.Device;
import com.taylor.project.base.entity.MemberGroup;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberDto {

    String loginId;
    String loginPassword;
    String name;
    String phone;
    String email;
    Device device;
    MemberGroup memberGroup;

    public void setMemberGroup(MemberGroup memberGroup) {
        this.memberGroup = memberGroup;
    }
}
