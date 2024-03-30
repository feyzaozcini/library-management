package org.haiykut.libraryy.services.concretes;


import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Member;
import org.haiykut.libraryy.repositories.MemberRepository;
import org.haiykut.libraryy.services.abstracts.MemberService;
import org.haiykut.libraryy.services.dtos.requests.member.MemberAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.member.MemberUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberAddResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    public MemberAddResponseDto add(MemberAddRequestDto dto) {
        Member member=new Member();
        member.setName(dto.getName());
        member.setPassword(dto.getPassword());
        member.setEmail(dto.getEmail());
        member.setPhoneNumber(dto.getPhoneNumber());
        memberRepository.save(member);
        return new MemberAddResponseDto(member.getId(),member.getName(),member.getPassword(), member.getEmail(), member.getPhoneNumber());
    }

    @Override
    public void updateById(int id, MemberUpdateRequestDto member) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));

        existingMember.setName(member.getName());
        existingMember.setPassword(member.getPassword());
        existingMember.setPhoneNumber(member.getPhoneNumber());
        existingMember.setEmail(member.getEmail());

        memberRepository.save(existingMember);
    }

    @Override
    public void deleteById(int id) {
        Member member = memberRepository.findById(id).orElse(null);
        if(member==null)
            throw new RuntimeException("Silinmek istenen member bulunamadı.");

        memberRepository.delete(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(int id) {
        return memberRepository.findById(id).orElseThrow();
    }
}
