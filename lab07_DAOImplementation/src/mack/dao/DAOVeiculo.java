package mack.dao;


import java.util.List;
import java.util.ArrayList;
import mack.model.Veiculo;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


public class DAOVeiculo extends DAO {


    //Criar Veiculo (CREATE)
    public void createVeiculo(Veiculo v){
        try{
            String sql_insert = "INSERT INTO veiculos (proprietario_id, placa)VALUES (?, ?)";
            PreparedStatement pstmt = super.connect().prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);

            pstmt.setLong(1, v.getProprietarioId());
            pstmt.setString(2, v.getPlaca());
            int qtd = pstmt.executeUpdate();

            if(qtd >= 1){
                System.out.println("Veiculo inserido com sucesso");
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                v.setId(rs.getLong(1));
                }

            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    //Consultar todos Veiculos (READ)
    public List <Veiculo> lstAllVeiculos(){
        List <Veiculo> lstResult = new ArrayList<>();
        try{
            Statement stmt = super.connect().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM veiculos");

            while(rs.next()){
                Veiculo aux = new Veiculo();
                aux.setId(rs.getLong("Id")); 
                aux.setProprietarioId(rs.getLong("proprietario_Id"));
                aux.setPlaca(rs.getString("placa"));
                lstResult.add(aux);
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        return lstResult;
    }

    //Atualizar Veiculo (UPDATE)
    public void updateVeiculo(Veiculo v){
        try{
        String sqlUpdate = "UPDATE veiculos SET proprietario_id=?, placa=? WHERE id=?";
        PreparedStatement pstmt = super.connect().prepareStatement(sqlUpdate);
        pstmt.setLong(1, v.getProprietarioId());
        pstmt.setString(2, v.getPlaca());
        pstmt.setLong(3, v.getId());
        int qtd = pstmt.executeUpdate();
        if(qtd >= 1){
            System.out.println("Veiculo atualizado com sucesso");
        } else{
            System.out.println("Nenhum registro encontrado");
        }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    //Excluir Veiculo (DELETE)
    public void deleteVeiculo(Veiculo v){
        try{
            String sqlDelete = "DELETE FROM veiculos WHERE id = ?";
            PreparedStatement pstmt = super.connect().prepareStatement(sqlDelete);
            pstmt.setLong(1, v.getId());

            int qtd = pstmt.executeUpdate();
            if(qtd>= 1){
                System.out.println("Veiculo deletado com sucesso");
            } else{
                System.out.println("Veiculo não encontrado");
            }


        } catch(Exception e){
            e.printStackTrace();
        }
         
    }
}
