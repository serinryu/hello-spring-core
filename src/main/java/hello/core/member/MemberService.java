package hello.core.member;

public interface MemberService {
    void join(Member member); //๊ฐ์
    Member findMember(Long memberId); // ์กฐํ
}
