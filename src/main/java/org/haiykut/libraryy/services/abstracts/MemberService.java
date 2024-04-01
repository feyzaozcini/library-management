package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Member;
import org.haiykut.libraryy.services.dtos.requests.member.MemberAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.member.MemberUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberGetDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberUpdateResponseDto;


import java.util.List;

public interface MemberService {

    MemberAddResponseDto add(MemberAddRequestDto dto);
    MemberUpdateResponseDto updateById(int id, MemberUpdateRequestDto dto);
    void deleteById(int id);
    List<MemberGetDto> getAllMembers();
    MemberGetDto getMemberById(int id);
}
