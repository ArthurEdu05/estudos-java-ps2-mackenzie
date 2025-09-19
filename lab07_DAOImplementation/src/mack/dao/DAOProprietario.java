package mack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mack.model.Proprietario;

public class DAOProprietario extends DAO{

    public List<Proprietario> listAllProprietarios(){
        List<Proprietario> listRet = new ArrayList<>();
        try {
            Statement stmt = super.connect().createStatement();

            //Consultando
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROPRIETARIOS");

            while(rs.next()){
                Proprietario aux = new Proprietario();
                aux.setId(rs.getLong("ID"));
                aux.setNome(rs.getString("nome"));
                aux.setCpf(rs.getString("cpf"));
                listRet.add(aux);
            }
         } catch (Exception e) {
            e.printStackTrace();
        }

        return listRet;
    }

    public void create(Proprietario p){
        try {
        //inserindo
            String sql_insert = "INSERT INTO PROPRIETARIOS (NOME, CPF) VALUES(?,?)";

            PreparedStatement pstmt = super.connect().prepareStatement(sql_insert);

            pstmt.setString(1,  p.getNome());
            pstmt.setString(2,p.getCpf());

            int qte = pstmt.executeUpdate();
            if(qte >=1)
                System.out.println("inserido com sucesso");
         } catch (Exception e) {
            e.printStackTrace();
        }
    }
}