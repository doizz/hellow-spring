package Hello.hellowspring.service;

import Hello.hellowspring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class memberServiceTest {

    memberService memberService = new memberService();


    @Test
    void 회원가입() {

        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);


        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(member.getName());

    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when

        memberService.join(member1);
//        Assertions.assertThat(IllegalStateException.class, () -> memberService.join(member2));

//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.121");
//        }


        //then
    }



    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}