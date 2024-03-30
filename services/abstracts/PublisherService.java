package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Publisher;
import org.haiykut.libraryy.services.dtos.requests.publisher.PublisherAddRequestDto;

import java.util.List;

public interface PublisherService {
    String add(PublisherAddRequestDto dto);

    String deleteById(int id);
    String updateById(int id, PublisherAddRequestDto dto);

    List<Publisher> getAllPublishers();
    Publisher getPublisherById(int id);
}
