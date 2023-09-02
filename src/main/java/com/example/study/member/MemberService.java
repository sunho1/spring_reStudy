package com.example.study.member;

public interface MemberService {

    public MemberRepository getMemberRepository();
    void join(Member member);

    Member findMember(Long memberId);
}
