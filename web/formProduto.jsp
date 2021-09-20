
<%@page import="java.util.List"%>
<%@page import="br.com.lojao.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>
            <div id="quadro">
                <h1>Cadastro de Produto</h1>
                <%
                    Produto p = new Produto();
                    if (request.getAttribute("resultado") != null) {
                        List<Produto> produtos = (List<Produto>)request.getAttribute("resultado");
                        p = produtos.get(0);
                    }
                %>
                <form action="<%= (p.getId() > -1 ? "AtualizarProduto":"InserirProduto")%>" method="post" onsubmit="return validar()" >
                    <input type="hidden" name="id" value="<%= p.getId()%>">

                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" id="nome" value="<%= p.getNome()%>" size="30"><br>

                    <label for="descricao">Descrição:</label>
                    <textarea name="descricao" id="descricao" rows="4" cols="50"><%= p.getDescricao()%></textarea><br>
                    
                    <label for="unidade">Unidade:</label>
                    <select name="unidade" id="unidade">
                        <option value="">--Selecione uma Unidade--</option>
                        <option value="KG" <%= p.getUnidade().equals("KG") ? "selected":""%>>Kilograma</option>
                        <option value="LT" <%= p.getUnidade().equals("LT") ? "selected":""%>>Litros</option>
                        <option value="UNI" <%= p.getUnidade().equals("UNI") ? "selected":""%>>Unidade</option>
                    </select><br>

                    <label for="preco">Preço:</label>
                    <input type="number" name="preco" id="preco" size="10" step=0.01 value="<%= p.getPreco()%>"><br>

                    <input type="submit" value="Enviar" >
                    <input type="reset" value="Limpar">
                </form>
            </div>
<%@include file="rodape.jsp" %>