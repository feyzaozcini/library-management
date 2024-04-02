package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Publisher;
import org.haiykut.libraryy.services.dtos.requests.publisher.PublisherAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.publisher.PublisherUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Publisher.PublisherAddResponseDto;

import java.util.List;



public interface PublisherService {
    PublisherAddResponseDto add(PublisherAddRequestDto dto);

    String deleteById(int id);
    String updateById(int id, PublisherUpdateRequestDto dto);

    List<Publisher> getAllPublishers();
    Publisher getPublisherById(int id);
}
