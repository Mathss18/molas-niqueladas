/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;
import model.bean.Usuario;
import view.telaPrincipalMDI;

/**
 *
 * @author gilberto
 */
public class UsuarioDAO {

    public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login LIKE ? AND senha LIKE ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()) {

                //SETAR NIVEIS DE USUARIO
                String perfil = rs.getString(4);
                if (perfil.equals("gerente")) {
                    telaPrincipalMDI inicio = new telaPrincipalMDI();
                    inicio.setVisible(true);
                    telaPrincipalMDI.Menu_User.setEnabled(true);
                    telaPrincipalMDI.Menu_Cliente.setEnabled(true);
                    telaPrincipalMDI.Menu_Pedidos.setEnabled(true);
                    telaPrincipalMDI.Menu_Estoque.setEnabled(true);
                    telaPrincipalMDI.Menu_Semae.setEnabled(true);
                    telaPrincipalMDI.Menu_Faturamento.setEnabled(true);
                    telaPrincipalMDI.Menu_Equalizador.setEnabled(true);
                    telaPrincipalMDI.Menu_Qualidade.setEnabled(true);

                } else if (perfil.equals("secretaria")) {
                    telaPrincipalMDI inicio = new telaPrincipalMDI();
                    inicio.setVisible(true);
                    //telaPrincipalMDI.Menu_User.setEnabled(true);
                    telaPrincipalMDI.Menu_Cliente.setEnabled(true);
                    telaPrincipalMDI.Menu_Pedidos.setEnabled(true);
                    //telaPrincipalMDI.Menu_Estoque.setEnabled(true);
                    //telaPrincipalMDI.Menu_Semae.setEnabled(true);
                    telaPrincipalMDI.Menu_Faturamento.setEnabled(true);
                    //telaPrincipalMDI.Menu_Equalizador.setEnabled(true);
                    //telaPrincipalMDI.Menu_Qualidade.setEnabled(true);

                } else if (perfil.equals("almoxarifado")) {
                    telaPrincipalMDI inicio = new telaPrincipalMDI();
                    inicio.setVisible(true);
                    // telaPrincipalMDI.Menu_User.setEnabled(true);
                    //telaPrincipalMDI.Menu_Cliente.setEnabled(true);
                    telaPrincipalMDI.Menu_Pedidos.setEnabled(true);
                    telaPrincipalMDI.Menu_Estoque.setEnabled(true);
                    telaPrincipalMDI.Menu_Semae.setEnabled(true);
                    //telaPrincipalMDI.Menu_Faturamento.setEnabled(true);
                    telaPrincipalMDI.Menu_Equalizador.setEnabled(true);
                    //telaPrincipalMDI.Menu_Qualidade.setEnabled(true);
                    telaPrincipalMDI.jMenuItem11.doClick();
                }else if (perfil.equals("compras")) {
                    telaPrincipalMDI inicio = new telaPrincipalMDI();
                    inicio.setVisible(true);
                    // telaPrincipalMDI.Menu_User.setEnabled(true);
                    //telaPrincipalMDI.Menu_Cliente.setEnabled(true);
                    // telaPrincipalMDI.Menu_Pedidos.setEnabled(true);
                    telaPrincipalMDI.jMenuItem10.doClick();
                    telaPrincipalMDI.Menu_Estoque.setEnabled(true);
                    //telaPrincipalMDI.Menu_Semae.setEnabled(true);
                    //telaPrincipalMDI.Menu_Faturamento.setEnabled(true);
                    //telaPrincipalMDI.Menu_Equalizador.setEnabled(true);
                    //telaPrincipalMDI.Menu_Qualidade.setEnabled(true);
                }
                else if (perfil.equals("qualidade")) {
                    telaPrincipalMDI inicio = new telaPrincipalMDI();
                    inicio.setVisible(true);
                    // telaPrincipalMDI.Menu_User.setEnabled(true);
                    //telaPrincipalMDI.Menu_Cliente.setEnabled(true);
                    // telaPrincipalMDI.Menu_Pedidos.setEnabled(true);
                    //telaPrincipalMDI.Menu_Estoque.setEnabled(true);
                    //telaPrincipalMDI.Menu_Semae.setEnabled(true);
                    //telaPrincipalMDI.Menu_Faturamento.setEnabled(true);
                    //telaPrincipalMDI.Menu_Equalizador.setEnabled(true);
                    telaPrincipalMDI.Menu_Qualidade.setEnabled(true);
                }
                check = true;

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro! " + ex);
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public void create(Usuario u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario (login,senha,perfil)VALUES(?,?,?)");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            stmt.setString(3, u.getPerfil());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo Com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Usuario> find() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario ORDER BY login ASC");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();

                u.setId_usuario(rs.getInt("id_usuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setPerfil(rs.getString("perfil"));

                usuarios.add(u);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro! " + ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }

    public void update(Usuario u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE usuario SET login=?,senha=?,perfil=? WHERE id_usuario=?");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            stmt.setString(3, u.getPerfil());
            stmt.setInt(4, u.getId_usuario());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Usuario u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE id_usuario=?");

            stmt.setInt(1, u.getId_usuario());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido Com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Excluir! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
