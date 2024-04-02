package org.haiykut.libraryy.services.dtos.responses.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateResponseDto {
    private int id;
    private String name;

    private String description;
}
