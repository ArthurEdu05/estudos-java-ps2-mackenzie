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
            PreparedStatement pstmt = super.connect().prepareStatement(sql_insert);

            pstmt.setLong(1, v.getProprietarioId());
            pstmt.setString(2, v.getPlaca());
            int qtd = pstmt.executeUpdate();

            if(qtd >= 1){
                System.out.println("Veiculo inserido com sucesso");
                //provavelmente vou ter q pegar a generatedKey
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
        String sqlUpdate = "UPDATE veiculos SET proprietario_id= ?, placa=? WHERE id=?";
    }
    //Excluir Veiculo (DELETE)
    public void deleteVeiculo(){

    }
}
