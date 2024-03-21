package com.taylor.project.base.common.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiPageable {

    final Long offset;
    final Long pageNumber;
    final Long pageSize;
    final Long pageElements;
    final Long totalPages;
    final Long totalElements;
    final Boolean first;
    final Boolean last;

    @Builder
    public ApiPageable(
        Long offset,
        Long pageNumber,
        Long pageSize,
        Long pageElements,
        Long totalElements) {
        this.offset = offset;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.pageElements = pageElements;
        this.totalPages = (long) Math.ceil((double) totalElements / pageSize);
        this.totalElements = totalElements;
        this.first = pageNumber <= 1;
        this.last = pageNumber >= totalPages;
    }

}
