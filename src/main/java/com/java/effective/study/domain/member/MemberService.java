package com.java.effective.study.domain.member;

/*서비스 기획 -회원 가입 , 회원 찾기
Repository는 저장소 예를들어 DB에서 사용할 메서드,
Service는 Repository에서 구현한 기능들을 사용하고 필요 시 더 기능들을 구현해서
사용자가 사용하게 되는 메서드를 넣는 차이점이 있다(MemoryMemberRepository랑 개념적으로 차이가 있다)
* */
public interface MemberService {

    void join(Member member);
    Member findMember(Long memberId);

}
