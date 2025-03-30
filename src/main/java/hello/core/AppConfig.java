package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // 어디선가 AppConfig를 통해서 memberService를 불러서 사용함
    // MemberService 구현체인 객체가 생성이 되는데,
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    // appConfig 객체는 MemoryMemberRepository 객체를 생성하고 그 참조값을 memberServiceImpl 을 생성하면서 생성자로 전달한다.
    // 클라이언트인 memberServiceImpl 입장에서는 의존관계를 마치 외부에서 주입해주는 것 같다고 해서 DI(Dependency Injection)
    // 우리말로 의존관계 주입

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
