package org.haiykut.libraryy.repositories;

import org.haiykut.libraryy.entities.MemberBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberBookRepository extends JpaRepository<MemberBook, Integer> {
}
