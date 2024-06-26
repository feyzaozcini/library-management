package org.haiykut.libraryy.services.dtos.requests.officer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfficerAddRequestDto {
    private String name;
    private String password;
    private String phoneNumber;
    private String email;
}
