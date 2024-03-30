package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Member;
import org.haiykut.libraryy.services.dtos.requests.member.MemberAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.member.MemberUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberAddResponseDto;


import java.util.List;

public interface MemberService {

    MemberAddResponseDto add(MemberAddRequestDto dto);
    void updateById(int id, MemberUpdateRequestDto dto);
    void deleteById(int id);
    List<Member> getAllMembers();
    Member getMemberById(int id);
}
