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
import model.bean.Cliente;
import model.bean.Faturamento;


/**
 *
 * @author gilberto
 */
public class FaturamentoDAO {
    //=========================================== METAL - FLEX =========================================================================
    public void create(Faturamento f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO faturamento (vale,nfe,situacao,cliente,peso,valor,firma)VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1,f.getVale());
            stmt.setString(2, f.getNfe());
            stmt.setString(3, f.getSituacao());
            stmt.setInt(4, f.getCliente().getID_CLIENTE());
            stmt.setDouble(5, f.getPeso());
            stmt.setDouble(6, f.getValor());
            stmt.setString(7,"MF");
            
            
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    
    
    
    public List<Faturamento> readPorData(String d1,String d2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Faturamento> faturamento = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT f.ID_faturamento,f.vale,f.nfe,f.situacao,c.nome,f.peso,f.valor,c.ID_cliente FROM faturamento f,cliente c "
                    + "WHERE c.ID_cliente = f.cliente AND f.data >= ? AND f.data <= ? + interval 1 DAY AND f.firma like 'MF'");
            stmt.setString(1,d1);
            stmt.setString(2,d2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Faturamento f = new Faturamento();
                
                f.setID_faturamento(rs.getInt("ID_faturamento"));
                f.setVale(rs.getString("vale"));
                f.setNfe(rs.getString("nfe"));
                f.setSituacao(rs.getString("situacao"));
                Cliente c = new Cliente();
                c.setNOME(rs.getString("nome"));
                f.setPeso(rs.getDouble("peso"));
                f.setValor(rs.getDouble("valor"));
                c.setID_CLIENTE(rs.getInt("ID_cliente"));
                f.setCliente(c);
               
                faturamento.add(f);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return faturamento;
    }
    
    public Double readValor(String d1,String d2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        Double valorTotal=0.0;
        
        try {
            stmt = con.prepareStatement("SELECT sum(valor) as valor_total FROM faturamento f WHERE f.data >= ? AND f.data <= ? + INTERVAL 1 day AND situacao like 'pago' AND f.firma like 'MF'");
            stmt.setString(1,d1);
            stmt.setString(2,d2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Faturamento f = new Faturamento();
                Cliente c = new Cliente();
                
                
                f.setValor_total(rs.getDouble("valor_total"));
                valorTotal = f.getValor_total();
                
                
               
                
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return valorTotal;
    }
    
    public Double readValorTotal(String d1,String d2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        Double valorTotal=0.0;
        
        try {
            stmt = con.prepareStatement("SELECT sum(valor) as valor_total FROM faturamento f WHERE f.data >= ? AND f.data <= ? + INTERVAL 1 day AND f.firma like 'MF'");
            stmt.setString(1,d1);
            stmt.setString(2,d2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Faturamento f = new Faturamento();
                Cliente c = new Cliente();
                
                
                f.setValor_total(rs.getDouble("valor_total"));
                valorTotal = f.getValor_total();
                
                
               
                
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return valorTotal;
    }
    
    public Double readValorAberto(String d1,String d2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        Double valorAberto=0.0;
        
        try {
            stmt = con.prepareStatement("SELECT sum(valor) as valor_aberto FROM faturamento f WHERE f.data >= ? AND f.data <= ? + INTERVAL 1 day AND situacao like 'aberto' AND f.firma like 'MF'");
            stmt.setString(1,d1);
            stmt.setString(2,d2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Faturamento f = new Faturamento();
                Cliente c = new Cliente();
                
                
                f.setValor_aberto(rs.getDouble("valor_aberto"));
                valorAberto = f.getValor_aberto();
                
                
               
                
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return valorAberto;
    }
    
    public Double readPeso(String d1,String d2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        Double pesoTotal=0.0;
        
        try {
            stmt = con.prepareStatement("SELECT sum(peso) as peso FROM faturamento f WHERE f.data >= ? AND f.data <= ? + INTERVAL 1 day AND f.firma like 'MF'");
            stmt.setString(1,d1);
            stmt.setString(2,d2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Faturamento f = new Faturamento();
                Cliente c = new Cliente();
                
                
                f.setPeso_total(rs.getDouble("peso"));
                pesoTotal = f.getPeso_total();
                
                
               
                
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pesoTotal;
    }
    
    public void update(Integer ID,String vale,String nfe,String situacao,Cliente cliente,Double peso,Double valor){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE faturamento SET vale=?,nfe=?,situacao=?,cliente=?,peso=?,valor=? WHERE ID_faturamento=? AND firma like 'MF'");
            stmt.setString(1,vale);
            stmt.setString(2,nfe);
            stmt.setString(3,situacao);
            stmt.setInt(4, cliente.getID_CLIENTE());
            stmt.setDouble(5, peso);
            stmt.setDouble(6, valor);
            stmt.setInt(7, ID);
            
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    public void delete(Integer ID){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM faturamento WHERE ID_faturamento=?");
            
            stmt.setInt(1,ID);
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Excluir! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
     //======================== FLEX - MOL =========================================
    public void createFM(Faturamento f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO faturamento (vale,nfe,situacao,cliente,peso,valor,firma)VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1,f.getVale());
            stmt.setString(2, f.getNfe());
            stmt.setString(3, f.getSituacao());
            stmt.setInt(4, f.getCliente().getID_CLIENTE());
            stmt.setDouble(5, f.getPeso());
            stmt.setDouble(6, f.getValor());
            stmt.setString(7, "FM");
            
            
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    
    
    
    public List<Faturamento> readPorDataFM(String d1,String d2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Faturamento> faturamento = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT f.ID_faturamento,f.vale,f.nfe,f.situacao,c.nome,f.peso,f.valor,c.ID_cliente FROM faturamento f,cliente c "
                    + "WHERE c.ID_cliente = f.cliente AND f.data >= ? AND f.data <= ? + interval 1 DAY AND f.firma like 'FM'");
            stmt.setString(1,d1);
            stmt.setString(2,d2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Faturamento f = new Faturamento();
                
                
                f.setID_faturamento(rs.getInt("ID_faturamento"));
                f.setVale(rs.getString("vale"));
                f.setNfe(rs.getString("nfe"));
                f.setSituacao(rs.getString("situacao"));
                Cliente c = new Cliente();
                c.setNOME(rs.getString("nome"));
                f.setPeso(rs.getDouble("peso"));
                f.setValor(rs.getDouble("valor"));
                c.setID_CLIENTE(rs.getInt("ID_cliente"));
                
                f.setCliente(c);
                faturamento.add(f);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return faturamento;
    }
    
    public Double readValorFM(String d1,String d2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        Double valorTotal=0.0;
        
        try {
            stmt = con.prepareStatement("SELECT sum(valor) as valor_total FROM faturamento f WHERE f.data >= ? AND f.data <= ? + INTERVAL 1 day AND situacao like 'pago' AND f.firma like 'FM'");
            stmt.setString(1,d1);
            stmt.setString(2,d2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Faturamento f = new Faturamento();
                Cliente c = new Cliente();
                
                
                f.setValor_total(rs.getDouble("valor_total"));
                valorTotal = f.getValor_total();
                
                
               
                
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return valorTotal;
    }
    
    public Double readValorAbertoFM(String d1,String d2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        Double valorAberto=0.0;
        
        try {
            stmt = con.prepareStatement("SELECT sum(valor) as valor_aberto FROM faturamento f WHERE f.data >= ? AND f.data <= ? + INTERVAL 1 day AND situacao like 'aberto' AND f.firma like 'FM'");
            stmt.setString(1,d1);
            stmt.setString(2,d2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Faturamento f = new Faturamento();
                Cliente c = new Cliente();
                
                
                f.setValor_aberto(rs.getDouble("valor_aberto"));
                valorAberto = f.getValor_aberto();
                
                
               
                
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return valorAberto;
    }
    
    public Double readPesoFM(String d1,String d2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        Double pesoTotal=0.0;
        
        try {
            stmt = con.prepareStatement("SELECT sum(peso) as peso FROM faturamento f WHERE f.data >= ? AND f.data <= ? + INTERVAL 1 day AND f.firma like 'FM'");
            stmt.setString(1,d1);
            stmt.setString(2,d2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Faturamento f = new Faturamento();
                Cliente c = new Cliente();
                
                
                f.setPeso_total(rs.getDouble("peso"));
                pesoTotal = f.getPeso_total();
                
                
               
                
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pesoTotal;
    }
    
    public void updateFM(Integer ID,String vale,String nfe,String situacao,Cliente cliente,Double peso,Double valor){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE faturamento SET vale=?,nfe=?,situacao=?,cliente=?,peso=?,valor=? WHERE ID_faturamento=? AND firma like 'FM'");
            stmt.setString(1,vale);
            stmt.setString(2,nfe);
            stmt.setString(3,situacao);
            stmt.setInt(4, cliente.getID_CLIENTE());
            stmt.setDouble(5, peso);
            stmt.setDouble(6, valor);
            stmt.setInt(7, ID);
            
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    public void deleteFM(Integer ID){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM faturamento WHERE ID_faturamento=?");
            
            stmt.setInt(1,ID);
           
            
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
