/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Cliente;
import model.bean.Pedido;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gilberto
 */
public class PedidoDAOTest {
    
    public PedidoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class PedidoDAO.
     */
    @Test
    public void inserir() {
        
        Pedido p1 = new Pedido();
        Cliente c1 = new Cliente();
        c1.setID_CLIENTE(2);
        p1.setOF("123");
        p1.setCodigo("123-12");
        p1.setData_pedido("01/01/2000");
        p1.setData_entrega("02/01/2000");
        p1.setQuantidade(100);
        p1.setTipo("ponteiras");
        p1.setCliente(c1);
        
        PedidoDAO pdao = new PedidoDAO();
        
        pdao.create(p1);
           
    }
    
}
