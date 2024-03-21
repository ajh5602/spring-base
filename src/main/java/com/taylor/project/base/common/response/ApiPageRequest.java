package com.taylor.project.base.common.response;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public record ApiPageRequest(
    @NotNull(message = "페이지 번호는 필수입니다.")
    @Min(value = 1, message = "1이하에 숫자는 입력할 수 없습니다.")
    Integer pageNumber,
    @NotNull(message = "페이지 사이즈는 필수 값입니다.")
    Integer pageSize) {

    public PageRequest of() {
        return PageRequest.of(pageNumber - 1, pageSize, Sort.unsorted());
    }

    public PageRequest of(Sort sort) {
        return PageRequest.of(pageNumber - 1, pageSize, sort);
    }

}
