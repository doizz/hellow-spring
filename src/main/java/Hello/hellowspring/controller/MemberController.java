package Hello.hellowspring.controller;


import Hello.hellowspring.service.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final memberService memberService;

    @Autowired
    public MemberController(memberService memberService) {
        this.memberService = memberService;
    }
}

