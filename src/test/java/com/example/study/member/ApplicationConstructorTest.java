package com.example.study.member;

import com.example.study.discount.DiscountPolicy;
import com.example.study.discount.FixDiscountPolicy;
import com.example.study.order.OrderService;
import com.example.study.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationConstructorTest {
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

        //memoryMemberRepository 구현체
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L,"name",Grade.VIP));

        //discountPolicy 구현체는 곧바로 생성
        //OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, discountPolicy);
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());

        orderService.CreateOrder(1L,"itemA",100000);
    }

}
