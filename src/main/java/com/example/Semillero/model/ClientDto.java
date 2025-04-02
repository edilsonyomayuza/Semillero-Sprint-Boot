package com.example.Semillero.model;

//import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)  // Ignora los campos nulos en JSON
public class ClientDto {

    private long numId;

    private String strIdentificationType;

    private String strIdentification;

    private String strFirstName;

    private String strSecondName;

}
