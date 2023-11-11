package com.example.meupacote.controller;



// No changes needed, removing unused import statement
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.meupacote.model.Pessoa;
import com.example.meupacote.service.PessoaService;

import java.util.List;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaService pessoaService;


    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public String listarPessoas(Model model) {
        List<Pessoa> pessoas = pessoaService.listarTodas();
        model.addAttribute("pessoas", pessoas);
        return "pessoa/listar";
    }

    @GetMapping("/{id}")
    public String visualizarPessoa(@PathVariable Long id, Model model) {
        Pessoa pessoa = pessoaService.buscarPorId(id).orElse(null);
        model.addAttribute("pessoa", pessoa);
        return "pessoa/visualizar";
    }

    @GetMapping("/nova")
    public String formularioNovaPessoa(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "pessoa/nova";
    }

    @PostMapping("/nova")
    public String salvarNovaPessoa(@ModelAttribute Pessoa pessoa) {
        pessoaService.salvar(pessoa);
        return "redirect:/pessoas";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarPessoa(@PathVariable Long id, Model model) {
        Pessoa pessoa = pessoaService.buscarPorId(id).orElse(null);
        model.addAttribute("pessoa", pessoa);
        return "pessoa/editar";
    }

    @PostMapping("/editar/{id}")
    public String salvarPessoaEditada(@PathVariable Long id, @ModelAttribute Pessoa pessoa) {
        pessoa.setId(id);
        pessoaService.salvar(pessoa);
        return "redirect:/pessoas";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPessoa(@PathVariable Long id) {
        pessoaService.excluirPorId(id);
        return "redirect:/pessoas";
    }
}
