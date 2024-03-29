package org.haiykut.libraryy.repositories;

import org.haiykut.libraryy.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
