package org.haiykut.libraryy.repositories;

import org.haiykut.libraryy.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByNameIgnoreCase(String name);

    Optional<Category> findById(Integer id);
}
