package org.haiykut.libraryy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String author;
    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;
    private int page;
    private int bookCount;
    /*
    @ManyToMany(mappedBy = "books")
    private List<Publisher> publishers;
     */
    @OneToMany(mappedBy = "book")
    private List<MemberBook> membersBooks;
    @OneToMany(mappedBy = "book")
    private List<PublisherBook> publishersBooks;
}
