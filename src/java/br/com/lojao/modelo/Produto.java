/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojao.modelo;

import br.com.lojao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leona
 */
public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private String unidade;
    private float preco;
    
    public Produto() {
        this.id = -1;
        this.nome = "";
        this.descricao = "";
        this.unidade = "";
        this.preco = (float)0.0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) throws Exception {
        if (nome == null || nome.equals("")){
            throw new Exception ("O nome deve ser obrigatório.");
        }
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) throws Exception{
        if (unidade == null || unidade.equals("")){
            throw new Exception ("A unidade é obrigatória.");
        }
        this.unidade = unidade;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) throws Exception {
        if (preco > 0){
            this.preco = preco;
        }else{
             throw new Exception ("O preço é obrigatório.");
        }
        
        
    }
    
    public List<Produto> pesquisar() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Produto> lista = new ArrayList();
        
        try {
            con = Conexao.pegarConexao();

            if (this.id == -1) {
                pstmt = con.prepareStatement("select * from produtos");
            } else {
                pstmt = con.prepareStatement("select * from produtos where id = ?");
                pstmt.setInt(1, this.id);
            }
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Produto p = new Produto();
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setUnidade(rs.getString("unidade"));
                p.setPreco(rs.getFloat("preco"));
                p.setId(rs.getInt("id"));       
                lista.add(p);
            }
        } catch (Exception e) {
            throw new Exception("Falha ao pesquisar produtos no banco de dados!!! <!-- "+e.getMessage()+"-->");
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        
        return lista;
    }
    
    public void adicionar() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = Conexao.pegarConexao();

            pstmt = con.prepareStatement("insert into produtos (nome, descricao, unidade, preco) values (?, ? , ? ,?)");
            pstmt.setString(1, this.nome);
            pstmt.setString(2, this.descricao);
            pstmt.setString(3, this.unidade);
            pstmt.setFloat(4, this.preco);
            
            pstmt.execute();
            
        }catch (Exception e){
            throw new Exception("Falha ao inserir um produto no banco de dados!!! <!-- "+e.getMessage()+"-->");
        }finally{
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        
    }
    
    public void atualizar() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = Conexao.pegarConexao();

            pstmt = con.prepareStatement("update produtos set nome = ?, descricao = ?, unidade = ?, preco = ? where id = ?");
            pstmt.setString(1, this.nome);
            pstmt.setString(2, this.descricao);
            pstmt.setString(3, this.unidade);
            pstmt.setFloat(4, this.preco);
            pstmt.setInt(5, this.id);
            
            pstmt.execute();
        } catch (Exception e) {
            throw new Exception("Falha ao atualizar um produto no banco de dados!!! <!-- "+e.getMessage()+"-->");
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
    
    public void excluir() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = Conexao.pegarConexao();

            pstmt = con.prepareStatement("delete from produtos where id = ?");
            pstmt.setInt(1, this.id);
            
            pstmt.execute();
        } catch (Exception e) {
            throw new Exception("Falha ao excluir um produto no banco de dados!!! <!-- "+e.getMessage()+"-->");
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
}
