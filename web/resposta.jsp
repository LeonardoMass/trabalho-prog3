
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>
            <div id="conteudo">
                <p><%= request.getAttribute("mensagem")%></p><br>
                <a href="index.jsp">Voltar</a>
            </div>
<%@include file="rodape.jsp" %>