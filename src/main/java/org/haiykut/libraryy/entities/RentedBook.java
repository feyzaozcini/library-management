package org.haiykut.libraryy.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "rented_books")
@Data
public class RentedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "members_book_id")
    private MemberBook membersBooks;
    @Column(name = "date_of_rent")
    private Date rentDate;
    @Column(name = "delivery_date")
    private Date deliveryDate;
}
