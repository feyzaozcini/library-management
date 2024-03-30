package org.haiykut.libraryy.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "members")
public class Member extends User {
   /*
    @ManyToMany
    @JoinTable(
            name = "members_books",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> handledBooks;

    */
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<RentableBook> handledBooks;

}
