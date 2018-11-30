/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftsolution.servlet.ticket;

import br.com.ftsolution.dao.TicketsDAO;
import br.com.ftsolution.model.Tickets;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "AlterarTicket", urlPatterns = {"/AlterarTicket"})
public class AlterarTicket extends HttpServlet{
    
        @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        
        Tickets ticket = null;
        try {
            ticket = TicketsDAO.PesquisarrTicket(id);
            
        } catch (Exception e) {
             e.printStackTrace();
        }
        request.setAttribute("id", id);
        request.setAttribute("ticket", ticket);

        //Request diretorio
        request.getRequestDispatcher("WEB-INF/Ticket/alterarTicket.jsp")
                .forward(request, response); 
        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("codTicket"));
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        String statusStr = request.getParameter("status");
        String dataAlteracaoStr = request.getParameter("dataAlteracao");
        String analistaStr = request.getParameter("analista");
        String usuarioStr = request.getParameter("usuario");
        
        int status = Integer.parseInt(statusStr);
        int analista = Integer.parseInt(analistaStr);
        int usuario = Integer.parseInt(usuarioStr);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = null;
        
        
         try {
             //Date dataAlteracao =  formato.parse(dataAlteracaoStr);
             data = new java.sql.Date(formato.parse(dataAlteracaoStr).getTime());
         } catch (ParseException ex) {
             Logger.getLogger(IncluirTicket.class.getName()).log(Level.SEVERE, null, ex);
         }
            Tickets ticket = new Tickets(titulo,descricao,status,analista,data,usuario);
            ticket.setId(id);
         try {
          
             TicketsDAO.alterar(ticket);

        } catch (Exception e) {
            
        }
           request.setAttribute("id", id);
           request.setAttribute("ticket", ticket);
           RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "WEB-INF/Ticket/consultarTicket.jsp");
        dispatcher.forward(request, response);
  }
    
    
    
    
}
