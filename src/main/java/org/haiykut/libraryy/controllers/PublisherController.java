package org.haiykut.libraryy.controllers;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Publisher;
import org.haiykut.libraryy.services.abstracts.PublisherService;
import org.haiykut.libraryy.services.dtos.requests.publisher.PublisherAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.publisher.PublisherUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Publisher.PublisherAddResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;
    @GetMapping("/all")
    public List<Publisher> getAllPublishers(){
        return publisherService.getAllPublishers();
    }
    @GetMapping("/{id}")
    public Publisher getPublisherById(@PathVariable int id){
        return publisherService.getPublisherById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return publisherService.deleteById(id);
    }
    @PostMapping("/add")
    public PublisherAddResponseDto add(PublisherAddRequestDto dto){
        return publisherService.add(dto);
    }
    @PutMapping("/update/{id}")
    public String updateById(@PathVariable int id, @RequestBody PublisherUpdateRequestDto dto){
        return publisherService.updateById(id, dto);
    }
}
