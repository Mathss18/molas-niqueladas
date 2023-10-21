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
import model.bean.Produto;

/**
 *
 * @author gilberto
 */
public class ProdutoDAO {
    
    
    
    public boolean create(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO produto (nome,utilizacao,estoque_minimo,ideal_dia)VALUES(?,?,?,?)");
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getUtilizacao());
            stmt.setString(3,p.getEstoque_minimo());
            stmt.setDouble(4,p.getIdeal_dia());
            
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Criado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        return true;
    
    }
    
    public List<Produto> find(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<Produto>();
            
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produto ORDER BY nome ASC");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                
                p.setID_produto(rs.getInt("ID_produto"));
                p.setNome(rs.getString("nome"));
                produtos.add(p);
                
            }
                    
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro! "+ ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
    
    public void updateIdealDia(Double ideal_dia,int ID){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE produto SET ideal_dia=? WHERE ID_produto = ?");
            stmt.setDouble(1,ideal_dia);
            stmt.setInt(2,ID);
            
            
            stmt.executeUpdate();
            
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar p.ideal_dia (TelaEqualizador)! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
}
