package ps2.veiculoapp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import ps2.veiculoapp.model.Proprietario;
import java.util.List;
public interface DAOProprietario extends JpaRepository<Proprietario, Long>{
    List<Proprietario> findByNome(String nome);
    Proprietario findByCpf(String cpf);
}
