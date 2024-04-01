package org.haiykut.libraryy.services.concretes;
import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Member;
import org.haiykut.libraryy.repositories.MemberRepository;
import org.haiykut.libraryy.services.abstracts.MemberService;
import org.haiykut.libraryy.services.dtos.requests.member.MemberAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.member.MemberUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberGetDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberUpdateResponseDto;
import org.haiykut.libraryy.services.mappers.MemberMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    public MemberAddResponseDto add(MemberAddRequestDto dto) {
        Member member = MemberMapper.INSTANCE.memberFromDto(dto);
        memberRepository.save(member);
        return MemberMapper.INSTANCE.addDtoFromMember(member);
    }

    @Override
    public MemberUpdateResponseDto updateById(int id, MemberUpdateRequestDto member) {
        Member requestedMember = MemberMapper.INSTANCE.memberFromDto(member);
        requestedMember.setId(id);
        memberRepository.save(requestedMember);
        return MemberMapper.INSTANCE.updateDtoFromMember(requestedMember);
    }

    @Override
    public void deleteById(int id) {
        Member member = memberRepository.findById(id).orElse(null);
        if(member==null)
            throw new RuntimeException("Silinmek istenen member bulunamadı.");
        memberRepository.delete(member);
    }

    @Override
    public List<MemberGetDto> getAllMembers() {
        return  memberRepository.findAll().stream().map(member -> MemberMapper.INSTANCE.memberGetDtoFromMember(member)).collect(Collectors.toList());
    }

    @Override
    public MemberGetDto getMemberById(int id) {
        return MemberMapper.INSTANCE.memberGetDtoFromMember(memberRepository.findById(id).orElseThrow());
    }
}
