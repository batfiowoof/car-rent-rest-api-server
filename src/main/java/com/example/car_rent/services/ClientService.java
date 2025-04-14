package com.example.car_rent.services;

import com.example.car_rent.entities.Client;
import com.example.car_rent.enums.ClientErrorType;
import com.example.car_rent.exceptions.ClientException;
import com.example.car_rent.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void createClient(Client client) {
        if (client.getName() == null || client.getAddress() == null || client.getPhone() == null || client.getAge() <= 0) {
            throw new ClientException(ClientErrorType.INVALID_DATA);
        }
        this.clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    public Client getClientById(int id){
        return this.clientRepository.findById(id).orElseThrow(() -> new ClientException(ClientErrorType.NOT_FOUND));
    }

    public void updateClient(Client client) {
        if (client.getId() <= 0 || client.getName() == null || client.getAddress() == null || client.getPhone() == null || client.getAge() <= 0) {
            throw new ClientException(ClientErrorType.INVALID_DATA);
        }
        this.clientRepository.save(client);
    }

    public void deleteClient(int id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientException(ClientErrorType.NOT_FOUND);
        }
        this.clientRepository.delete(id);
    }
}
