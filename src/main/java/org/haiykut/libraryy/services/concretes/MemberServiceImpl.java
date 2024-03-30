package org.haiykut.libraryy.services.concretes;


import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Member;
import org.haiykut.libraryy.entities.Officer;
import org.haiykut.libraryy.repositories.MemberRepository;
import org.haiykut.libraryy.services.abstracts.MemberService;
import org.haiykut.libraryy.services.dtos.MemberForAddDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    public void add(MemberForAddDto dto) {
        Member member=new Member();
        member.setName(dto.getName());
        member.setPassword(dto.getPassword());
        member.setEmail(dto.getEmail());
        member.setPhoneNumber(dto.getPhoneNumber());

        memberRepository.save(member);
    }

    @Override
    public void update(int id, MemberForAddDto officer) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Officer not found with id: " + id));

        existingMember.setName(officer.getName());
        existingMember.setPassword(officer.getPassword());
        existingMember.setPhoneNumber(officer.getPhoneNumber());
        existingMember.setEmail(officer.getEmail());

        memberRepository.save(existingMember);
    }

    @Override
    public void delete(int id) {
        Member member = memberRepository.findById(id).orElse(null);
        if(member==null)
            throw new RuntimeException("Silinmek istenen member bulunamadı.");

        memberRepository.delete(member);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member getById(int id) {
        return memberRepository.findById(id).orElseThrow();
    }
}
