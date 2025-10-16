package br.dev.arthur.ps2.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.arthur.ps2.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
