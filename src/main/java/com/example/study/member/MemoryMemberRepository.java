package com.example.study.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    //실무에서는 동시성 이슈 때문에 concurrentHashMap 사용
    //이걸 그냥 DB 대신에 사용한다고 생각하면 된다.

    @Override
    public void save(Member member) {
        store.put(member.getId() , member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);


    }
}
