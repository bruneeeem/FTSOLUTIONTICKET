/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftsolution.servlet.ticket;

import br.com.ftsolution.dao.TicketsDAO;
import br.com.ftsolution.model.Tickets;
import java.io.IOException;
import java.sql.Date;
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
@WebServlet(name = "IncluirTicket", urlPatterns = {"/IncluirTicket"})
public class IncluirTicket extends HttpServlet{
    
    
     @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/Ticket/incluirTicket.jsp");
        dispatcher.forward(request, response);
    }
    
     @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        String statusStr = request.getParameter("status");
        String analistaStr = request.getParameter("analista");
        String usuarioStr = request.getParameter("usuario");
        
        int status = Integer.parseInt(statusStr);
        int analista = Integer.parseInt(analistaStr);
        int usuario = Integer.parseInt(usuarioStr);
        java.sql.Date data = null;
       
        Tickets ticket = new Tickets(titulo,descricao,status,analista,data,usuario);
        TicketsDAO ticketDAO = new TicketsDAO();
         try {
             
            ticketDAO.cadastrar(ticket);

        } catch (Exception e) {
            
        }
         
           request.setAttribute("ticket", ticket);
           RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "WEB-INF/Ticket/incluirTicket.jsp");
        dispatcher.forward(request, response);
  }
}