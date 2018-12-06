
package br.com.ftsolution.dao;

import br.com.ftsolution.crudSistema.crudSistema;
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
public class TicketsDAO implements crudSistema<Tickets>{
    
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

    public TicketsDAO() {
        
    }
       
        @Override
        public void cadastrar(Tickets ticket) throws SQLException, Exception {
                               
         String sqlInserir =
            "INSERT INTO Ticket(titulo,descricao,status,analista,usuario)"
            + " VALUES (?,?,?,?,?)";
         
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
                preparedStatement.setInt(4, ticket.getAnalista());
                preparedStatement.setInt(5, ticket.getUsuario());
                
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
         public Tickets pesquisar(Integer id) throws SQLException, Exception {
             
              String sqlConsultar = " SELECT * FROM Ticket WHERE id = ?";         
             
              Connection connection = null;
              
               PreparedStatement preparedStatement = null;
             
               ResultSet result = null;
               try {
                   
                   connection = obterConexao();
            
                preparedStatement = connection.prepareStatement(sqlConsultar);

                preparedStatement.setInt(1, id);
                
                result = preparedStatement.executeQuery();
                
                if(result.next()){
                    
                    Tickets ticket = new Tickets();
                    ticket.setId(result.getInt("id"));
                    ticket.setTitulo(result.getString("titulo"));
                    ticket.setDescricao(result.getString("descricao"));
                    ticket.setDataIngresso(result.getDate("dataIngresso"));
                    ticket.setStatus(result.getInt("status"));
                    ticket.setDataAlteracao(result.getDate("dataAlteracao"));
                    ticket.setAnalista(result.getInt("analista"));
                    ticket.setUsuario(result.getInt("usuario"));
                    
                    return ticket;
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
          
          
         @Override
        public void alterar(Tickets ticket) throws SQLException, Exception {
                
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = obterConexao();
            String sql = "UPDATE Ticket "
                + " SET titulo = ?, descricao = ?, status= ?, dataAlteracao= ?,"
                + " analista = ?, usuario = ?"
                + " WHERE id = ?";
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            //Comando do banco            

             
            //Setando valores
            
            preparedStatement.setString(1, ticket.getTitulo());
            preparedStatement.setString(2, ticket.getDescricao());
            preparedStatement.setInt(3,ticket.getStatus());
            preparedStatement.setDate(4, ticket.getDataAlteracao());
            preparedStatement.setInt(5, ticket.getAnalista());
            preparedStatement.setInt(6,ticket.getUsuario() );           
            preparedStatement.setInt(7,ticket.getId());
            
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
             
}
