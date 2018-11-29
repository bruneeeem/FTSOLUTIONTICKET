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
 * @author Bruno
 */
public class TicketsDAO {
    
            Connection conexao;
    
            public TicketsDAO(Connection conexao) {
        
            this.conexao = conexao;
     }
        
       public static Connection obterConexao() throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
           
        Class.forName("com.mysql.jdbc.Driver");
        
        conn = DriverManager.getConnection(
                "jdbc:mysql://ftstectickets.mysql.dbaas.com.br:3306/ftstectickets?zeroDateTimeBehavior=convertToNull",
                "ftstectickets",
                "FTserv2310!");
        return  conn;
    
 }
         public static void inserirTicket(Tickets ticket) throws SQLException, Exception {
         
         String sqlInserir =
            "INSERT INTO Ticket(titulo,descricao,status,dataAlteracao,analista,usuario)"
            + " VALUES (?,?,?,?,?,?)";
         
             Connection connection = null;
             
             PreparedStatement preparedStatement = null;
               
                try {
                //Abre uma conexão com o banco de dados
                connection = obterConexao();
                //Cria um statement para execução de instruções SQL
                preparedStatement = connection.prepareStatement(sqlInserir);
                
              
                preparedStatement.setString(1, ticket.getTitulo());
                preparedStatement.setString(2, ticket.getDescricao());
                preparedStatement.setInt(3, ticket.getStatus());
                preparedStatement.setDate(4, ticket.getDataAlteracao());
                preparedStatement.setInt(5, ticket.getAnalista());
                preparedStatement.setInt(6, ticket.getUsuario());
                
                preparedStatement.execute();         
                
                } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
  
         }
         }
}
