package com.taylor.project.base.domain.member.service;

import com.taylor.project.base.entity.Member;
import com.taylor.project.base.entity.MemberGroup;
import com.taylor.project.base.repository.MemberGroupRepository;
import com.taylor.project.base.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberGroupRepository memberGroupRepository;

    @BeforeAll
    public static void beforeAll() {
        log.info("Create Member!");
        MemberGroup memberGroup = MemberGroup.builder()

            .build();

        Member member = Member.builder()
            .build();
    }

    @Test
    void create() {

    }

    @Test
    void update() {
        //given

        //when

        //then

    }

}