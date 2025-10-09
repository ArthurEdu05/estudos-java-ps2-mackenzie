package br.mackenzie.webservice.webservice.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.mackenzie.webservice.webservice.entities.Pessoa;

@RestController
@RequestMapping("/pessoas/")
public class ListaController {
    private List<Pessoa> pessoas;
    private int idCount;

    ListaController(){
        idCount = 0;
        pessoas = new ArrayList<>();
        pessoas.add(new Pessoa(idCount++, "Arthur", 20));
        pessoas.add(new Pessoa(idCount++, "Joaquim", 40));
    }
    //CREATE
    @PostMapping
    public Pessoa adicionarNome(@RequestBody(required = true) Pessoa p){
        p.setId(idCount++);
        pessoas.add(p);
        return p;
    }
    //READ
    @GetMapping
    public List<Pessoa> todosOsNomes(){
        return pessoas;
    }

    @GetMapping("/{id}")
    public Pessoa lerPorId(@PathVariable int id){
        for(int i = 0; i < pessoas.size(); i++){
            Pessoa aux = pessoas.get(i);
            if(aux.getId() == id){
                return aux;
            }
        }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada");
    }

    //UPDATE
    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable int id, @RequestBody Pessoa p){
        if(id != p.getId()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IDs diferentes");
        }
        for(int i=0; i<pessoas.size(); i++){
            Pessoa aux = pessoas.get(i);
            if(aux.getId() == id){
                aux.setNome(p.getNome());
                aux.setIdade(p.getIdade());
                return p;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada");
    }

    //DELETE
    @DeleteMapping("/{id}")
    public Pessoa apagar(@PathVariable() int id){
        Pessoa p = null;
        for(Pessoa aux : pessoas){
            if(aux.getId() == id){
                p = aux;
            }
        }
        pessoas.remove(p);
        return p;
    }
    
}
