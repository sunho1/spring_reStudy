package com.example.study.configuration;

import com.example.study.discount.DiscountPolicy;
import com.example.study.discount.FixDiscountPolicy;
import com.example.study.discount.RateDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public DiscountPolicy rateDiscountPolicy(){
        return new RateDiscountPolicy();
    }


    @Bean
    public DiscountPolicy fixDiscountPolicy(){
        return new FixDiscountPolicy();
    }
}
