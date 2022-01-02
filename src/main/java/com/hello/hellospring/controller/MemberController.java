package com.hello.hellospring.controller;

import com.hello.hellospring.service.MemberService;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
