package com.taylor.project.base.entity;

import com.taylor.project.base.common.constant.enumtype.Device;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Table(name = "member", indexes = {
    @Index(name = "idx__loginId", columnList = "loginId"),
    @Index(name = "idx__phone__email", columnList = "phone, email")
})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String loginId;

    @Column(nullable = false)
    String loginPassword;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String phone;

    String email;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'none'")
    Device device;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_group", nullable = false)
    MemberGroup memberGroup;

    @Column(name = "dormant_yn")
    @ColumnDefault("'0'")
    Boolean dormantYn;

    @Column(name = "withdraw_yn")
    @ColumnDefault("'0'")
    Boolean withdrawYn;

    @Column(name = "withdraw_datetime")
    LocalDateTime withdrawDateTime;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @Builder
    public Member(
        String loginId,
        String loginPassword,
        String name,
        String phone,
        String email,
        Device device,
        MemberGroup memberGroup) {
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.device = device;
        this.memberGroup = memberGroup;
    }
}
