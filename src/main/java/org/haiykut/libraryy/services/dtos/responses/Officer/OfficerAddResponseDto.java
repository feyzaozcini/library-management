package org.haiykut.libraryy.services.dtos.responses.Officer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfficerAddResponseDto {
    private int id;
    private String name;
    private String password;
    private String phoneNumber;
    private String email;
}
