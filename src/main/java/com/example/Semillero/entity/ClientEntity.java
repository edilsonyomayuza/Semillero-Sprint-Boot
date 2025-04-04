package com.example.Semillero.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ClientEntity {
    @Id
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CLIENT")
    private long numId;

    @Column(name = "IDENTIFICATION_TYPE")
    private String strIdentificationType;

    @Column(name = "IDENTIFICATION_NUMBER")
    private String strIdentification;

    @Column(name = "FIRST_NAME")
    private String strFirstName;

    @Column(name = "SECOND_NAME")
    private String strSecondName;

}
