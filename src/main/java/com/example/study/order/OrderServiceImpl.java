package com.example.study.order;

import com.example.study.discount.DiscountPolicy;
import com.example.study.discount.FixDiscountPolicy;
import com.example.study.member.Member;
import com.example.study.member.MemberRepository;
import com.example.study.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    private MemberRepository memberRepository;
    private  DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository=memberRepository;
        this.discountPolicy=discountPolicy;
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

    @Override
    public Order CreateOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);

        return new Order(member.getId(), itemName, itemPrice, discountPolicy.discount(member, itemPrice));
    }
}
