package org.haiykut.libraryy.services.dtos.requests.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberUpdateRequestDto {
    private String name;
    private String password;
    private String phoneNumber;
    private String email;
}
