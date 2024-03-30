package org.haiykut.libraryy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "members_books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentableBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private LocalDateTime rentDate;
    private LocalDateTime deliveryDate;
    private Boolean complated = false;
}
