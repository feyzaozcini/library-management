package org.haiykut.libraryy.repositories;

import org.haiykut.libraryy.entities.RentableBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentableBookRepository extends JpaRepository<RentableBook, Integer> {
}
