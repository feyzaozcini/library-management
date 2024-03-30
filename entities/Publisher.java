package org.haiykut.libraryy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "publishers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Publisher {
   @Column(name = "id")
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   /*
   @ManyToMany
   @JoinTable(
           name = "publishers_books",
           joinColumns = @JoinColumn(name = "publisher_id"),
           inverseJoinColumns = @JoinColumn(name = "book_id")
   )
   private List<Book> books;

    */
   @OneToMany(mappedBy = "publisher")
   private List<PublisherBook> publishersBooks;
}
