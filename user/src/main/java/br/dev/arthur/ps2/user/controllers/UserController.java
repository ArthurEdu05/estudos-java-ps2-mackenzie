package br.dev.arthur.ps2.user.controllers;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.dev.arthur.ps2.user.entities.User;
import br.dev.arthur.ps2.user.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository rep;

    List<User> usuarios = new ArrayList<>();
    long cont = 0;

    /*UserController(){
        usuarios.add(new User (cont++,"arthur", "123"));
        usuarios.add(new User (cont++,"joaquim", "321"));
        usuarios.add(new User (cont++,"Isa", "333"));


    }*/


    //CREATE
    @PostMapping("/users")
    public User criarUsuario(@RequestBody User novoUsuario){
        if(novoUsuario.getNome() == null || novoUsuario.getSenha() == null || novoUsuario.getNome().isEmpty() || novoUsuario.getSenha().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return rep.save(novoUsuario);
        
    }
    //READ
    @GetMapping("/users")
    public List<User> lerUsuarios(){
        return rep.findAll();
    }


    @GetMapping("/users/{id}")
    public User lerUsuarioPeloId(@PathVariable long id){
       /*  for(User u: usuarios){
            if(u.getId() == id){
                return u;
            }
        }*/
        Optional<User> optional= rep.findById(id);
        if(optional.isPresent()) return optional.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    //UPDATE
    @PutMapping("/users/{id}")
    public User atualizarUsuarioPeloId(@RequestBody User novosDados, @PathVariable long id){
        Optional<User> optional= rep.findById(id);
        if(optional.isPresent()){
            User u = optional.get();
            u.setNome(novosDados.getNome());
            u.setSenha(novosDados.getSenha());
            return rep.save(u);
        }
       
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/users/{id}")
    public User apagarPeloId(@PathVariable long id){
        /* for(int i = 0; i<usuarios.size(); i++){
            User u = usuarios(i);
            if(u.getId() == id){
                usuarios.remove(i);
                return u;
            }*/
        Optional<User> optional = rep.findById(id);
        if(optional.isPresent()){
            User u = optional.get();
            rep.deleteById(id);
            return u;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
