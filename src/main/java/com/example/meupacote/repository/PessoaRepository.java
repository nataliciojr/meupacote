package com.example.meupacote.repository;

import java.util.List;
import java.util.Optional;

import com.example.meupacote.model.Pessoa;

public interface PessoaRepository {
    List<Pessoa> listarTodas(); // Método para obter todas as pessoas
    Optional<Pessoa> buscarPorId(Long id); // Método para obter uma pessoa por ID
    Pessoa salvar(Pessoa pessoa); // Método para salvar uma pessoa
    void excluirPorId(Long id); // Método para excluir uma pessoa por ID
    
}
