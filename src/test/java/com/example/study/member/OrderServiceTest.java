package com.example.study.member;

import com.example.study.configuration.AppConfig;
import com.example.study.discount.DiscountPolicy;
import com.example.study.order.Order;
import com.example.study.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    private MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

    private OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

//    private MemberService memberService;
//    private OrderService orderService;

//    @BeforeEach
//    public void beforeEach(){
//        AppConfig appConfig = new AppConfig();
//        this.memberService = appConfig.memberService();
//        this.orderService = appConfig.orderService();
//    }

    @Test
    void orderTest(){

        Member member = new Member(1L, "test1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.CreateOrder(member.getId(), "test1", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
