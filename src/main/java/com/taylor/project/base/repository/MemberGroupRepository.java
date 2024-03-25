package com.taylor.project.base.repository;

import com.taylor.project.base.entity.MemberGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberGroupRepository extends JpaRepository<MemberGroup, Long> {

    Page<MemberGroup> findByNameLikeAndDeletedYn(String name, Boolean isDeleted, Pageable pageable);

}
