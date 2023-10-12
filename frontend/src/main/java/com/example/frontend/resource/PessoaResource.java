package com.example.frontend.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.frontend.model.Pessoa;
import com.example.frontend.service.PessoaService;

@Controller
public class PessoaResource {
    private PessoaService pessoaService;

    public PessoaResource(PessoaService pessoaService) {
        super();
        this.pessoaService = pessoaService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/lista-pessoas")
    public String listaPessoas(Model model){
        Pessoa[] pessoas = pessoaService.getPessoas(); 
        model.addAttribute("pessoas", pessoas);
        return "lista-pessoas";
    }

    @GetMapping("/cadastra-pessoa")
    private String cadastraPessoa(Model model){
        return "cadastra-pessoa";
    }

    @PostMapping(value="salvar")
    public String save(@RequestParam("nome") String nome, @RequestParam("idade") int idade, Model model){
        Pessoa pessoa = new Pessoa(nome, idade);
        pessoaService.save(pessoa);
        Pessoa[] pessoas = pessoaService.getPessoas();
        model.addAttribute("pessoas",pessoas);
        return "/lista-pessoas";
    }
}
