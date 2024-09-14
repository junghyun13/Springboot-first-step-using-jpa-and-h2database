package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
@Controller
public class MemberController {
    //static Long a = 0L;
    private MemberService memberService; //필드 주입 대신 생성자 주입을 사용

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        System.out.println("members 리스트 내용: " + members);
        return "members/memberList";
    }
    /*private MemberService memberService; //필드주입

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        System.out.println("member = "+member.getName());
        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }*/

}
