package com.watchers.manage.service;

import com.watchers.manage.Web.DTO.MemberRequestDto;
import com.watchers.manage.domain.Member.Member;
import com.watchers.manage.domain.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(MemberRequestDto requestDto){
        return memberRepository.save(requestDto.toEntity()).getId();
    }

    public Member findById(Long id){
        Member member = memberRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 맴버 정도가 없습니다."));
        return member;
    }

    public List<Member> findByAll() {
        return memberRepository.findAll();
    }
}
