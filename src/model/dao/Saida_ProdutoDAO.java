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
import model.bean.Estoque;
import model.bean.Produto;
import model.bean.Saida_Produto;

/**
 *
 * @author gilberto
 */
public class Saida_ProdutoDAO {
    public void create(Saida_Produto s){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO saida_produto (ID_produto,qtde,banho,valor_unitario)VALUES(?,?,?,?)");
            stmt.setInt(1,s.getID_produto().getID_produto());
            stmt.setDouble(2,s.getQtde());
            stmt.setString(3,s.getBanho());
            stmt.setDouble(4,s.getValor_unitario());
            
            
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Retirado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    
    }
    
}
