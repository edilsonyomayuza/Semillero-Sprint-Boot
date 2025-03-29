package com.example.Semillero.service;

import com.example.Semillero.entity.ClientEntity;
import com.example.Semillero.exception.ServiceException;
import com.example.Semillero.mapper.ClientMapper;
import com.example.Semillero.model.ClientDto;
import com.example.Semillero.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements IClientService{

    @Autowired
    private IClientRepository clientRepository;

    private ClientMapper mapper = new ClientMapper();

    @Override
    public List<ClientDto> showAllClients() {
        return clientRepository.findAll().stream()
                .map(clientEntity -> mapper.clientEntityToDTO(clientEntity)).
                toList();
    }

    @Override
    public void saveClient(ClientDto clientDto) throws ServiceException{
        if (clientDto == null){
            throw new ServiceException(400, "Contenido Nulo");
        }
        if (clientDto.getStrFirstName() == null){
            throw new ServiceException(400, "Primer nombre nulo");
        }
        if (clientDto.getStrSecondName() == null){
            throw new ServiceException(400, "Apellido nulo");
        }
        if (clientDto.getStrIdentification() == null){
            throw new ServiceException(400, "Identificación nulo");
        }

        ClientEntity client = mapper.clientMapper(clientDto);
        clientRepository.save(client);

    }

}
