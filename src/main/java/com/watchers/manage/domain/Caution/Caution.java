package com.watchers.manage.domain.Caution;

import com.watchers.manage.domain.BaseTimeEntity;
import com.watchers.manage.domain.Member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Caution extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private int cautionCount;

    private String reason;
}
