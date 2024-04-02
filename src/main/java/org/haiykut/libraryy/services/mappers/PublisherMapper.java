package org.haiykut.libraryy.services.mappers;

import org.haiykut.libraryy.entities.Publisher;
import org.haiykut.libraryy.services.dtos.requests.publisher.PublisherAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.publisher.PublisherUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);
    Publisher categoryFromRequest(PublisherAddRequestDto request);
    Publisher categoryFromRequest(PublisherUpdateRequestDto request);
}
