/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftsolution.model;

public class Pessoa {

    private int idPessoa;
    private String nome;
    private String cpf;
    private String email;
    private int status;
    
    public Pessoa(String nome,String cpf,String email,int status){
        
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.status = status;
        
    }

    public Pessoa() {
        
    }
 
    public int getIdPessoa() {
        return idPessoa;
    }

   
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

  
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

   
    public int getStatus() {
        return status;
    }

   
    public void setStatus(int status) {
        this.status = status;
    } 
   
}
