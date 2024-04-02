package org.haiykut.libraryy.services.mappers;

import org.haiykut.libraryy.entities.Officer;
import org.haiykut.libraryy.services.dtos.requests.officer.OfficerAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.officer.OfficerUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Officer.OfficerAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.Officer.OfficerGetDto;
import org.haiykut.libraryy.services.dtos.responses.Officer.OfficerUpdateResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OfficerMapper {
    OfficerMapper INSTANCE= Mappers.getMapper(OfficerMapper.class);

    Officer officerFromDto(OfficerAddRequestDto request);

    Officer officerFromDto(OfficerUpdateRequestDto request);

    OfficerAddResponseDto addDtoFromOfficer(Officer officer);

    OfficerUpdateResponseDto updateDtoFromOfficer(Officer officer);

    OfficerGetDto officerGetDtoFromOfficer(Officer officer);

}
