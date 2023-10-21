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
import model.bean.Entrada_Produto;
import model.bean.Estoque;
import model.bean.Produto;

/**
 *
 * @author gilberto
 */
public class EstoqueDAO {
    public void Get_Preco(Produto p){
        
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("SELECT e.valor_unitario FROM estoque e WHERE e.ID_produto = ?");
            stmt.setInt(1,p.getID_produto());

            stmt.executeQuery();

                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + ex); 
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    public List<Estoque> find(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Estoque> estoques = new ArrayList<Estoque>();
            
        
        try {
            stmt = con.prepareStatement("SELECT p.nome,e.qtde,p.utilizacao,e.valor_unitario FROM produto p, estoque e WHERE p.ID_produto = e.ID_produto ORDER BY p.nome ASC");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque e = new Estoque();
                e.setNome(rs.getString("nome"));
                e.setQtde(rs.getDouble("qtde"));
                e.setUtilizacao(rs.getString("utilizacao"));
                e.setValor_unitario(rs.getDouble("valor_unitario"));
                
                estoques.add(e);
                
            }
                    
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro! "+ ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return estoques;
    }
    
    public List<Estoque> findProdutoEmFalta(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Estoque> estoques = new ArrayList<Estoque>();
            
        
        try {
            stmt = con.prepareStatement("SELECT p.nome,p.utilizacao,p.estoque_minimo,e.qtde FROM produto p,estoque e WHERE p.ID_produto = e.ID_produto AND e.qtde <= p.estoque_minimo ORDER BY p.nome ASC");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque e = new Estoque();
                e.setNome(rs.getString("nome"));
                e.setUtilizacao(rs.getString("utilizacao"));
                e.setEstoque_minimo(rs.getDouble("estoque_minimo"));
                e.setQtde(rs.getDouble("qtde"));
                
                estoques.add(e);
                
            }
                    
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro! "+ ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return estoques;
    }
    
    public List<Estoque> findRelatorioSaida(String banho,String dataInicio,String dataFim){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Estoque> estoques = new ArrayList<Estoque>();
            
        
        try {
            stmt = con.prepareStatement("SELECT p.nome,sum(s.qtde) as quantidade_gasta,a.valor_unitario,s.data_saida "
                    + "FROM saida_produto s,produto p,estoque a where data_saida >= ? AND data_saida <= ? + INTERVAL 1 DAY AND banho like ? "
                    + "AND p.ID_produto = s.ID_produto AND a.ID_produto = p.ID_produto GROUP BY s.data_saida ORDER BY p.nome ASC");
            stmt.setString(1, dataInicio);
            stmt.setString(2, dataFim);
            stmt.setString(3, banho);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque e = new Estoque();
                e.setNome(rs.getString("nome"));
                e.setQtde(rs.getDouble("quantidade_gasta"));
                e.setValor_unitario(rs.getDouble("valor_unitario"));
                e.setData(rs.getDate("data_saida"));
                
                estoques.add(e);
                
            }
                    
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro! "+ ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return estoques;
    }
    
    public List<Estoque> findRelatorioEntrada(String dataInicio,String dataFim){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Estoque> estoques = new ArrayList<Estoque>();
            
        
        try {
            stmt = con.prepareStatement("select p.nome,sum(e.qtde) as quantidade_adiquirida,a.valor_unitario,e.data_entrada from entrada_produto e,produto p,estoque a "
                    + "WHERE data_entrada >= ? AND data_entrada <= ? + INTERVAL 1 DAY AND p.ID_produto = e.ID_produto AND a.ID_produto = p.ID_produto GROUP BY e.data_entrada ORDER BY p.nome ASC");
            stmt.setString(1, dataInicio);
            stmt.setString(2, dataFim);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque e = new Estoque();
                e.setNome(rs.getString("nome"));
                e.setQtde(rs.getDouble("quantidade_adiquirida"));
                e.setValor_unitario(rs.getDouble("valor_unitario"));
                e.setData(rs.getDate("data_entrada"));
                
                estoques.add(e);
                
            }
                    
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro! "+ ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return estoques;
    }
    
     public List<Estoque> findPreco(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Estoque> estoques = new ArrayList<Estoque>();
            
        
        try {
            stmt = con.prepareStatement("SELECT e.valor_unitario FROM estoque e WHERE e.ID_produto = ?  ");
            stmt.setInt(1,p.getID_produto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque e = new Estoque();
                e.setValor_unitario(rs.getDouble("valor_unitario"));
                estoques.add(e);
                
            }
                    
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro! "+ ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return estoques;
    }
     public Double findQtde(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Double qtdEstoque=0.0;
        
        
            
        
        try {
            stmt = con.prepareStatement("SELECT e.qtde FROM estoque e WHERE ID_produto = ?");
            stmt.setInt(1,p.getID_produto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque e = new Estoque();
                e.setQtde(rs.getDouble("qtde"));
                qtdEstoque = e.getQtde();
                
            }
                    
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro! "+ ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return qtdEstoque;
    }
     
     public List<Estoque> findRelatorioIdeal(String banho,String dataInicio,String dataFim){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Estoque> estoques = new ArrayList<>();
            
        
        try {
            stmt = con.prepareStatement("SELECT p.nome,sum(s.qtde) as quantidade_utilizada,p.ideal_dia "
                    + "FROM saida_produto s,produto p "
                    + "WHERE data_saida >= ? AND data_saida <= ? + INTERVAL 1 DAY AND banho like ? AND p.ID_produto = s.ID_produto GROUP BY p.nome ORDER BY p.nome ASC ");
            stmt.setString(1, dataInicio);
            stmt.setString(2, dataFim);
            stmt.setString(3, banho);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque e = new Estoque();
                e.setNome(rs.getString("nome"));
                e.setQuantidade_utilizada(rs.getFloat("quantidade_utilizada"));
                e.setIdeal_dia(rs.getFloat("ideal_dia"));
                
                
                estoques.add(e);
                
            }
                    
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro! "+ ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return estoques;
    }
     
     public int findDiasTrabalhadosPorProduto(String banho,String dataInicio,String dataFim,String produto_coringa){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int dias_trabalhados=0;
            
        
        try {
            stmt = con.prepareStatement("SELECT COUNT(*) as 'dias_trabalhados' FROM saida_produto s,produto p,estoque a "
                    + "WHERE p.nome like ? AND data_saida >= ? AND data_saida <= ? + INTERVAL 1 DAY AND banho like ? AND p.ID_produto = s.ID_produto AND a.ID_produto = p.ID_produto GROUP BY p.nome ORDER BY p.nome ASC");
            stmt.setString(1, produto_coringa);
            stmt.setString(2, dataInicio);
            stmt.setString(3, dataFim);
            stmt.setString(4, banho);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque e = new Estoque();
                e.setDias_trabalhados(rs.getInt("dias_trabalhados"));
                
                
                
                dias_trabalhados = e.getDias_trabalhados();
                
            }
                    
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro! "+ ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dias_trabalhados;
    }
    
    }

