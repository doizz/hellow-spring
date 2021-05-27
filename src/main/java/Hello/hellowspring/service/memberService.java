package Hello.hellowspring.service;

import Hello.hellowspring.domain.Member;
import Hello.hellowspring.repository.MemberRepository;
import Hello.hellowspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class memberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 회원은 제외
        validataDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validataDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /***
     * 전체회원조회
     * @return
     */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
