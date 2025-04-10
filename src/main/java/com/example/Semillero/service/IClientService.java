package com.example.Semillero.service;

import com.example.Semillero.exception.ServiceException;
import com.example.Semillero.model.ClientDto;

import java.util.List;

public interface IClientService {

    List<ClientDto> showAllClients();

    void saveClient(ClientDto clientDto) throws ServiceException;

    void deleteClient(Long numId) throws ServiceException;

    void updatePartialClient(Long numId, ClientDto clientDto) throws ServiceException;

    void updateClient(Long numId, ClientDto clientDto) throws ServiceException;

}
