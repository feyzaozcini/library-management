package org.haiykut.libraryy.repositories;

import org.haiykut.libraryy.entities.RentedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentedBookRepository extends JpaRepository<RentedBook, Integer> {
}
