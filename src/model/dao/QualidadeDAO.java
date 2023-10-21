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
import model.bean.Pedido;
import model.bean.Qualidade;

/**
 *
 * @author gilberto
 */
public class QualidadeDAO {
    
    public void create(Qualidade q,int ID_cliente){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO qualidade (of,codigo,cliente,abertura,arame,interno,externo,passo,lo_corpo,lo_total,espiras,qtde,sobra,acabamento,obs)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1,q.getOf());
            stmt.setString(2,q.getCodigo());
            stmt.setInt(3,ID_cliente);
            stmt.setString(4,q.getAbertura());
            stmt.setString(5,q.getArame());
            stmt.setString(6,q.getInterno());
            stmt.setString(7,q.getExterno());
            stmt.setString(8,q.getPasso());
            stmt.setString(9,q.getLo_corpo());
            stmt.setString(10,q.getLo_total());
            stmt.setString(11,q.getEspiras());
            stmt.setInt(12,q.getQtde());
            stmt.setInt(13,q.getSobra());
            stmt.setString(14,q.getAcabamento());
            stmt.setString(15,q.getObs());
            
            
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Criado Com Sucesso!"); 
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    
    }
    
    public List<Qualidade> readPorData(String d1,String d2){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Qualidade> qualidade = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT q.ID_qualidade,q.of,q.codigo,c.nome,q.qtde,q.sobra,q.abertura,q.arame,q.interno,q.externo,q.passo,q.lo_corpo,q.lo_total,q.espiras,q.acabamento,q.obs,q.data,c.ID_cliente FROM qualidade q, cliente c "
                    + "WHERE q.cliente = c.ID_cliente AND q.data >= ? AND q.data <= ? + INTERVAL 1 DAY ");
            stmt.setString(1,d1);
            stmt.setString(2,d2);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Qualidade q = new Qualidade();
                
                q.setID_qualidade(rs.getInt("ID_qualidade"));
                q.setOf(rs.getInt("of"));
                q.setCodigo(rs.getString("codigo"));
                Cliente c = new Cliente();
                c.setNOME(rs.getString("nome"));
                c.setID_CLIENTE(rs.getInt("ID_cliente"));
                q.setQtde(rs.getInt("qtde"));
                q.setSobra(rs.getInt("sobra"));
                q.setAbertura(rs.getString("abertura"));
                q.setArame(rs.getString("arame"));
                q.setInterno(rs.getString("interno"));
                q.setExterno(rs.getString("externo"));
                q.setPasso(rs.getString("passo"));
                q.setLo_corpo(rs.getString("lo_corpo"));
                q.setLo_total(rs.getString("lo_total"));
                q.setEspiras(rs.getString("espiras"));
                q.setAcabamento(rs.getString("acabamento"));
                q.setObs(rs.getString("obs"));
                q.setData(rs.getDate("data"));
                q.setCliente(c);
                
                
               
                qualidade.add(q);
            }
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return qualidade;
    }
    public boolean update(Qualidade q){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE qualidade SET of=?,codigo=?,cliente=?,qtde=?,sobra=?,abertura=?,arame=?,externo=?,interno=?,passo=?,lo_corpo=?,lo_total=?,espiras=?,obs=?,acabamento=? WHERE ID_qualidade = ?");
            stmt.setInt(1,q.getOf());
            stmt.setString(2,q.getCodigo());
            stmt.setInt(3,q.getID_cliente());
            stmt.setInt(4,q.getQtde());
            stmt.setInt(5,q.getSobra());
            stmt.setString(6,q.getAbertura());
            stmt.setString(7,q.getArame());
            stmt.setString(8,q.getExterno());
            stmt.setString(9,q.getInterno());
            stmt.setString(10,q.getPasso());
            stmt.setString(11,q.getLo_corpo());
            stmt.setString(12,q.getLo_total());
            stmt.setString(13,q.getEspiras());
            stmt.setString(14,q.getObs());
            stmt.setString(15,q.getAcabamento());
            stmt.setInt(16, q.getID_qualidade());
            
            
            
            
            
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
    
    public boolean delete(Qualidade q){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM qualidade WHERE ID_qualidade = ?");
           
            stmt.setInt(1, q.getID_qualidade());

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
    
}
