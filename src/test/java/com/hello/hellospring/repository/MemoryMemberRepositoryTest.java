package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 하나의 테스트가 끝날 때마다, repository 를 깔끔하게 지워주는 로직을 넣어야함
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("서연이");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("장서연");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("장문채");
        repository.save(member2);

        Member result = repository.findByName("장문채").get();
        Assertions.assertEquals(member2, result);


    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("연폰");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("리밍");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertEquals(result.size(), 2);

    }
}
