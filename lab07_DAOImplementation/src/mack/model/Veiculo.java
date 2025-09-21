package mack.model;

public class Veiculo {

    private Long id;
    private Long proprietarioId;
    private String placa;

    public Veiculo(){

    }

    public Veiculo(Long id, Long proprietarioId, String placa){
        this.id = id;
        this.proprietarioId = proprietarioId;
        this.placa = placa;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setProprietarioId(Long proprietarioId){
        this.proprietarioId = proprietarioId;
    }
    public void setPlaca(String placa){
        this.placa = placa;
    }

    public Long getId(){
        return id;
    }
    public Long getProprietarioId(){
        return proprietarioId;
    }
    public String getPlaca(){
        return placa;
    }
}
