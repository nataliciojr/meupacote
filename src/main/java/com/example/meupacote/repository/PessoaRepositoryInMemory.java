package com.example.meupacote.repository;
import org.springframework.stereotype.Repository;

import com.example.meupacote.model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PessoaRepositoryInMemory implements PessoaRepository {
    private final List<Pessoa> pessoas = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public List<Pessoa> listarTodas() {
        return new ArrayList<>(pessoas);
    }

    @Override
    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoas.stream()
                .filter(pessoa -> pessoa.getId().equals(id))
                .findFirst();
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        if (pessoa.getId() == null) {
            pessoa.setId(idGenerator.getAndIncrement());
        } else {
            pessoas.removeIf(p -> p.getId().equals(pessoa.getId()));
        }

        pessoas.add(pessoa);
        return pessoa;
    }

    @Override
    public void excluirPorId(Long id) {
        pessoas.removeIf(pessoa -> pessoa.getId().equals(id));
    }
}