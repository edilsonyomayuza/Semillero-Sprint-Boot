package com.example.Semillero.controller;

import com.example.Semillero.model.ClientDto;
import com.example.Semillero.model.ResponseDto;
import com.example.Semillero.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.example.Semillero.exception.ServiceException;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

@RestController
@RequestMapping(path = "/api")

public class ClientController {

    @Autowired
    private IClientService clientService ;
    private ResponseDto responseDto = new ResponseDto();

    @PostMapping(path = "/save")
    @Transactional
    public ResponseEntity<ResponseDto> saveClient(@RequestBody ClientDto clientDto){
        try{
            clientService.saveClient(clientDto);

            responseDto.setMessage("Solicitud Exitosa");
            responseDto.setStatusCode(201); // Código de estado HTTP válido

            return ResponseEntity.ok(responseDto);
        }catch (ServiceException e) { // Manejo correcto de la excepción
            responseDto.setMessage(e.getMessage());
            responseDto.setStatusCode(400); // Usar 400 si es un error del cliente

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<ClientDto>> saveClient(){

        return ResponseEntity.ok(clientService.showAllClients());

    }

    @DeleteMapping("/delete/{numId}")
    @Transactional
    public ResponseEntity<ResponseDto> deleteClient(@PathVariable Long numId) {
        try {
            clientService.deleteClient(numId);  // Eliminar el cliente con el numId
            responseDto.setMessage("Cliente eliminado exitosamente");
            responseDto.setStatusCode(200);
            return ResponseEntity.ok(responseDto);
        } catch (ServiceException e) {
            responseDto.setMessage(e.getMessage());
            responseDto.setStatusCode(400);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }
    }

    @PatchMapping ("/updatePartial/{numId}")
    @Transactional
    public ResponseEntity<ResponseDto> updateClient(@PathVariable Long numId, @RequestBody ClientDto clientDto){
        try {
            clientService.updatePartialClient(numId, clientDto);
            responseDto.setMessage("Cliente actualizado");
            responseDto.setStatusCode(200);
            return ResponseEntity.ok(responseDto);

        }catch (ServiceException e){
            responseDto.setMessage(e.getMessage());
            responseDto.setStatusCode(e.getStatusCode());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }
    }

    @PutMapping(path = "/updateAll/{numId}")
    @Transactional
    public ResponseEntity<?> updateClientAll(@PathVariable Long numId, @RequestBody ClientDto clientDto) {
        try {
            clientService.updateClient(numId, clientDto);
            responseDto.setMessage("Cliente actualizado");
            responseDto.setStatusCode(200);
            return ResponseEntity.ok(responseDto);
        } catch (ServiceException e) {
            responseDto.setMessage(e.getMessage());
            responseDto.setStatusCode(e.getStatusCode());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }
    }

}
