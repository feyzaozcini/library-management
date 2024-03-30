package org.haiykut.libraryy.entities;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "officers")
public class Officer extends User {
    
}
