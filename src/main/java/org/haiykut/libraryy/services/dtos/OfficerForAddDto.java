package org.haiykut.libraryy.services.dtos;


import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OfficerForAddDto {
    private String name;
    private String password;
    private String phoneNumber;
    private String email;
}