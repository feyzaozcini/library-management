package org.haiykut.libraryy.repositories;

import org.haiykut.libraryy.entities.PublisherBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherBookRepository extends JpaRepository<PublisherBook, Integer> {
}
