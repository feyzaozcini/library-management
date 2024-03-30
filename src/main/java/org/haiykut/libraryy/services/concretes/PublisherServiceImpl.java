package org.haiykut.libraryy.services.concretes;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Publisher;
import org.haiykut.libraryy.repositories.PublisherRepository;
import org.haiykut.libraryy.services.abstracts.PublisherService;
import org.haiykut.libraryy.services.dtos.requests.publisher.PublisherAddRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    @Override
    public String add(PublisherAddRequestDto dto) {
        Publisher newPublisher = new Publisher();
        newPublisher.setName(dto.getName());
        publisherRepository.save(newPublisher);
        return "Eklendi";

    }

    @Override
    public String deleteById(int id) {
        publisherRepository.deleteById(id);
        return "silindi";
    }

    @Override
    public String updateById(int id, PublisherAddRequestDto dto) {
        Publisher requestedPublisher = publisherRepository.findById(id).orElseThrow();
        requestedPublisher.setName(dto.getName());
        publisherRepository.save(requestedPublisher);
        return "Guncellendi!";
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(int id) {
        return publisherRepository.findById(id).orElseThrow();
    }
}
