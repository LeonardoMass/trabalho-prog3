
<%@page import="br.com.lojao.modelo.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>
            <div id="quadro">
                <h1>Lista de Produtos</h1>
                
                <a href="formProduto.jsp">Adicionar Produto</a><br>
                <table border="1">
                    <tr>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Unidade </th>
                        <th>Preço</th>
                        <th colspan="2">Ação</th>
                    </tr>
                    <%
                        List<Produto> produtos = (List<Produto>)request.getAttribute("resultado");
                        for (int i=0; i<produtos.size(); i++) {
                            Produto p = produtos.get(i);
                    %>
                            <tr>
                                <td><%= p.getNome()%></td>
                                <td><%= p.getDescricao()%></td>
                                <td><%= p.getUnidade()%></td>
                                <td><%= p.getPreco()%></td>
                                <td><a href="ConsultaProduto?acao=PORID&id=<%= p.getId()%>">Atualizar</a></td>
                                <td><a href="ExcluirProduto?id=<%= p.getId()%>">Excluir</a></td>
                            </tr>
                    <%
                        }
                    %>
                </table><br>
            </div>
<%@include file="rodape.jsp" %>
