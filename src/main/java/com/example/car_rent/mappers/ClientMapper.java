package com.example.car_rent.mappers;

import com.example.car_rent.dto.ClientDTO;
import com.example.car_rent.entities.Client;

public class ClientMapper {
    public static ClientDTO toDTO(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .address(client.getAddress())
                .phone(client.getPhone())
                .age(client.getAge())
                .build();
    }
}
