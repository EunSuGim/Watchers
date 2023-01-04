package com.watchers.manage.controller;

import com.watchers.manage.Web.DTO.MemberRequestDto;
import com.watchers.manage.domain.Member.Member;
import com.watchers.manage.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping(value = "/api/v1/member", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long saveJson(@RequestBody MemberRequestDto requestDto){
        return memberService.save(requestDto);

    }

    @PostMapping(value = "/api/v1/member", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Long saveForm(MemberRequestDto requestDto){
        return memberService.save(requestDto);
    }

    @GetMapping("/api/v1/member/{id}")
    public Member findById(@PathVariable Long id){
        return memberService.findById(id);
    }

    @GetMapping("/api/v1/member")
    public List<Member> findByAll(){
        return memberService.findByAll();
    }
}
