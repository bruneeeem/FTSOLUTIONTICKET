package br.com.ftsolution.dao;

import br.com.ftsolution.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    //Conexao do banco
    Connection conexao;

    //Construtor
    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public static Connection obterConexao() throws ClassNotFoundException, SQLException {
        //
        Connection conn = null;
        // Passo 1: Registar Driver JBDC
        Class.forName("com.mysql.jdbc.Driver");
        // Passo 2: Obter a conexão
        conn = DriverManager.getConnection(
                "jdbc:mysql://ftstectickets.mysql.dbaas.com.br:3306/ftstectickets?zeroDateTimeBehavior=convertToNull",
                "ftstectickets",
                "FTserv2310!");

        return conn;
    }

   

    public static Usuario verificar(Usuario usuario) throws SQLException, Exception {
        
        String ret = null;
        String user = null;
        String pass = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
            
        try {
            conn = obterConexao();
            String sql = "SELECT * FROM Usuario WHERE login = ?";
            
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getLogin());
            
            rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                user = rs.getString("login");
                pass = rs.getString("senha");
                

                if (user.equalsIgnoreCase(user) && pass.equalsIgnoreCase(pass)) {
                    usuario.setIdPessoa(rs.getLong("idPessoa"));
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                    return usuario;
                } 
            }
            return usuario;
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
    }

}