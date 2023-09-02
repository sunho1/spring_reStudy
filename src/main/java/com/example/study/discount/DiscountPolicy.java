package com.example.study.discount;

import com.example.study.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
