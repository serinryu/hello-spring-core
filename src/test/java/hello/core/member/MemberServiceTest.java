package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach  //테스트 실행하기 전에 AppConfig에서 memberService 가져와서 위 memberService 에 할당을 해준다.
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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
