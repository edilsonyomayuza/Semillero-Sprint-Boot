package com.example.Semillero.mapper;

import com.example.Semillero.entity.ClientEntity;
import com.example.Semillero.model.ClientDto;

public class ClientMapper {

    public ClientEntity clientMapper (ClientDto clientDto){

        ClientEntity client = new ClientEntity();

        client.setStrIdentification(clientDto.getStrIdentification());
        client.setStrIdentificationType(clientDto.getStrIdentificationType());
        client.setStrFirstName(clientDto.getStrFirstName());
        client.setStrSecondName(clientDto.getStrSecondName());

        return client;
    }

    public ClientDto clientEntityToDTO (ClientEntity clientDto){

        ClientDto clientDto1 = new  ClientDto();

        clientDto1.setStrIdentification(clientDto.getStrIdentification());
        clientDto1.setStrIdentificationType(clientDto.getStrIdentificationType());
        clientDto1.setStrFirstName(clientDto.getStrFirstName());
        clientDto1.setStrSecondName(clientDto.getStrSecondName());

        return clientDto1;
    }
}
