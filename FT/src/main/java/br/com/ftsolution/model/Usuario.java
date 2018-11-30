package br.com.ftsolution.model;

public class Usuario {
    //Construtor
    private Long idPessoa;
    private String login;
    private String senha;
    private String status;    
    //Construtor
    public Usuario() {
    }
    //Construtor

    public Usuario(Long idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario(String login, Long idPessoa, String senha, String status) {
        this.login = login;
        this.idPessoa = idPessoa;
        this.senha = senha;
        this.status = status;
    }
    //Construtor
    public Usuario(Long idPessoa, String login, String nome, String senha, String status) {
        this.idPessoa = idPessoa;
        this.login = login;
        this.senha = senha;
        this.status = status;
    }
    //Metodo - GET
    public Long getIdPessoa() {
        return idPessoa;
    }
    //Metodo - SET
    public void setIdPessoa(Long id) {
        this.idPessoa = idPessoa;
    }   
    //Metodo - GET
    public String getLogin() {
        return login;
    }
    //Metodo - SET
    public void setLogin(String login) {
        this.login = login;
    }
      //Metodo - GET
    public String getSenha() {
        return senha;
    }
    //Metodo - SET
    public void setSenha(String senha) {
        this.senha = senha;
    }
    //Metodo - GET
    public String getStatus() {
        return status;
    }
    //Metodo - SET
    public void setAtivo(String ativo) {
        this.status = status;
    }    
}
