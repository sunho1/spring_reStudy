package com.example.study.member;

import com.example.study.discount.DiscountPolicy;
import com.example.study.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationDependencyTest {

    private DiscountPolicy discountPolicy;

    private MemberRepository memberRepository;

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy=discountPolicy;
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }


    @Test
    void createOrder(){
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, discountPolicy);
        orderService.CreateOrder(1L,"itemA",100000);
    }

}
