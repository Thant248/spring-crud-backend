package com.example.springcrudbackend.dto;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employeedto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

}
