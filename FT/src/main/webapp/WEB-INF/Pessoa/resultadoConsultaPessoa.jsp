<%-- 
    Document   : resultadoConsultaPessoa
    Created on : 10/12/2018, 10:07:45
    Author     : Bruno
--%>
<%@page import="br.com.ftsolution.model.Pessoa"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.com.ftsolution.dao.PessoaDAO"%>
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
        
        
        <form method="post" action="${pageContext.request.contextPath}/ConsultarPessoa">
        
                            <table border= 1>
                                        <tr>
                                            <td align=middle width=100>ID Pessoa</td>
                                            <td align=middle width=100>Nome</td>
                                            <td align=middle width=100>CPF</td>
                                            <td align=middle width=100>Email</td>
                                            <td align=middle width=120>Status</td>
                                            
                                        </tr>
                                         <tr>
                                            <td align=middle><c:out value="${pessoa.idPessoa}"/></td>
                                             <td align=middle><c:out value="${pessoa.nome}" /></td>
                                            <td align=middle><c:out value="${pessoa.cpf}"/></td>
                                            <td align=middle><c:out value="${pessoa.email}" /></td>
                                            <td align=middle><c:out value="${pessoa.status}" /></td>
                          
                                        </tr>
                                   
                                    </table>
                                            <br>
                               
                             <button type="reset" onclick="window.location.href = 'menu.jsp';">Voltar</button>
                        </form>
                            <form method="get" action="${pageContext.request.contextPath}/AlterarPessoa">
                                <button type="submit" value="${pessoa.idPessoa}" name="id">Alterar</button>
                            </form>
    </body>
</html>

    