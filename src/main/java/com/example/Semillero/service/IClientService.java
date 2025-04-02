package com.example.Semillero.service;

import com.example.Semillero.entity.ClientEntity;
import com.example.Semillero.exception.ServiceException;
import com.example.Semillero.model.ClientDto;

import java.util.List;

public interface IClientService {

    List<ClientDto> showAllClients();

    //void saveClient(ClientDto clientDto);
    void saveClient(ClientDto clientDto) throws ServiceException;

    void deleteClient(Long numId) throws ServiceException;
}
