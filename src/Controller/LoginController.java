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
import javax.swing.JOptionPane;
import model.Usuario;
import view.LoginView;
import view.MenuView;

/**
 *
 * @author Amanda
 */
public class LoginController {
    //chamando a view a ser administrada
    private LoginView view;
    //construtor
    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        //Buscando usuário da view
        String usuario = view.getjTextUsuario().getText();
        String senha = view.getjPasswordSenha().getText();
        Usuario usuarioAutenticar = new Usuario(usuario, senha);
        //Verificando se existe usuário no banco de dados
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
       boolean existe = usuarioDao.existeNoBancoPorUsuarioESenha(usuarioAutenticar);
        //Se existe direciona para o menu
        if(existe){
            //Chamando a tela de menu ao clicar no botão entrar
            MenuView telaDeMenu = new MenuView();
            telaDeMenu.setVisible(true);
        }else{
               JOptionPane.showMessageDialog(view, "Usuário ou senha inválidos");
        }
    
    }

    }


