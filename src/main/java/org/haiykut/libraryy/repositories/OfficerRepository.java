package org.haiykut.libraryy.repositories;

import org.haiykut.libraryy.entities.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {
}
