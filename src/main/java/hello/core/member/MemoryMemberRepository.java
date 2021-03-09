package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// 데이터베이스가 확정되지 않았으므로, MemoryMemberRepository로 개발을 진행한다.
@Component // Component 로 등록하면 더이상 Bean으로 등록하지 않아도 된다
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
