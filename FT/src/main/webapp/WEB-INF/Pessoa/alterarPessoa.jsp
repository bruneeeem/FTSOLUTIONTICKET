<%-- 
    Document   : alterarPessoa
    Created on : 10/12/2018, 10:28:34
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Pessoa</title>
    </head>
    <body>
        <h1>Alterar Pessoa</h1>
        <form method="post" action="${pageContext.request.contextPath}/AlterarPessoa">
            <input type="hidden" value="${id}" name="codPessoa" id="codPessoa"/>

            <label class="col-sm-2 col-form-label" for="nome">Nome</label>
            <div class="col-sm-5"> 
                <input style="width: 250px;" id="nome" required="required" type="text" value="${pessoa.nome}" name="nome" id="nome" />
            </div> 
            <label class="col-sm-2 col-form-label" for="cpf">Cpf</label>
            <div class="col-sm-10">
                <textarea required="required" style="width: 900px;" id="cpf" style="width: 50%;"  name="cpf">${pessoa.cpf}</textarea>
            </div>
            <label class="col-sm-2 col-form-label" for="email">Email</label>
            <div class="col-sm-10">
                <textarea required="required" style="width: 900px;" id="email" style="width: 50%;"  name="email">${pessoa.email}</textarea>
            </div>
            <label class="col-sm-2 col-form-label" for="status">Status</label>
            <div>
                <input style="width: 250px;" id="status" required="required" type="text" value="${pessoa.status}" name="status" id="status" />
            </div>

            <button type="submit">Salvar</button>
            <button type="reset">Limpar</button>
            <button type="button" onclick="window.location.href = 'menu.jsp';">Voltar</button>

        </form>
    </body>
</html>
