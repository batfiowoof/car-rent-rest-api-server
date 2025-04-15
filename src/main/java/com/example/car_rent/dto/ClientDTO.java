package com.example.car_rent.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private int id;
    private String name;
    private String address;
    private String phone;
    private int age;

}
