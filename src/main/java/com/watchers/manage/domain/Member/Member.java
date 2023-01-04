package com.watchers.manage.domain.Member;

import com.watchers.manage.domain.BaseTimeEntity;
import com.watchers.manage.domain.Caution.Caution;
import com.watchers.manage.domain.Etc.Etc;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String tier;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private Set<Etc> etcs = new HashSet<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private Set<Caution> cautions = new HashSet<>();

    @Temporal(TemporalType.DATE)
    private Date enrolledDate;

    public void addEtc(Etc etc){
        this.getEtcs().add(etc);
        etc.setMember(this);
    }
    public void removeEtc(Etc etc){
        this.getEtcs().remove(etc);
        etc.setMember(null);
    }

    public void addCaution(Caution caution){
        this.getCautions().add(caution);
        caution.setMember(this);
    }

    public void removeCaution(Caution caution){
        this.getCautions().remove(caution);
        caution.setMember(null);
    }

    @Builder
    public Member(String name, String tier, String gender, int age,Date enrolledDate, Set<Etc> etcs, Set<Caution> cautions){
        if(!Objects.isNull(name)) this.name = name;
        if(!Objects.isNull(tier)) this.tier = tier;
        if(!Objects.isNull(gender)) this.gender = gender;
        if(!Objects.isNull(age)) this.age = age;
        if(!Objects.isNull(enrolledDate)) this.enrolledDate = enrolledDate;
        if(!Objects.isNull(etcs)) this.etcs = etcs;
        if(!Objects.isNull(cautions)) this.cautions = cautions;
    }

}
