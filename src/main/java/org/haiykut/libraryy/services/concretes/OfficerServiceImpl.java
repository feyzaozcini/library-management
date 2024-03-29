package org.haiykut.libraryy.services.concretes;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Officer;
import org.haiykut.libraryy.repositories.OfficerRepository;
import org.haiykut.libraryy.services.abstracts.OfficerService;
import org.haiykut.libraryy.services.dtos.OfficerForAddDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OfficerServiceImpl implements OfficerService {

    private final OfficerRepository officerRepository;


    @Override
    public void add(OfficerForAddDto dto) {
        Officer officer=new Officer();
        officer.setName(dto.getName());
        officer.setPassword(dto.getPassword());
        officer.setEmail(dto.getEmail());
        officer.setPhoneNumber(dto.getPhoneNumber());

        officerRepository.save(officer);
    }


    @Override
    public void update(int id,OfficerForAddDto officer) {
        Officer existingOfficer = officerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Officer not found with id: " + id));

        existingOfficer.setName(officer.getName());
        existingOfficer.setPassword(officer.getPassword());
        existingOfficer.setPhoneNumber(officer.getPhoneNumber());
        existingOfficer.setEmail(officer.getEmail());

        officerRepository.save(existingOfficer);
    }

    @Override
    public void delete(int id) {
        Officer category = officerRepository.findById(id).orElse(null);
        if(category==null)
            throw new RuntimeException("Silinmek istenen kategori bulunamadı.");

        officerRepository.delete(category);
    }

    @Override
    public List<Officer> getAll() {
        return officerRepository.findAll();
    }

    @Override
    public Officer getById(int id) {
        return officerRepository.findById(id).orElseThrow();
    }
}
