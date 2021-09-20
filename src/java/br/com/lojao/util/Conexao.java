/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojao.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author leona
 */
public class Conexao {
    public static Connection pegarConexao() throws Exception {
        /* Abrir uma conexão com o banco de dados */
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_virtual?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "Macaco123");
    }
}
