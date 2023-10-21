/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Entrada_Produto;
import model.bean.Produto;

/**
 *
 * @author gilberto
 */
public class Entrada_ProdutoDAO {
    public void create(Entrada_Produto e){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO entrada_produto (ID_produto,qtde,valor_unitario)VALUES(?,?,?)");
            stmt.setInt(1,e.getID_produto().getID_produto());
            stmt.setDouble(2,e.getQtde());
            stmt.setDouble(3,e.getValor_unitario());
            
            
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Criado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    
    }
}
