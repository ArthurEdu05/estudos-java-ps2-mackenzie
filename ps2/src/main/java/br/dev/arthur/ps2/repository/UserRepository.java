package br.dev.arthur.ps2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.dev.arthur.ps2.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
