/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftsolution.servlet.pessoa;

import br.com.ftsolution.dao.PessoaDAO;
import br.com.ftsolution.dao.TicketsDAO;
import br.com.ftsolution.model.Pessoa;
import br.com.ftsolution.model.Tickets;
import br.com.ftsolution.servlet.ticket.IncluirTicket;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "AlterarPessoa", urlPatterns = {"/AlterarPessoa"})
public class AlterarPessoa extends HttpServlet{
    
            @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Pessoa pessoa = null;
        PessoaDAO pessoaDAO = new PessoaDAO();
        try {
           pessoa = pessoaDAO.pesquisar(id);
            
        } catch (Exception e) {
             e.printStackTrace();
        }
        request.setAttribute("id", id);
        request.setAttribute("pessoa", pessoa);

        //Request diretorio
        request.getRequestDispatcher("WEB-INF/Pessoa/alterarPessoa.jsp")
                .forward(request, response); 
          
    }
     @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("codPessoa"));
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String statusStr = request.getParameter("status");
        
        
        
        int status = Integer.parseInt(statusStr);
     
  
            Pessoa pessoa = new Pessoa(nome,cpf,email,status);
            pessoa.setIdPessoa(id);
            PessoaDAO pessoaDAO = new PessoaDAO();
         try {
          
             pessoaDAO.alterar(pessoa);

        } catch (Exception e) {
             System.out.println(e.getMessage());
            
        }
           request.setAttribute("id", id);
           request.setAttribute("pessoa", pessoa);
           RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "WEB-INF/Pessoa/consultarPessoa.jsp");
        dispatcher.forward(request, response);
  }
    
    
    
}
