package mack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mack.model.Proprietario;
//Implementação de CRUD
public class DAOProprietario extends DAO{

    //inserção (CREATE)
    public void createProprietario(Proprietario p){
        try {
        
            String sql_insert = "INSERT INTO PROPRIETARIOS (NOME, CPF) VALUES(?,?)";

            PreparedStatement pstmt = super.connect().prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,  p.getNome());
            pstmt.setString(2,p.getCpf());

            int qte = pstmt.executeUpdate();
            if(qte >=1)
                System.out.println("inserido com sucesso");
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                p.setId(rs.getLong(1)); 
            }

         } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //consulta (READ)
    public List<Proprietario> listAllProprietarios(){
        List<Proprietario> listRet = new ArrayList<>();
        try {
            Statement stmt = super.connect().createStatement();
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

    //Atualizar (UPDATE)
    public void updateProprietario(Proprietario p){
        try{
            String sql_update = "UPDATE proprietarios SET nome = ?, cpf = ? WHERE id = ?";
            PreparedStatement pstmt = super.connect().prepareStatement(sql_update);

            pstmt.setString(1, p.getNome());
            pstmt.setString(2, p.getCpf());
            pstmt.setLong(3, p.getId());
            int qtd =pstmt.executeUpdate();
            if(qtd>= 1){
                System.out.println("Atualizado com sucesso");
            } else{
                System.out.println("Nenhum registrado encontrado");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //DELETE
    public void deleteProprietario(Proprietario p){
        try{
        String sql_delete = "DELETE FROM proprietarios WHERE id = ?";
        PreparedStatement pstmt = super.connect().prepareStatement(sql_delete);
        
        pstmt.setLong(1, p.getId());
        int qtd = pstmt.executeUpdate();
        
        if(qtd >= 1){
            System.out.println("Proprietario removido com sucesso");
        } else{
            System.out.println("Não foi possível remover");
        }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    
}