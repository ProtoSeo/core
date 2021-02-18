package hello.core.member;

public class MemberServiceImpl implements MemberService {
    // 이제 여기서 MemoryMemberRepository 에 대한 코드가 없어졌다. 이제 추상화에만 의존하게 되었다.
    private final MemberRepository memberRepository;

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
