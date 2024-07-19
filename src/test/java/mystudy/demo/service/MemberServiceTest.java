package mystudy.demo.service;

import mystudy.demo.domain.Member;

import mystudy.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {


MemberService memberService;
MemoryMemberRepository memberRepository;
@BeforeEach
public void beforeEach(){
    memberRepository = new MemoryMemberRepository();
    memberService= new MemberService(memberRepository);
}

public void afterEach(){
    memberRepository.clearStore();
}

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId= memberService.join(member);


        //then
        Member findMember=memberService.findOne(saveId).get();
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());


    }
    @Test
    public void 중복회원예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
       assertThrows(IllegalStateException.class,()->{memberService.join(member2);});
//
//        //when
//        memberService.join(member1);
//        try{
//            memberService.join(member2);
//fail();
//        }catch(IllegalStateException e ){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하ㅌㅌ는 회원입니다");
//
//        }
//        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}