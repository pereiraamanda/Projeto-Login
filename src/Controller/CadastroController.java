/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.CadastroView;

/**
 *
 * @author Amanda
 */
public class CadastroController {
    //chamando a view a ser administrada 
    private CadastroView view;
    //construtor
    public CadastroController(CadastroView view) {
        this.view = view;
    }
    
    public void salvaUsuario(){
         //salvando e inserindo usuário no banco de dados
        String usuario = view.getjTextUsuario().getText();
        String senha = view.getjPasswordSenha().getText();
        Usuario novoUsuario = new Usuario(usuario, senha);
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(novoUsuario);
            
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CadastroView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
