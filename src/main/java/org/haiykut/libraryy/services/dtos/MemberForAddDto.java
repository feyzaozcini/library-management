package org.haiykut.libraryy.services.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberForAddDto {
    private String name;
    private String password;
    private String phoneNumber;
    private String email;
}
