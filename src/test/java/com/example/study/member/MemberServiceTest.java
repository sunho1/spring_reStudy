package com.example.study.member;

//import org.junit.jupiter.api.Assertions;
import com.example.study.configuration.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {



//    MemberService memberService = new MemberServiceImpl() ;
    private MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
    }


    @Test
    void join() {
        //given : 조건
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when : 상황
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        //then : 결과
        Assertions.assertThat(member).isEqualTo(findMember);


    }
}
