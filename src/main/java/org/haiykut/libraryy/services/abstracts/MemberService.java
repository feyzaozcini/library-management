package org.haiykut.libraryy.services.abstracts;

import org.haiykut.libraryy.entities.Member;
import org.haiykut.libraryy.services.dtos.MemberForAddDto;


import java.util.List;

public interface MemberService {
    void add(MemberForAddDto dto);
    void update(int id,MemberForAddDto officer);
    void delete(int id);
    List<Member> getAll();
    Member getById(int id);
}
