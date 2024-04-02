package org.haiykut.libraryy.core.utils.exceptions.details;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BusinessProblemDetails  {

    private String detail;
    private  String title="Business Problem";

}