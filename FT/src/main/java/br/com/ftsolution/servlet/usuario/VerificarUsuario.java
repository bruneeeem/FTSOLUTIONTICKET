package br.com.ftsolution.servlet.usuario;

import br.com.ftsolution.dao.UsuarioDAO;
import br.com.ftsolution.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet(name = "VerificarUsuario", urlPatterns = {"/VerificarUsuario"})
public class VerificarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("username");
        String senha = request.getParameter("userPass");
        
        Usuario u = new Usuario(login, senha);
        String user = null;
        
        try {
            UsuarioDAO.verificar(u);
            user = u.getLogin();
            if(user==null || login==null){
                response.sendRedirect("index.html");
            }
            else if (user.equals(login)) {
                session.setAttribute("usuario", u.getIdPessoa());
			response.sendRedirect("menu.jsp");                
            }       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
