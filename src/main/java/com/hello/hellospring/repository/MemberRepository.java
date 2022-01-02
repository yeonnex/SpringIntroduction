package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// 회원 객체를 저장하는 저장소
public interface MemberRepository {
    Member save(Member member); // 회원을 저장하고, 저장한 회원을 반환
    Optional<Member> findById(Long id); // 반환값이 null일 경우 null을 반환하지 않고 Optional 로 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
