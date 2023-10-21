/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Pedido;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author gilberto
 */
public class PedidoDAO {
    
    
    
    public void create(Pedido c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO pedido (OF,codigo,data_pedido,data_entrega,quantidade,tipo,status,ID_cliente,path_desenho)VALUES(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,c.getOF());
            stmt.setString(2,c.getCodigo());
            stmt.setString(3,c.getData_pedido());
            stmt.setString(4,c.getData_entrega());
            stmt.setInt(5, c.getQuantidade());
            stmt.setString(6, c.getTipo());
            stmt.setString(7,c.getStatus());
            stmt.setInt(8, c.getCliente().getID_CLIENTE());
            stmt.setString(9, c.getPath_desenho());
            
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Criado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    
    }
    
    public List<Pedido> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Pedido> pedido = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT ID_pedido,OF,codigo,data_pedido,data_entrega,quantidade,tipo FROM pedido");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido p = new Pedido();
                
                
                p.setID_pedido(rs.getInt("ID_pedido"));
                p.setOF(rs.getString("OF"));
                p.setCodigo(rs.getString("codigo"));
                p.setData_pedido(rs.getString("data_pedido"));
                p.setData_entrega(rs.getString("data_entrega"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setTipo(rs.getString("tipo"));
                
               
                
                pedido.add(p);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pedido;
    }
    
    
    
    public List<Pedido> readID(Integer ID){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Pedido> pedido = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT p.ID_pedido,p.OF,p.codigo,c.nome,p.data_pedido,p.data_entrega,p.quantidade,p.tipo,p.status,p.path_desenho FROM pedido p,cliente c WHERE p.ID_cliente = c.ID_cliente AND p.ID_cliente LIKE ? AND p.status LIKE \"Aberto\"");
            stmt.setInt(1, ID);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido p = new Pedido();
                
                
                
                p.setID_pedido(rs.getInt("ID_pedido"));
                p.setOF(rs.getString("OF"));
                p.setCodigo(rs.getString("codigo"));
                p.setNome_cliente(rs.getString("nome"));
                p.setData_pedido(rs.getString("data_pedido"));
                p.setData_entrega(rs.getString("data_entrega"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setTipo(rs.getString("tipo"));
                p.setStatus(rs.getString("status"));
                p.setPath_desenho(rs.getString("path_desenho"));
                
                
               
                
                pedido.add(p);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pedido;
    }
    
    public List<Pedido> readAll(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Pedido> pedido = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT p.ID_pedido,p.OF,p.codigo,c.nome,p.data_pedido,p.data_entrega,p.quantidade,p.tipo,p.status,p.path_desenho FROM pedido p,cliente c WHERE p.ID_cliente = c.ID_cliente AND p.status LIKE \"Aberto\"");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido p = new Pedido();
                
                
                
                p.setID_pedido(rs.getInt("ID_pedido"));
                p.setOF(rs.getString("OF"));
                p.setCodigo(rs.getString("codigo"));
                p.setNome_cliente(rs.getString("nome"));
                p.setData_pedido(rs.getString("data_pedido"));
                p.setData_entrega(rs.getString("data_entrega"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setTipo(rs.getString("tipo"));
                p.setStatus(rs.getString("status"));
                p.setPath_desenho(rs.getString("path_desenho"));
                
                
               
                
                pedido.add(p);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pedido;
    }
    
    public List<Pedido> readIDFechado(Integer ID){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Pedido> pedido = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM pedido p WHERE p.ID_cliente LIKE ? AND p.status LIKE \"Fechado\"");
            stmt.setInt(1, ID);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido p = new Pedido();
                
                
                
                p.setID_pedido(rs.getInt("ID_pedido"));
                p.setOF(rs.getString("OF"));
                p.setCodigo(rs.getString("codigo"));
                p.setData_pedido(rs.getString("data_pedido"));
                p.setData_entrega(rs.getString("data_entrega"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setTipo(rs.getString("tipo"));
                p.setStatus(rs.getString("status"));
                p.setPath_desenho(rs.getString("path_desenho"));
                
               
                
                pedido.add(p);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pedido;
    }
    
    
    
    public boolean update(Pedido c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE pedido SET OF=?,codigo=?,data_pedido=?,data_entrega=?,quantidade=?,tipo=?,status=?,path_desenho=? WHERE ID_pedido = ?");
            stmt.setString(1,c.getOF());
            stmt.setString(2,c.getCodigo());
            stmt.setString(3,c.getData_pedido());
            stmt.setString(4,c.getData_entrega());
            stmt.setInt(5, c.getQuantidade());
            stmt.setString(6, c.getTipo());
            stmt.setString(7, c.getStatus());
            stmt.setString(8, c.getPath_desenho());
            stmt.setInt(9, c.getID_pedido());
            
            
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        return true;
    
    }
    public boolean updateStatus(Pedido c){
        Date data_atual = null;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE pedido SET status=\"Fechado\",data_controle=? WHERE ID_pedido = ?");

            stmt.setDate(1,data_atual);
            stmt.setInt(2, c.getID_pedido());
            
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        return true;
    
    }
    
    public boolean delete(Pedido c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM pedido WHERE ID_pedido = ?");
           
            stmt.setInt(1, c.getID_pedido());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Deletar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        return true;
    
    }
    
    
    
    public List<Pedido> readPedidoAberto(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Pedido> pedido = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM pedido p WHERE p.status LIKE \"Aberto\"");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido p = new Pedido();
                
                
                p.setID_pedido(rs.getInt("ID_pedido"));
                p.setOF(rs.getString("OF"));
                p.setCodigo(rs.getString("codigo"));
                p.setData_pedido(rs.getString("data_pedido"));
                p.setData_entrega(rs.getString("data_entrega"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setTipo(rs.getString("tipo"));
                p.setStatus(rs.getString("status"));
                
               
                
                pedido.add(p);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pedido;
    }
    public List<Pedido> readPedidoFechado(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Pedido> pedido = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM pedido p WHERE p.status LIKE \"Fechado\"");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido p = new Pedido();
                
                
                p.setID_pedido(rs.getInt("ID_pedido"));
                p.setOF(rs.getString("OF"));
                p.setCodigo(rs.getString("codigo"));
                p.setData_pedido(rs.getString("data_pedido"));
                p.setData_entrega(rs.getString("data_entrega"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setTipo(rs.getString("tipo"));
                p.setStatus(rs.getString("status"));
                
               
                
                pedido.add(p);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pedido;
    }
    
    public List<Pedido> readMolasFechadas(String d1,String d2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Pedido> pedido = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT p.tipo,sum(p.quantidade)as quantidade FROM pedido p "
                    + "WHERE p.data_controle >= ? AND p.data_controle <= ? + INTERVAL 1 DAY AND p.status like 'Fechado' GROUP BY p.tipo");
            stmt.setString(1, d1);
            stmt.setString(2, d2);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido p = new Pedido();
                
                
                
                p.setTipo(rs.getString("tipo"));
                p.setQtde_itens_mes(rs.getString("quantidade"));
                
               
                
                pedido.add(p);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pedido;
    }
}


        
