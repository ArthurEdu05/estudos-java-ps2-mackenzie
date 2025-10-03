package ps2.veiculoapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ps2.veiculoapp.dao.DAOProprietario;

import java.util.Scanner;
import java.util.List;
import ps2.veiculoapp.model.Proprietario;
import ps2.veiculoapp.model.Veiculo;
import ps2.veiculoapp.dao.DAOVeiculo;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class VeiculoappApplication implements CommandLineRunner {

	@Autowired
	private DAOProprietario DAOprop;

	@Autowired
	private DAOVeiculo DAOveic;

	public static void main(String[] args) {
		SpringApplication.run(VeiculoappApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("\n====== MENU PRINCIPAL ======");
			System.out.println("(1) Listar todos");
			System.out.println("(2) Buscar por dados especificos");
			System.out.println("(3) Criar um novo");
			System.out.println("(4) Alterar os dados");
			System.out.println("(5) Apagar por ID");
			System.out.println("(0) Sair");
			System.out.print("Escolha: ");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
				case 1:
					escolherEntidade(sc, "listar");
					break;
				case 2:
					escolherEntidade(sc, "buscar");
					break;
				case 3:
					escolherEntidade(sc, "criar");
					break;
				case 4:
					escolherEntidade(sc, "alterar");
					break;
				case 5:
					escolherEntidade(sc, "apagar");
					break;
				case 0:
					System.out.println("Saindo do sistema...");
					break;
				default:
					System.out.println("Opção inválida!");
			}
		} while (opcao != 0);
	}

	private void escolherEntidade(Scanner sc, String acao) {
		System.out.println("\nInteragir com:");
		System.out.println("(1) Proprietário");
		System.out.println("(2) Veículo");
		System.out.print("Digite a classe escolhida: ");
		int escolha = sc.nextInt();
		sc.nextLine();

		if (escolha != 1 && escolha != 2) {
			System.out.println("Opção inválida! Escolha apenas 1 ou 2.");
			return;
		}

		switch (acao) {
			case "listar":
				if (escolha == 1) {
					List<Proprietario> proprietarios = DAOprop.findAll();

					for (Proprietario p : proprietarios) {
						System.out.println(p);
					}
				} else {
					List<Veiculo> veiculos = DAOveic.findAll();

					for (Veiculo v : veiculos) {
						System.out.println(v);
					}
				}
				break;

			// inicio busca
			case "buscar":
				if (escolha == 1) {
					System.out.println("\nBuscar Proprietário por:");
					System.out.println("(1) ID");
					System.out.println("(2) Nome");
					System.out.println("(3) CPF");
					System.out.print("Escolha: ");
					int opProp = sc.nextInt();
					sc.nextLine();

					switch (opProp) {
						case 1:
							System.out.print("Digite o ID: ");
							Long idP = sc.nextLong();
							sc.nextLine();
							Proprietario p = DAOprop.findById(idP).orElse(null);
							if (p != null) {
								System.out.println(p);
							} else {
								System.out.println("Proprietário não encontrado!");
							}

							break;

						case 2:
							System.out.print("Digite o Nome: ");
							String nome = sc.nextLine();
							List<Proprietario> lista = DAOprop.findByNome(nome);
							if (lista.isEmpty()) {
								System.out.println("Nenhum proprietário encontrado!");
							} else {
								for (Proprietario prop : lista) {
									System.out.println(prop);
								}
							}
							break;

						case 3:
							System.out.print("Digite o CPF: ");
							String cpf = sc.nextLine();
							Proprietario pCpf = DAOprop.findByCpf(cpf);
							if (pCpf != null) {
								System.out.println(pCpf);
							} else {
								System.out.println("Proprietário não encontrado!");
							}
							break;

						default:
							System.out.println("Opção inválida!");
					}

				} else {
					System.out.println("\nBuscar Veículo por:");
					System.out.println("(1) ID");
					System.out.println("(2) Placa");
					System.out.print("Escolha: ");
					int opVeic = sc.nextInt();
					sc.nextLine();

					switch (opVeic) {
						case 1:
							System.out.print("Digite o ID: ");
							Long idV = sc.nextLong();
							sc.nextLine();
							Veiculo v = DAOveic.findById(idV).orElse(null);
							if (v != null) {
								System.out.println(v);
							} else {
								System.out.println("Veículo não encontrado!");
							}

							break;

						case 2:
							System.out.print("Digite a Placa: ");
							String placa = sc.nextLine();
							Veiculo vPlaca = DAOveic.findByPlaca(placa);
							if (vPlaca != null) {
								System.out.println(vPlaca);
							} else {
								System.out.println("Veículo não encontrado!");
							}

							break;

						default:
							System.out.println("Opção inválida!");
					}
				}
				break;

			// fim busca

			case "criar":
				if (escolha == 1) {
					Proprietario p = new Proprietario();
					System.out.print("Nome: ");
					p.setNome(sc.nextLine());
					System.out.print("CPF: ");
					p.setCpf(sc.nextLine());
					DAOprop.save(p);
					System.out.println("Proprietário cadastrado!");
				} else {
					Veiculo v = new Veiculo();
					System.out.print("Para adicionar veículo informe o ID do proprietário primeiramente.");

					System.out.print(" Digite o ID do Proprietário: ");
					Long idProp = sc.nextLong();
					sc.nextLine();

					Proprietario prop = DAOprop.findById(idProp).orElse(null);
					if (prop == null) {
						System.out.println("Proprietário não encontrado! Veículo não cadastrado.");
						return;
					}
					System.out.print("Placa: ");
					v.setPlaca(sc.nextLine());

					// Associar ao proprietário
					v.setProprietario(prop);

					DAOveic.save(v);
					System.out.println("Veículo cadastrado para o proprietário " + prop.getNome() + "!");
				}
				break;

			case "alterar":
				System.out.print("Digite o ID: ");
				Long idAltera = sc.nextLong();
				sc.nextLine();

				if (escolha == 1) {
					Proprietario p = DAOprop.findById(idAltera).orElse(null);
					if (p != null) {
						System.out.print("Novo nome: ");
						p.setNome(sc.nextLine());
						System.out.print("Novo cpf: ");
						p.setCpf(sc.nextLine());
						DAOprop.save(p);
						System.out.println("Proprietário atualizado!");
					} else {
						System.out.println("Proprietário não encontrado!");
					}
				} else {
					Veiculo v = DAOveic.findById(idAltera).orElse(null);
					if (v != null) {
						System.out.print("Nova placa: ");
						v.setPlaca(sc.nextLine());

						System.out.print("Novo ID do proprietário: ");
						Long idNovoProp = sc.nextLong();
						sc.nextLine();

						Proprietario novoProp = DAOprop.findById(idNovoProp).orElse(null);
						if (novoProp != null) {
							v.setProprietario(novoProp);
							DAOveic.save(v);
							System.out.println("Veículo atualizado!");
						} else {
							System.out.println("Proprietário não encontrado!");
						}
					} else {
						System.out.println("Veículo não encontrado!");
					}
				}
				break;

			case "apagar":
				System.out.print("Digite o ID: ");
				Long idDel = sc.nextLong();
				sc.nextLine();

				if (escolha == 1) {
					Proprietario p = DAOprop.findById(idDel).orElse(null);
					if (p != null) {
						DAOprop.deleteById(idDel);
						System.out.println("Proprietário apagado!");
					} else {
						System.out.println("Proprietário não encontrado!");
					}
				} else {
					Veiculo v = DAOveic.findById(idDel).orElse(null);
					if (v != null) {
						DAOveic.deleteById(idDel);
						System.out.println("Veículo apagado!");
					} else {
						System.out.println("Veículo não encontrado!");
					}
				}
				break;

		}
	}

}