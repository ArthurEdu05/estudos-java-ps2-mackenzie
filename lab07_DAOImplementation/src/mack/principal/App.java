package mack.principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import mack.dao.DAOProprietario;
import mack.model.Proprietario;
import mack.dao.DAOVeiculo;
import mack.model.Veiculo;

public class App {
    public static void main(String[] args) throws Exception {
    //criação de um novo proprietário
       Proprietario p = new Proprietario();
       p.setNome("Ronaldo");
       p.setCpf("88888888-88");
       DAOProprietario daoProp = new DAOProprietario();
       daoProp.createProprietario(p);

    //Consultando todos os proprietários
       List<Proprietario> list1 = daoProp.listAllProprietarios();
       for (Proprietario proprietario : list1) {
            System.out.println(proprietario.getNome());
       }

   //Atualizando um proprietario
   p.setNome("Cristiano Ronaldo");
   daoProp.updateProprietario(p);

   //Consultando todos os proprietários após atualização
       List<Proprietario> list2 = daoProp.listAllProprietarios();
       for (Proprietario proprietario : list2) {
            System.out.println(proprietario.getNome());
       }

   //Deletar um proprietario
   //daoProp.deleteProprietario(p);
   //Nao quero que ele seja excluido do banco pois vou atribuir veiculos à ele
    
   //Consultando todos os proprietários após delete
     /*  List<Proprietario> list3 = daoProp.listAllProprietarios();
       for (Proprietario proprietario : list3) {
            System.out.println(proprietario.getNome());
       }
     */
    

    //Manipulação de veiculos
    //Criação de novos veiculos
    Veiculo v1 = new Veiculo();
    v1.setProprietarioId(p.getId());
    v1.setPlaca("GWM123456");

    DAOVeiculo daovei = new DAOVeiculo();
    daovei.createVeiculo(v1);


    Veiculo v2 = new Veiculo();
    v2.setProprietarioId(p.getId());
    v2.setPlaca("BMW123456");
    daovei.createVeiculo(v2);

    //Consultando os veiculos existentes
    List<Veiculo> lstVeiculos1 = daovei.lstAllVeiculos();
    for(Veiculo veiculo : lstVeiculos1){
        System.out.println("Id do proprietario: " + veiculo.getProprietarioId() + " - Placa: " + veiculo.getPlaca());
    }

    //Atualizando um veiculo
    v1.setPlaca("BYD123456");
    daovei.updateVeiculo(v1);

    //Consultando após atualização
    List<Veiculo> lstVeiculos2 = daovei.lstAllVeiculos();
    for(Veiculo veiculo : lstVeiculos2){
        System.out.println("Id do proprietario: " + veiculo.getProprietarioId() + " - Placa: " + veiculo.getPlaca());
    }
    //Deletando veiculo
    daovei.deleteVeiculo(v2);

    //Consultando todos veiculos após delete
    List<Veiculo> lstVeiculos3 = daovei.lstAllVeiculos();
    for(Veiculo veiculo : lstVeiculos3){
        System.out.println("Id do proprietario: " + veiculo.getProprietarioId() + " - Placa: " + veiculo.getPlaca());
    }
    
    }
}