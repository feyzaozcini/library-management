package org.haiykut.libraryy.repositories;

import org.haiykut.libraryy.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {


    Optional<Publisher> findByNameIgnoreCase(String name);

}
