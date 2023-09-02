package com.example.study.discount;

import com.example.study.member.Grade;
import com.example.study.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }

        return 0;
    }
}
