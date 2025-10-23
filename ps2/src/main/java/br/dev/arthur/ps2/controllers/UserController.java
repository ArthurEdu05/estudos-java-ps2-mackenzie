package br.dev.arthur.ps2.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import br.dev.arthur.ps2.entities.User;

import br.dev.arthur.ps2.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository rep;
    List<User> users = new ArrayList<>();
    long cont = 0;

    //CREATE - cadastra um novo usuário
    @PostMapping("/users")
    public User createUser(@RequestBody User newUser){
        if(newUser.getUsername() == null || newUser.getPassword() == null || newUser.getUsername().isEmpty() || newUser.getPassword().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return rep.save(newUser);
    }

    //READ - retorna todos os usuários
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return rep.findAll();
    }

    //READ - retorna um usuário pelo ID
    @GetMapping("users/{id}")
    public User getUserById(@PathVariable Long id){
        Optional<User> optional= rep.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    //DELETE - deleta um usuário pelo ID
    @DeleteMapping("users/{id}")
    public User deleteUserById(@PathVariable Long id){
        Optional<User> optional= rep.findById(id);
        if(optional.isPresent()){
            User del = optional.get();
            rep.deleteById(id);
            return del;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    }

