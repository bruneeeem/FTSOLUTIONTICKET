<%-- 
    Document   : incluirPessoa
    Created on : 03/12/2018, 12:28:39
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Pessoa</title>
    </head>
    <body>
        <h1>Cadastro Pessoa</h1>
        <form method="post" action="${pageContext.request.contextPath}/IncluirPessoa">
                <label class="col-sm-2 col-form-label" for="nome">Nome</label>                
                    <div class="col-sm-5">
                       <input style="width: 300px;" required="required" type="text" name="nome" />
                   </div>  
                <label class="col-sm-2 col-form-label" for="cpf">CPF</label>                
                         <div class="col-sm-5">
                           <input style="width: 300px;" required="required" type="text" name="cpf" />
                        </div>
                 <label class="col-sm-2 col-form-label" for="email">Email</label>                
                         <div class="col-sm-5">
                             <input style="width: 300px;" required="required" type="text" name="email" />
                        </div>
                  <label class="col-sm-2 col-form-label" for="status">Status</label>                
                         <div class="col-sm-5">
                             <input style="width: 300px;" required="required" type="text" name="status" />
                        </div>
                        <br>
                        <button type="submit">Salvar</button>
                        <button type="reset">Limpar</button>
                        <button type="button" onclick="window.location.href = 'menu.jsp';">Voltar</button>
        
        </form>
    </body>
</html>
