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
    NOT_FOUND_LOGIN_ID("NOT_FOUND_LOGIN_ID", "회원 아이디를 찾을 수 없습니다."),

    //check duplication
    DUPLICATION_MEMBER("DUPLICATION_MEMBER_MEMBER", "동일 회원이 있습니다."),
    DUPLICATION_MEMBER_GROUP("DUPLICATION_MEMBER_GROUP", "이미 존재하는 그룹 명입니다."),

    //fail
    FAIL_LOGIN_PASSWORD("FAIL_LOGIN_PASSWORD", "비밀번호가 일지하지 않습니다."),

    ;

    final String code;
    final String message;
}
