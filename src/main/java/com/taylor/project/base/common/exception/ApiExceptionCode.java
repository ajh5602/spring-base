package com.taylor.project.base.common.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ApiExceptionCode {

    //not found
    NOT_FOUND_DATA("NOT_FOUND_DATA", "해당 데이터를 찾을 수 없습니다."),
    NOT_FOUND_MEMBER("NOT_FOUND_MEMBER", "회원 정보를 찾을 수 없습니다."),
    NOT_FOUND_MEMBER_GROUP("NOT_FOUND_MEMBER_GROUP", "그룹 정보를 찾을 수 없습니다."),

    //check duplication
    DUPLICATION_MEMBER_JOIN("DUPLICATION_MEMBER_JOIN", "동일 회원이 가입되어있습니다."),
    DUPLICATION_MEMBER_GROUP("DUPLICATION_MEMBER_GROUP", "이미 존재하는 그룹 명입니다."),

    ;

    final String code;
    final String message;
}
