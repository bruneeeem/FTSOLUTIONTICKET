<%-- 
    Document   : IncluirTicket
    Created on : 28/11/2018, 11:46:22
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Ticket</title>
    </head>
    <body>
        <h1>Cadastro Ticket</h1>
                <form method="post" action="${pageContext.request.contextPath}/IncluirTicket">
                    <label class="col-sm-2 col-form-label" for="titulo">Titulo</label>                
                    <div class="col-sm-5">
                       <input style="width: 300px;" required="required" type="text" name="titulo" />
                   </div>
                      <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="descricao">Descrição</label>
                          <div class="col-sm-10">
                            <textarea required="required" style="width: 900px;" name="descricao"></textarea>
                          </div>
                      </div>
                      <label class="col-sm-2 col-form-label" for="status">Status</label>                
                         <div class="col-sm-5">
                             <input style="width: 300px;" required="required" type="text" name="status" />
                        </div>
                       <label class="col-sm-2 col-form-label" for="dataAlteracao">Data de alteracão</label>                
                         <div class="col-sm-5">
                             <input style="width: 300px;" required="required" type="text" name="dataAlteracao"/>
                        </div>
                        <label class="col-sm-2 col-form-label" for="analista">Analista</label>                
                         <div class="col-sm-5">
                             <input style="width: 300px;" required="required" type="text" name="analista" />
                        </div>
                        <label class="col-sm-2 col-form-label" for="usuario">Usuario</label>                
                         <div class="col-sm-5">
                             <input style="width: 300px;" required="required" type="text" name="usuario" />
                        </div>
                      
                        <button type="submit">Salvar</button>
                         <button type="reset">Limpar</button>
                </form>
    </body>
</html>
