package com.example.meupacote.service;

import org.springframework.stereotype.Service;

import com.example.meupacote.model.Pessoa;
import com.example.meupacote.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listarTodas() {
        return pessoaRepository.listarTodas();
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.buscarPorId(id);
    }

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.salvar(pessoa);
    }

    public void excluirPorId(Long id) {
        pessoaRepository.excluirPorId(id);
    }
}