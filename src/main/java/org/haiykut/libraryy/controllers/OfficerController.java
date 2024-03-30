package org.haiykut.libraryy.controllers;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Officer;
import org.haiykut.libraryy.services.abstracts.OfficerService;
import org.haiykut.libraryy.services.dtos.RentRequestDto;
import org.haiykut.libraryy.services.dtos.requests.officer.OfficerAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.officer.OfficerUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Officer.OfficerAddResponseDto;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/officers")
@RequiredArgsConstructor
public class OfficerController {
    private final OfficerService officerService;

    @GetMapping("/all")
    public List<Officer> getAll(){
        return officerService.getAllOfficers();
    }
    @GetMapping("/{officerId}")
    public Officer getOneOfficer(@PathVariable int officerId) {
        return officerService.getOfficerById(officerId);
    }
    @PostMapping("/add")
    public OfficerAddResponseDto add(@RequestBody OfficerAddRequestDto dto){
        return officerService.add(dto);

    }

    @DeleteMapping ("/{officerId}")
    public void deleteOneOfficer(@PathVariable int officerId) {
        officerService.deleteById(officerId);
    }

    @PutMapping("/update/{id}")
    public void updateOfficer(@PathVariable int id, @RequestBody OfficerUpdateRequestDto newOfficer)
    {
        try {
            officerService.updateById(id,newOfficer);
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
