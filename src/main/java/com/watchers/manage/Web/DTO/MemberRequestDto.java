package com.watchers.manage.Web.DTO;

import com.watchers.manage.domain.Caution.Caution;
import com.watchers.manage.domain.Etc.Etc;
import com.watchers.manage.domain.Member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String name;
    private String tier;
    private String gender;
    private int age;

    private Date enrolledDate;

    private Set<Etc> etcs;
    private Set<Caution> cautions;

    @Builder
    public MemberRequestDto(String name, String tier, String gender, int age, Date enrolledDate, Set<Etc> etcs, Set<Caution> cautions){
        this.name = name;
        this.tier = tier;
        this.gender = gender;
        this.age = age;
        this.enrolledDate = enrolledDate;
        this.etcs = etcs;
        this.cautions = cautions;
    }

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .tier(tier)
                .gender(gender)
                .age(age)
                .enrolledDate(enrolledDate)
                .etcs(etcs)
                .cautions(cautions)
                .build();
    }

}
