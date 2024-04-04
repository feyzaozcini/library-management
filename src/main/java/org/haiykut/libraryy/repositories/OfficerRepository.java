package org.haiykut.libraryy.repositories;

import org.haiykut.libraryy.entities.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {
    Optional<Officer> findByNameIgnoreCase(String name);

    Optional<Officer> findById(Integer id);
}
