package org.haiykut.libraryy.core.utils.exceptions.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails {

    private Map<String, String> errors;
    private String title = "Validation Problem";

}
