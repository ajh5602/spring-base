package com.taylor.project.base.domain.member.repository;

import com.taylor.project.base.entity.MemberGroup;
import java.awt.print.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberGroupRepository extends JpaRepository<MemberGroup, Long> {

    Page<MemberGroup> findByNameLike(String name, Pageable pageable);

}
