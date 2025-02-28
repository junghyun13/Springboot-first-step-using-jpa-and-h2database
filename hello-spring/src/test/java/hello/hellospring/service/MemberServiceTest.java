package hello.hellospring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    /*@AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }*/


    @Test
    public void 회원가입(){
        Member member = new Member();
        member.setName("hello"); //given

        Long saveID = memberService.join(member); //when

        Member findMember = memberService.findOne(saveID).get();
        assertThat(member.getName()).isEqualTo(findMember.getName()); //then

    }
    @Test
    public void 중복회원_예외() {
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미존재하는 회원");


    }
}
/*try{
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원이다");
        }*/
