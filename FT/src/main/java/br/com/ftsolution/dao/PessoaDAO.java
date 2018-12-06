/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftsolution.dao;

import br.com.ftsolution.crudSistema.crudSistema;
import static br.com.ftsolution.dao.TicketsDAO.obterConexao;
import br.com.ftsolution.model.Pessoa;
import br.com.ftsolution.model.Tickets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bruno
 */
public class PessoaDAO implements crudSistema<Pessoa> {
    
           Connection conexao;
    
            public PessoaDAO(Connection conexao) {
        
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

    public PessoaDAO() {
        
    }

    @Override
    public void alterar(Pessoa pessoa) throws SQLException, Exception {
        
         Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
                 try {
            //Abre uma conexão com o banco de dados
            connection = obterConexao();
            String sql = "UPDATE Pessoa "
                + " SET nome = ?, cpf = ?, o email= ?, status= ?,"
                + " WHERE idPessoa = ?";
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            //Comando do banco            

             
            //Setando valores
            
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getCpf());
            preparedStatement.setString(3, pessoa.getEmail());
            preparedStatement.setInt(4, pessoa.getStatus());
            preparedStatement.setInt(5, pessoa.getIdPessoa());
            
            preparedStatement.executeUpdate();
            
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
                
    @Override
    public void cadastrar(Pessoa pessoa) throws SQLException, Exception {
        
         String sqlInserir =
            "INSERT INTO Pessoa(nome,cpf,o email,status)"
            + " VALUES (?,?,?,?)";
          
               Connection connection = null;
             
               PreparedStatement preparedStatement = null;
               
                try {
                //Abre uma conexão com o banco de dados
                connection = obterConexao();
                //Cria um statement para execução de instruções SQL
                preparedStatement = connection.prepareStatement(sqlInserir);
                
              
                preparedStatement.setString(1, pessoa.getNome());
                preparedStatement.setString(2, pessoa.getCpf());
                preparedStatement.setString(3, pessoa.getEmail());
                preparedStatement.setInt(4, pessoa.getStatus());
                
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

    @Override
    public Pessoa pesquisar(Integer id) throws SQLException, Exception {
         String sqlConsultar = " SELECT * FROM Pessoa WHERE idPessoa = ?"; 
         
                       Connection connection = null;
              
               PreparedStatement preparedStatement = null;
             
               ResultSet result = null;
               try {
                   
                   connection = obterConexao();
            
                preparedStatement = connection.prepareStatement(sqlConsultar);

                preparedStatement.setInt(1, id);
                
                result = preparedStatement.executeQuery();
                
                if(result.next()){
                    
                    Pessoa pessoa = new Pessoa();
                    pessoa.setIdPessoa(result.getInt("idPessoa"));
                    pessoa.setNome(result.getString("nome"));
                    pessoa.setCpf(result.getString("cpf"));
                    pessoa.setEmail(result.getString("o email"));
                    pessoa.setStatus(result.getInt("status"));
                 
                    return pessoa;
                }
                    
               }finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
                return null;     
    }
    
}
