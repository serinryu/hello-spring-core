package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given 주어졌을때
        Member member = new Member(1L, "pitchu",Grade.VIP);

        //when 이렇게 했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
        // 검증하는 내용. Assertions 은 검증할 때 사용하는 편리한 API 가 많으므로 검증시 추천.
        // 조인 한거와 찾는게 똑같은지 확인한다.

    }
}
