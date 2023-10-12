package com.example.frontend.service;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.frontend.model.Pessoa;

@Service
public class PessoaService {
    static final String URL_API_PESSOAS = "http://localhost:8080/pessoas"; //vai ir no backEnd

    RestTemplate restTemplate = new RestTemplate();

    public Pessoa[] getPessoas(){
        Pessoa[] pessoaResult = restTemplate.getForObject(URL_API_PESSOAS, Pessoa[].class);
        System.out.println(pessoaResult);
        return pessoaResult;
    }

    public void save(Pessoa pessoa){
        HttpEntity<Pessoa> requestBody = new HttpEntity<Pessoa>(pessoa);
        pessoa = restTemplate.postForObject(URL_API_PESSOAS, requestBody, Pessoa.class);
     }


}
