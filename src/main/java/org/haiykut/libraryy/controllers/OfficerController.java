package org.haiykut.libraryy.controllers;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Officer;
import org.haiykut.libraryy.services.abstracts.OfficerService;
import org.haiykut.libraryy.services.dtos.OfficerForAddDto;
import org.haiykut.libraryy.services.dtos.RentRequestDto;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/officers")
@RequiredArgsConstructor
public class OfficerController {
    private final OfficerService officerService;

    @GetMapping
    public List<Officer> getAll(){
        return officerService.getAll();
    }
    @GetMapping("/{officerId}")
    public Officer getOneOfficer(@PathVariable int officerId) {
        return officerService.getById(officerId);
    }
    @PostMapping
    public void add(@RequestBody OfficerForAddDto dto)
    {
        officerService.add(dto);
    }

    @DeleteMapping ("/{officerId}")
    public void deleteOneOfficer(@PathVariable int officerId) {
        officerService.delete(officerId);
    }

    @PutMapping("/{id}")
    public void updateOfficer(@PathVariable int id, @RequestBody OfficerForAddDto newOfficer)
    {
        try {
            officerService.update(id,newOfficer);
        } catch (Exception e) {
            throw new RuntimeException("Error updating officer: " + e.getMessage());
        }
    }

    @PostMapping("/rent")
    public String rentABook(@RequestBody RentRequestDto dto) throws IOException {
        return officerService.rentBook(dto);
    }

    @DeleteMapping("/{officerId}/deliver")
    public String deliverBook(@PathVariable int officerId, @RequestBody RentRequestDto dto){
        return officerService.deliverBook(officerId, dto);
    }






}
