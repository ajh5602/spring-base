package com.taylor.project.base.domain.member.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.taylor.project.base.common.constant.enumtype.Device;
import com.taylor.project.base.domain.member.dto.MemberResponse;
import com.taylor.project.base.domain.member.dto.MemberUpdateRequest;
import com.taylor.project.base.entity.Member;
import com.taylor.project.base.entity.MemberGroup;
import com.taylor.project.base.repository.MemberGroupRepository;
import com.taylor.project.base.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;


@Slf4j
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberGroupRepository memberGroupRepository;

    @BeforeEach
    public void beforeEach() {
    }

    @Test
    void update() {
        //given
        log.info("Create Member!");
        MemberGroup memberGroup = MemberGroup.builder()
            .name("테스트 그룹")
            .desc("설명 입니다.")
            .build();
        memberGroupRepository.save(memberGroup);

        Member member = Member.builder()
            .loginId("test")
            .loginPassword("test1234")
            .name("홍길동")
            .phone("01012341234")
            .email("test@gmail.com")
            .device(Device.AOS)
            .memberGroup(memberGroup)
            .build();
        memberRepository.save(member);

        MemberUpdateRequest request = new MemberUpdateRequest(member.getId(), "1234", null, null,
            null);

        //when
        MemberResponse memberResponse = memberService.update(request);

        //then
        assertEquals(memberResponse.getId(), member.getId());
        assertEquals(memberResponse.getDevice(), member.getDevice());
        assertEquals(memberResponse.getEmail(), member.getEmail());
        assertNotEquals(memberResponse.getPhone(), member.getPhone());
    }

}