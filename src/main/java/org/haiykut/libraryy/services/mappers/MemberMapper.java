package org.haiykut.libraryy.services.mappers;

import org.haiykut.libraryy.entities.Member;
import org.haiykut.libraryy.services.dtos.requests.member.MemberAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.member.MemberUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberGetDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberUpdateResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    Member memberFromDto(MemberAddRequestDto request);

    Member memberFromDto(MemberUpdateRequestDto request);

    MemberAddResponseDto addDtoFromMember(Member member);

    MemberUpdateResponseDto updateDtoFromMember(Member member);

    MemberGetDto memberGetDtoFromMember(Member member);
}
