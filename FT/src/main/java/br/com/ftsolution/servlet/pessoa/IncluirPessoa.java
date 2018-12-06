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
import java.io.IOException;
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
@WebServlet(name = "IncluirPessoa", urlPatterns = {"/IncluirPessoa"})
public class IncluirPessoa extends HttpServlet {
    
         @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/Pessoa/incluirPessoa.jsp");
        dispatcher.forward(request, response);
    }
      @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String statusStr = request.getParameter("status");
       
        int status = Integer.parseInt(statusStr);
    
       
        Pessoa pessoa = new Pessoa(nome,cpf,email,status);
        PessoaDAO pessoaDAO = new PessoaDAO();
         try {
             
            pessoaDAO.cadastrar(pessoa);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         
           request.setAttribute("pessoa", pessoa);
           RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "WEB-INF/Pessoa/incluirPessoa.jsp");
        dispatcher.forward(request, response);
  }
    
     
}
