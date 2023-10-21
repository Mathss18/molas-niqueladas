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
import model.bean.Relogio;

/**
 *
 * @author gilberto
 */
public class RelogioDAO {
    public void create(Relogio r){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO relogio (inicio,fim,status)VALUES(?,?,?)");
            stmt.setInt(1,r.getInicio());
            stmt.setInt(2,r.getFim());
            stmt.setString(3,r.getStatus());
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    
    
    public List<Relogio> read1(String data1,String data2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Relogio> relogio = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT ID_relogio,inicio,fim,data FROM relogio WHERE status like 'r1' AND data >=? AND data <=? + INTERVAL 1 DAY");
            stmt.setString(1,data1);
            stmt.setString(2,data2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Relogio r = new Relogio();
                
                r.setID_relogio(rs.getInt("ID_relogio"));
                r.setInicio(rs.getInt("inicio"));
                r.setFim(rs.getInt("fim"));
                r.setData(rs.getDate("data"));
               
                relogio.add(r);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return relogio;
    }
    
    public List<Relogio> read2(String data1,String data2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Relogio> relogio = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT ID_relogio,inicio,fim,data FROM relogio WHERE status like 'r2' AND data >=? AND data <=? + INTERVAL 1 DAY");
            stmt.setString(1,data1);
            stmt.setString(2,data2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Relogio r = new Relogio();
                
                r.setID_relogio(rs.getInt("ID_relogio"));
                r.setInicio(rs.getInt("inicio"));
                r.setFim(rs.getInt("fim"));
                r.setData(rs.getDate("data"));
               
                relogio.add(r);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return relogio;
    }
    
    public void update1(Integer ID,Integer inicio,Integer fim){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE relogio SET inicio=?,fim=? WHERE ID_relogio=? AND status like 'r1'");
            stmt.setInt(1,inicio);
            stmt.setInt(2,fim);
            stmt.setInt(3,ID);
            
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    
    public void update2(Integer ID,Integer inicio,Integer fim){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE relogio SET inicio=?,fim=? WHERE ID_relogio=? AND status like 'r2'");
            stmt.setInt(1,inicio);
            stmt.setInt(2,fim);
            stmt.setInt(3,ID);
            
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    public void delete(Integer ID_relogio){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM relogio WHERE ID_relogio=?");
            
            stmt.setInt(1,ID_relogio);
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Excluir! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
}
