package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Officer;
import org.haiykut.libraryy.services.dtos.OfficerForAddDto;

import java.util.List;

public interface OfficerService {
    void add(OfficerForAddDto dto);
    void update(int id,OfficerForAddDto officer);
    void delete(int id);
    List<Officer> getAll();
    Officer getById(int id);
}
