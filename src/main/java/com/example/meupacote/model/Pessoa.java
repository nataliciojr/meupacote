package com.example.meupacote.model;

import lombok.Data;

@Data
public class Pessoa {
    private Long id; // Identificador único da pessoa
    private String nome; // Nome da pessoa
    private String email; // Endereço de e-mail da pessoa
}
