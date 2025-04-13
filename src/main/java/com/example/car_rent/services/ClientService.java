package com.example.car_rent.services;

import com.example.car_rent.entities.Client;
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
            throw new IllegalArgumentException("Invalid client data");
        }
        this.clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    public Client getClientById(int id){
        return this.clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client not found"));
    }

    public void updateClient(Client client) {
        if (client.getId() <= 0 || client.getName() == null || client.getAddress() == null || client.getPhone() == null || client.getAge() <= 0) {
            throw new IllegalArgumentException("Invalid client data");
        }
        this.clientRepository.save(client);
    }

    public void deleteClient(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid client ID");
        }
        this.clientRepository.deleteById(id);
    }
}
