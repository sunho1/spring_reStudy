package com.example.study.order;

import com.example.study.member.MemberRepository;

public interface OrderService {

    public MemberRepository getMemberRepository();
    Order CreateOrder(Long MemberId, String itemName, int itemPrice);
}
