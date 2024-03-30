package org.haiykut.libraryy.repositories;

import org.haiykut.libraryy.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
