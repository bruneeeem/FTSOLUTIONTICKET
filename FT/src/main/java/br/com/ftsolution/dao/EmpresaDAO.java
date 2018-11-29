/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftsolution.dao;

import br.com.ftsolution.model.Tickets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Produto019
 */
public class EmpresaDAO {
    
    Connection conexao;
    
            public EmpresaDAO(Connection conexao) {
        
            this.conexao = conexao;
    
    }
}