/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ftsolution.servlet.ticket;

import br.com.ftsolution.dao.TicketsDAO;
import br.com.ftsolution.model.Tickets;
import java.io.IOException;
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
@WebServlet(name = "ConsultarTicket", urlPatterns = {"/ConsultarTicket"} )
public class ConsultarTicket extends HttpServlet{
    
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Ticket/consultarTicket.jsp");
        dispatcher.forward(request, response);
            
    }       
         @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        TicketsDAO ticketDAO = new TicketsDAO();
        Tickets ticket = null;
        try {
         
            ticket = ticketDAO.pesquisar(id);

        } catch (Exception e) {
        }
        request.setAttribute("ticket", ticket);
        request.getRequestDispatcher("WEB-INF/Ticket/resultadoConsultaTicket.jsp").forward(request, response);
}
}