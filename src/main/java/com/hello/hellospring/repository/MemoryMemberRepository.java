package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    // 실무에서는 동시성 문제가 있을 수 있어서, 아래의 store 처럼
    // 공유되는 변수에서는 ConcurrentHashMap 을 써야 한다.
    // 그러나 지금은 예제니까 단순하게 HashMap
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 0,1,2... 키 값을 생성해주는 변수

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // 과거에는 그냥 null 일 가능성이 있어도 그냥 반환했었다
        // 요즘엔 Optional 로 감싸서 반환해주는데,
        // 이렇게 반환하면 클라이언트쪽에서 뭘 할 수가 있음
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // Java8 의 람다를 사용하겠다
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
