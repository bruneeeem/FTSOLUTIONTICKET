/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftsolution.model;

import java.sql.Date;

/**
 *
 * @author Bruno
 */
public class Tickets {

  
    private int id;
    private Date dataIngresso;
    private String titulo;
    private String descricao;
    private int status;
    private int analista;
    private Date dataAlteracao;
   
    
    
    public Tickets(){
        
    }
    
    public Tickets(String titulo,String descricao,int status,int analista,Date dataAlteracao){
        this.titulo=titulo;
        this.descricao=descricao;
        this.status=status;
        this.analista=analista;
        this.dataAlteracao=dataAlteracao;
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
   
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getAnalista() {
        return analista;
    }
    
    public void setAnalista(int analista) {
        this.analista = analista;
    }
    
    public Date getDataAlteracao() {
        return dataAlteracao;
    }
    
    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
     
    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

}
