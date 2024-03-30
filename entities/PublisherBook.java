package org.haiykut.libraryy.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "publishers_books")
@Data
public class PublisherBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

}
