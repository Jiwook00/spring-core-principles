package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 이제 memoryMemberRepository가 없다. 추상화에 의존해야한다.
    // DIP를 지킨다. 구체적인, 구현 내요은 밖 AppConfig에서 생성해서 넣어줌
    private final MemberRepository memberRepository;

    // 생성자
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
