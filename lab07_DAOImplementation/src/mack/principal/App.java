package mack.principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import mack.dao.DAOProprietario;
import mack.model.Proprietario;

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
   daoProp.deleteProprietario(p);

   //Consultando todos os proprietários após delete
       List<Proprietario> list3 = daoProp.listAllProprietarios();
       for (Proprietario proprietario : list3) {
            System.out.println(proprietario.getNome());
       }
    }
}