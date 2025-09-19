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
       Proprietario p = new Proprietario();
       p.setNome("Ronaldo");
       p.setCpf("88888888-88");
       DAOProprietario daoProp = new DAOProprietario();
       daoProp.create(p);

       List<Proprietario> list = daoProp.listAllProprietarios();

       for (Proprietario proprietario : list) {
            System.out.println(proprietario.getNome());
       }

            

    }
}