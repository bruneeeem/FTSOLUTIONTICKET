<%-- 
    Document   : resultadoConsultaTicket
    Created on : 30/11/2018, 10:59:15
    Author     : Bruno
--%>


<%@page import="br.com.ftsolution.model.Tickets"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.com.ftsolution.dao.TicketsDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Ticket</title>
    </head>
    <body>
        <h1>Resultado consulta do ticket</h1>
        
        
        <form method="post" action="${pageContext.request.contextPath}/ConsultarTicket">
        
                            <table border= 1>
                                        <tr>
                                            <td align=middle width=100>ID Entidade</td>
                                            <td align=middle width=100>Titulo</td>
                                            <td align=middle width=100>Descricao</td>
                                            <td align=middle width=100>Data de Ingresso</td>
                                            <td align=middle width=120>Status</td>
                                            <td align=middle width=100>Data de Alteracão</td>
                                            <td align=middle width=100>Analista</td>
                                            <td align=middle width=150>Usuario</td>
                                        </tr>
                                         <tr>
                                            <td align=middle><c:out value="${ticket.id}"/></td>
                                            <td align=middle><c:out value="${ticket.titulo}"/></td>
                                            <td align=middle><c:out value="${ticket.descricao}" /></td>
                                            <td align=middle><fmt:formatDate value="${ticket.dataIngresso}"/></td>
                                            <td align=middle><c:out value="${ticket.status}" /></td>
                                            <td align=middle><fmt:formatDate value="${ticket.dataAlteracao}"/></td>
                                            <td align=middle><c:out value="${ticket.analista}" /></td>
                                            <td align=middle><c:out value="${ticket.usuario}" /></td>
                                           
                                        </tr>
                                   
                                    </table>
                                            <br>
                               
                             <button type="reset" onclick="window.location.href = 'menu.jsp';">Voltar</button>
                        </form>
                            <form method="get" action="${pageContext.request.contextPath}/AlterarTicket">
                                <button type="submit" value="${ticket.id}" name="id">Alterar</button>
                            </form>
    </body>
</html>
