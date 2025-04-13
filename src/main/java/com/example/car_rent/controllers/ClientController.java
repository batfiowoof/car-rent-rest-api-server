package com.example.car_rent.controllers;

import com.example.car_rent.entities.Client;
import com.example.car_rent.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        try {
            List<Client> clients = clientService.getAllClients();
            return ResponseEntity.ok(clients);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid client ID");
        }
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable int id) {
        try {
            Client client = clientService.getClientById(id);
            return ResponseEntity.ok(client);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid client ID");
        }
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        try {
            clientService.createClient(client);
            return ResponseEntity.ok(client);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid client data");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client client) {
        try {
            client.setId(id);
            this.clientService.updateClient(client);
            return ResponseEntity.ok(client);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid client data");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid client ID");
        }
    }
}
