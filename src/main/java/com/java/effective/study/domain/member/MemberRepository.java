package com.java.effective.study.domain.member;

public interface MemberRepository {
      void save(Member member);
      Member findId(long id);
}
