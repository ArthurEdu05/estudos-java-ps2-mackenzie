package mack.model;

public class Proprietario {
    private Long id;
    private String nome;
    private String cpf;

    public Proprietario(){
        
    }

    public Proprietario(Long id, String nome, String cpf){
        this.id=id;
        this.nome=nome;
        this.cpf=cpf;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setCpf(String cpf){
        this.cpf=cpf;
    }

    public Long getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }
}