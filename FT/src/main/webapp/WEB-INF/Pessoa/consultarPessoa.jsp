
<%-- 
    Document   : consultarTicket
    Created on : 30/11/2018, 09:41:06
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Pessoa</title>
    </head>
    <body>
        <h1>Consultar Pessoa</h1>
                            <div class="centralizarLogin">
                             <form  method="post" action="${pageContext.request.contextPath}/ConsultarPessoa">
                                 <label>ID PESSOA:&nbsp;&nbsp;<input required="required" onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode)))
                                       return true;
                                    else
                                       return false;" style="width: 50%;" type="text" name="id" id="id"/></label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <br><br>
                            <button onclick="busca()" type="submit">Procurar</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;         
                            <button type="button" onclick="window.location.href = 'menu.jsp';">Voltar</button>
                            </form>
                            </div>
    </body>
</html>