package com.example.Semillero.model;

//import lombok.Data;

import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
public class ClientDto {

    private long numId;

    private String strIdentificationType;

    private String strIdentification;

    private String strFirstName;

    private String strSecondName;

}
