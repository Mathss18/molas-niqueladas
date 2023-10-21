/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;

/**
 *
 * @author gilberto
 */
public class ClienteDAO {
    
    public void create(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nome,cpf_cnpj,email,telefone,telefone2,inscricao_estadual,logradouro,numero,cidade,uf,bairro,contato,cep)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,c.getNOME());
            stmt.setString(2,c.getCPF_CNPJ());
            stmt.setString(3,c.getEMAIL());
            stmt.setString(4,c.getTELEFONE());
            stmt.setString(5,c.getTELEFONE2());
            stmt.setString(6,c.getINSCRICAO_ESTADUAL());
            stmt.setString(7,c.getLOGRADOURO());
            stmt.setString(8,c.getNUMERO());
            stmt.setString(9,c.getCIDADE());
            stmt.setString(10,c.getUF());
            stmt.setString(11,c.getBAIRRO());
            stmt.setString(12,c.getCONTATO());
            stmt.setString(13,c.getCEP());
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha ao Cadastrar Cliente " + ex,"ERRO",JOptionPane.ERROR_MESSAGE); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    
    public List<Cliente> find(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<Cliente>();
            
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente ORDER BY nome ASC");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                
                c.setID_CLIENTE(rs.getInt("ID_cliente"));
                c.setNOME(rs.getString("nome"));
                c.setCPF_CNPJ(rs.getString("cpf_cnpj"));
                c.setEMAIL(rs.getString("email"));
                c.setTELEFONE(rs.getString("telefone"));
                c.setTELEFONE2(rs.getString("telefone2"));
                c.setINSCRICAO_ESTADUAL(rs.getString("inscricao_estadual"));
                c.setLOGRADOURO(rs.getString("logradouro"));
                c.setNUMERO(rs.getString("numero"));
                c.setCIDADE(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));
                c.setBAIRRO(rs.getString("bairro"));
                c.setCONTATO(rs.getString("contato"));
                c.setCEP(rs.getString("cep"));
                clientes.add(c);
                
            }
                    
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Falha Do Tipo:" + ex,"ERRO",JOptionPane.ERROR_MESSAGE); 
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
    }
    
   
    
    
     public void update(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome=?,cpf_cnpj=?,email=?,telefone=?,telefone2=?,inscricao_estadual=?,logradouro=?,numero=?,cidade=?,uf=? WHERE ID_cliente=?");
            stmt.setString(1,c.getNOME());
            stmt.setString(2,c.getCPF_CNPJ());
            stmt.setString(3,c.getEMAIL());
            stmt.setString(4,c.getTELEFONE());
            stmt.setString(5,c.getTELEFONE2());
            stmt.setString(6,c.getINSCRICAO_ESTADUAL());
            stmt.setString(7,c.getLOGRADOURO());
            stmt.setString(8,c.getNUMERO());
            stmt.setString(9,c.getCIDADE());
            stmt.setString(10,c.getUF());
            stmt.setInt(11, c.getID_CLIENTE());
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha Do Tipo:" + ex,"ERRO AO ATUALIZAR",JOptionPane.ERROR_MESSAGE); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
     
     public void delete(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE ID_cliente=?");
            
            stmt.setInt(1, c.getID_CLIENTE());
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha Do Tipo:" + ex,"ERRO AO EXCLUIR",JOptionPane.ERROR_MESSAGE);  
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    
}
