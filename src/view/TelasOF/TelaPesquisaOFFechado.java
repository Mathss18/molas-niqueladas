/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.TelasOF;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.bean.Pedido;
import model.dao.ClienteDAO;
import model.dao.PedidoDAO;

/**
 *
 * @author gilberto
 */
public class TelaPesquisaOFFechado extends javax.swing.JInternalFrame {
    private int ID_cliente = 0;
    String caminho="";
    Cliente c;

    /**
     * Creates new form TelaPesquisaClientes
     */
    public TelaPesquisaOFFechado() {
        initComponents();
        tbl_cliente.setVisible(false);
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));
        ClienteDAO cdao = new ClienteDAO();
        popularJtable();
        readForID(ID_cliente);
        //================  DEIXA LINHA SELECIONADA COM A COR AMARELA ================
        jTable1.setSelectionBackground(Color.yellow);
        jTable1.setSelectionForeground(Color.BLACK);
    }
    
    //===================FILTRAR PALAVRA JTABLE=========================
    public void filtro(String query) {
        DefaultTableModel modelo = (DefaultTableModel) tbl_cliente.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        tbl_cliente.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    //==================================================================
    //===================FILTRAR PALAVRA JTABLE=========================
    public void filtro2(String query) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    //==================================================================
    public void popularJtable() {
        ClienteDAO cdao = new ClienteDAO();
        DefaultTableModel modelo = (DefaultTableModel) tbl_cliente.getModel();
        modelo.setNumRows(0);

        for (Cliente c : cdao.find()) {

            modelo.addRow(new Object[]{
                c

            });

        }
    }
    
    
    public void readForID(Integer ID){
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        modelo.setNumRows(0);
        PedidoDAO pdao = new  PedidoDAO();
        
        for(Pedido p: pdao.readIDFechado(ID)){
            modelo.addRow(new Object[]{
                p.getID_pedido(),
                p.getOF(),
                p.getCodigo(),
                p.getData_pedido(),
                p.getData_entrega(),
                p.getQuantidade(),
                p.getTipo(),
                p.getStatus(),
                p.getPath_desenho()
                  
                    
                
            });
            
        }
            
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        filtro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tick = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tbl_cliente = new javax.swing.JTable();
        txt_cliente = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Pesquisa O.F Fechado");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa OF Aberto"));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "OF", "Código", "Data do Pedido", "Data da entrega", "Quantidade", "Produto", "Status", "Caminho:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(0);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nome Do Cliente:");

        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Pesquisar:");

        tick.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        tick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tickMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tickMouseReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Desenho:");

        tbl_cliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tbl_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_cliente.setColumnSelectionAllowed(true);
        tbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clienteMouseClicked(evt);
            }
        });
        tbl_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_clienteKeyPressed(evt);
            }
        });

        txt_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clienteActionPerformed(evt);
            }
        });
        txt_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_clienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filtro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tick, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGap(116, 116, 116))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tick, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(tbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
        // TODO add your handling code here:
        String query = filtro.getText();
        filtro2(query);
    }//GEN-LAST:event_filtroKeyReleased

    private void tickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tickMouseClicked
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {

            caminho = jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString();

            try {
                ProcessBuilder pb = new ProcessBuilder();
                pb.command("cmd.exe", "/c", caminho);
                pb.start();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro", "ERRO AO ABRIR O ARQUIVO", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para DAR BAIXA", "ERRO AO DAR BAIXA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tickMouseClicked

    private void tickMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tickMouseReleased
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {

            caminho = jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString();

            try {
                ProcessBuilder pb = new ProcessBuilder();
                pb.command("cmd.exe", "/c", caminho);
                pb.start();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro", "ERRO AO ABRIR O ARQUIVO", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para DAR BAIXA", "ERRO AO DAR BAIXA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tickMouseReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
     caminho = jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString();
        try {
            if (caminho.isEmpty()) {
                tick.setIcon(new ImageIcon(getClass().getResource("/images/cancel.png"))); // troca a imagem para o V certo
            } else {
                tick.setIcon(new ImageIcon(getClass().getResource("/images/tick.png"))); // troca a imagem para o V certo
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        caminho = jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString();
        try {
            if (caminho.isEmpty()) {
                tick.setIcon(new ImageIcon(getClass().getResource("/images/cancel.png"))); // troca a imagem para o V certo
            } else {
                tick.setIcon(new ImageIcon(getClass().getResource("/images/tick.png"))); // troca a imagem para o V certo
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void tbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clienteMouseClicked
        // TODO add your handling code here:

        c = (Cliente) tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0);
        txt_cliente.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0).toString());
        tbl_cliente.setVisible(false);
        ID_cliente = c.getID_CLIENTE();
        readForID(ID_cliente);
    }//GEN-LAST:event_tbl_clienteMouseClicked

    private void tbl_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_clienteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            c = (Cliente) tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0);
            txt_cliente.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0).toString());
            tbl_cliente.setVisible(false);
            ID_cliente = c.getID_CLIENTE();
            ID_cliente = c.getID_CLIENTE();
            readForID(ID_cliente);
        }
    }//GEN-LAST:event_tbl_clienteKeyPressed

    private void txt_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_clienteActionPerformed

    private void txt_clienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteKeyReleased
        // TODO add your handling code here:
        if (txt_cliente.getText().toString().length() <= 0) {
            tbl_cliente.setVisible(false);
        } else {

            tbl_cliente.setVisible(true);
            String query = txt_cliente.getText().toUpperCase();
            filtro(query);

        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tbl_cliente.changeSelection(0, 0, false, false);
            tbl_cliente.requestFocus();
        }
    }//GEN-LAST:event_txt_clienteKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbl_cliente;
    private javax.swing.JLabel tick;
    private javax.swing.JTextField txt_cliente;
    // End of variables declaration//GEN-END:variables
}