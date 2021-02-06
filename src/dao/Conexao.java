/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Amanda
 */
public class Conexao {
    //Classe responsável por ir ao banco de dados e fazer a conexão
    
    public Connection getConnection() throws SQLException{
    //Quem chama essa conexão recebe a conexão com o banco de dados  
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cursojava", "postgres", "postgres");
        return conexao;
        
    }
}
