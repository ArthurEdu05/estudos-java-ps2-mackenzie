package ps2.veiculoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ps2.veiculoapp.dao.DAOProprietario;

@SpringBootApplication
public class VeiculoappApplication {

	@Autowired
	private DAOProprietario DAOprop;

	public static void main(String[] args) {
		SpringApplication.run(VeiculoappApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Proprietario p = new Proprietario();
		p.setCpf("888888888");
		p.setNome("Lucas");

	}


}
