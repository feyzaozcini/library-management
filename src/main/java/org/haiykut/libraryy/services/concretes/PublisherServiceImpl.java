package org.haiykut.libraryy.services.concretes;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Publisher;
import org.haiykut.libraryy.repositories.PublisherRepository;
import org.haiykut.libraryy.services.abstracts.PublisherService;
import org.haiykut.libraryy.services.dtos.requests.publisher.PublisherAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.publisher.PublisherUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Publisher.PublisherAddResponseDto;
import org.haiykut.libraryy.services.mappers.PublisherMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    @Override
    public PublisherAddResponseDto add(PublisherAddRequestDto dto) {
        Publisher newPublisher = PublisherMapper.INSTANCE.categoryFromRequest(dto);
        publisherRepository.save(newPublisher);
        return new PublisherAddResponseDto(newPublisher.getName());

    }

    @Override
    public String deleteById(int id) {
        publisherRepository.deleteById(id);
        return "silindi";
    }

    @Override
    public String updateById(int id, PublisherUpdateRequestDto dto) {
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

    private void publisherWithSameNameShouldNotExist(String name){
        Optional<Publisher> publisherWithSameName = publisherRepository.findByNameIgnoreCase(name);
        if(publisherWithSameName.isPresent()){
            throw new IllegalArgumentException("A publisher with this name already exists!");
        }
    }

}
