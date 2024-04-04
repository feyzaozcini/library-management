package org.haiykut.libraryy.repositories;
import org.haiykut.libraryy.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByNameIgnoreCase(String name);
    Optional<Book> findById(Integer id);

}
