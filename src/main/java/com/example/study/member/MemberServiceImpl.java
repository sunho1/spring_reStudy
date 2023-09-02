package com.example.study.member;

import com.example.study.discount.DiscountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository;
    private MemberRepository memberRepository1;

    private DiscountPolicy discountPolicy;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){

        this.memberRepository=memberRepository;
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy=discountPolicy;
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository){
        this.memberRepository1=memberRepository;
    }
}
