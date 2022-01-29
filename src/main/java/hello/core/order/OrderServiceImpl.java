package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원 정보를 조회(메모리회원리포지토리)하고
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인 정책(고정금액할인정책)을 적용한 다음
        return new Order(memberId, itemName, itemPrice, discountPrice); //주문 객체를 생성해서 반환한다.
    }
}
