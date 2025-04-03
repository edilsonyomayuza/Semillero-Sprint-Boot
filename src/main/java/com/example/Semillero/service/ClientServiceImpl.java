package com.example.Semillero.service;

import com.example.Semillero.entity.ClientEntity;
import com.example.Semillero.exception.ServiceException;
import com.example.Semillero.mapper.ClientMapper;
import com.example.Semillero.model.ClientDto;
import com.example.Semillero.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void deleteClient(Long numId) throws ServiceException {
        if (numId == null) {
            throw new ServiceException(400, "ID del cliente no puede ser nulo");
        }

        Optional<ClientEntity> clientOptional = clientRepository.findById(numId);

        if (clientOptional.isEmpty()) {
            throw new ServiceException(404, "Cliente no encontrado con ID: " + numId);
        }

        clientRepository.delete(clientOptional.get());
    }

    @Override
    public void updatePartialClient(Long numId, ClientDto clientDto) throws ServiceException{
        Optional<ClientEntity> optionalClient = clientRepository.findById(numId); //busca en bd el cliente con ese ID

        if(optionalClient.isEmpty()){
            throw new ServiceException(404, "Cliente no encontrado");
        }

        ClientEntity client = optionalClient.get(); //recupera del objeto optional el ClientEntity

        if(clientDto.getStrIdentificationType() != null){
            client.setStrIdentificationType(clientDto.getStrIdentificationType());
            System.out.println(client.getStrIdentificationType());
        }
        if(clientDto.getStrIdentification() != null){
            client.setStrIdentification(clientDto.getStrIdentification());
            System.out.println(client.getStrIdentification());
        }
        if(clientDto.getStrFirstName() != null){
            client.setStrFirstName(clientDto.getStrFirstName());
            System.out.println(client.getStrFirstName());
        }
        if(clientDto.getStrSecondName() != null){
            client.setStrSecondName(clientDto.getStrSecondName());
            System.out.println(client.getStrSecondName());
        }


        clientRepository.save(client);
    }

    @Override
    public void updateClient(Long numId, ClientDto clientDto) throws ServiceException {
        if (clientDto == null) {
            throw new ServiceException(400, "Datos del cliente requeridos");
        }

        Optional<ClientEntity> existingClientOpt = clientRepository.findById(numId);

        if (existingClientOpt.isEmpty()) {
            throw new ServiceException(404, "Cliente no encontrado");
        }

        ClientEntity updatedClient = new ClientEntity();
        updatedClient.setNumId(numId); // Mantener el mismo ID
        updatedClient.setStrIdentification(clientDto.getStrIdentification());
        updatedClient.setStrIdentificationType(clientDto.getStrIdentificationType());
        updatedClient.setStrFirstName(clientDto.getStrFirstName());
        updatedClient.setStrSecondName(clientDto.getStrSecondName());

        clientRepository.save(updatedClient);
    }


}
