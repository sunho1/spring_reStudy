package com.example.study.configuration;

import com.example.study.member.MemberRepository;
import com.example.study.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SameBeanConfig {

    @Bean
    public MemberRepository memberRepository1(){
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberRepository memberRepository2(){
        return new MemoryMemberRepository();
    }

}
