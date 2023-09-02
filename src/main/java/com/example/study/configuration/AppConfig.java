package com.example.study.configuration;

import com.example.study.discount.DiscountPolicy;
import com.example.study.discount.FixDiscountPolicy;
import com.example.study.member.MemberRepository;
import com.example.study.member.MemberService;
import com.example.study.member.MemberServiceImpl;
import com.example.study.member.MemoryMemberRepository;
import com.example.study.order.OrderService;
import com.example.study.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.MemberRepository");

        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        System.out.println("call AppConfig.DiscountPolicy");
        return new FixDiscountPolicy();
    }

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberRepository");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call Appconfig.OrderSerivce");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
