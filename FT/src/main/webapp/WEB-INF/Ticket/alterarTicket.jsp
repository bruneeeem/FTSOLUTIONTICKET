<%-- 
    Document   : alterarTicket
    Created on : 30/11/2018, 13:38:17
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alterar Ticket</h1>
        <form method="post" action="${pageContext.request.contextPath}/AlterarTicket">
            <input type="hidden" value="${id}" name="codTicket" id="codTicket"/>
               <div class="form-group row">
                                    <label class="col-sm-2 col-form-label" for="titulo">Titulo</label>
                                    <div class="col-sm-5"> 
                                        <input style="width: 250px;" id="titulo" required="required" type="text" value="${ticket.titulo}" name="titulo" id="titulo" />
                                    </div> 
                                     <div class="form-group row">
                                     <label class="col-sm-2 col-form-label" for="descricao">Descrição</label>
                                    <div class="col-sm-10">
                                    <textarea required="required" style="width: 900px;" id="descricao" style="width: 50%;"  name="descricao">${ticket.descricao}</textarea>
                                    </div>
                                     <label class="col-sm-2 col-form-label" for="status">Status</label>
                                    <div>
                                        <input style="width: 250px;" id="status" required="required" type="text" value="${ticket.status}" name="status" id="status" />
                                    </div>
                                    <label class="col-sm-2 col-form-label" for="dataAlteracao">Data de Alteracao</label>
                                    <div>
                                        <input style="width: 250px;" id="status" required="required" type="dataAlteracao" value="${ticket.dataAlteracao}" name="dataAlteracao" id="dataAlteracao" />
                                    </div>
                                    <label class="col-sm-2 col-form-label" for="analista">Analista</label>
                                    <div>
                                        <input style="width: 250px;" id="status" required="required" type="analista" value="${ticket.analista}" name="analista" id="analista" />
                                    </div>
                                    <label class="col-sm-2 col-form-label" for="usuario">Usuario</label>
                                    <div>
                                        <input style="width: 250px;" id="status" required="required" type="usuario" value="${ticket.analista}" name="usuario" id="usuario" />
                                    </div>
                                </div>        
                            </div>
                                     <button type="submit" onClick="confirmationUpdate()">Salvar</button>
                                     <button type="reset">Limpar</button>
                                     <button type="button" onclick="window.location.href = 'menu.jsp';">Voltar</button>
        </form>
    </body>
</html>
