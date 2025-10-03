package ps2.veiculoapp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ps2.veiculoapp.model.Veiculo;
public interface DAOVeiculo extends JpaRepository<Veiculo, Long>{

    Veiculo findByPlaca(String placa);
}
