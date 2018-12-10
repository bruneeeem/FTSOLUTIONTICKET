/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftsolution.servlet.pessoa;

import br.com.ftsolution.dao.PessoaDAO;
import br.com.ftsolution.model.Pessoa;
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
@WebServlet(name = "ConsultarPessoa", urlPatterns = {"/ConsultarPessoa"} )
public class ConsultarPessoa extends HttpServlet{
    
      @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Pessoa/consultarPessoa.jsp");
        dispatcher.forward(request, response);
            
    }
       
         @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = null;
        try {
         
            pessoa = pessoaDAO.pesquisar(id);

        } catch (Exception e) {
        }
        request.setAttribute("pessoa",pessoa);
        request.getRequestDispatcher("WEB-INF/Pessoa/resultadoConsultaPessoa.jsp").forward(request, response);
}
    
    
}
