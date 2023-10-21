/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.TelasOF;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
public class TelaCadastroOF extends javax.swing.JInternalFrame {
    private int ID_cliente = 0;
    String caminho = "";
    Cliente c;
    /**
     * Creates new form TelaCadastroOF
     */
    public TelaCadastroOF() {
        initComponents();
        tbl_cliente.setVisible(false);
        popularJtable();
        readForID();
        
        //====== COR NOS BOTOES=========
        Color VERDE = new Color(180, 240, 206);
        btn_cadastrar_of.setBackground(VERDE);
        Color AZUL = new Color(180, 194, 240);
        btn_baixa_of.setBackground(AZUL);
        
        //===========CLICK NO Jlabel V/X =============
        
    }
    //===================FILTRAR PALAVRA JTABLE=========================
    public void filtro(String query) {
        DefaultTableModel modelo = (DefaultTableModel) tbl_cliente.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        tbl_cliente.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    //====================LIMPA OS CAMPOS============================
    public void limparCampos(){
        txt_OF.setText("");
        txt_cliente.setText("");
        txt_codigo.setText("");
        txt_quantidade.setText("");
        txtf_data_entrega.setText("");
        txtf_data_pedido.setText("");
        cmb_produto.setSelectedIndex(1);
        tick.setIcon(new ImageIcon(getClass().getResource("/images/cancel.png")));
    
    }
    
    //====POPULA JTABLE COM OS NOMES DOS CLIENTES===========
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
    //===================FILTRAR PALAVRA JTABLE=========================
    public void filtro2(String query) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    //==================================================================
   
    
    public void readForID(){
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        modelo.setNumRows(0);
        PedidoDAO pdao = new  PedidoDAO();
        
        for(Pedido p: pdao.readAll()){
            modelo.addRow(new Object[]{
                
                p.getID_pedido(),
                p.getOF(),
                p.getCodigo(),
                p.getNome_cliente(),
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
        jLabel1 = new javax.swing.JLabel();
        txt_OF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_produto = new javax.swing.JComboBox<>();
        txtf_data_pedido = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtf_data_entrega = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_quantidade = new javax.swing.JTextField();
        btn_cadastrar_of = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        btn_baixa_of = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tick = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        tbl_cliente = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        filtro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Cadastrar/Dar Baixa em OF");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de OF"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("OF:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Nome do Cliente:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Produto:");

        cmb_produto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cmb_produto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Molas Niqueladas", "Ponteiras", "Ganchinhos", "Diversos", "Bicromatizada", "Trivalente", "Zincada" }));

        try {
            txtf_data_pedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtf_data_pedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Data do Pedido:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Data de Entrega:");

        try {
            txtf_data_entrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtf_data_entrega.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtf_data_entrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf_data_entregaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Quantidade:");

        txt_quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantidadeActionPerformed(evt);
            }
        });

        btn_cadastrar_of.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_cadastrar_of.setText("Cadastrar ");
        btn_cadastrar_of.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrar_ofActionPerformed(evt);
            }
        });
        btn_cadastrar_of.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_cadastrar_ofKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Código:");

        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });

        btn_baixa_of.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_baixa_of.setText("Dar Baixa");
        btn_baixa_of.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_baixa_ofActionPerformed(evt);
            }
        });
        btn_baixa_of.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_baixa_ofKeyPressed(evt);
            }
        });

        jButton1.setText("Desenho");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        tick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tickMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tickMouseReleased(evt);
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Pesquisar:");

        filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroActionPerformed(evt);
            }
        });
        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "OF", "Código", "Nome Cliente", "Data do Pedido", "Data de Entrga", "Quantidade", "Produto", "Status", "PDF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(0);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_OF)
                    .addComponent(jLabel4)
                    .addComponent(txtf_data_pedido)
                    .addComponent(txt_quantidade)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cadastrar_of, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtf_data_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_baixa_of))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmb_produto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addComponent(tick, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tick, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_OF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtf_data_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtf_data_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(5, 5, 5)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_cadastrar_of)
                        .addComponent(btn_baixa_of))
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_cliente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtf_data_entregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf_data_entregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtf_data_entregaActionPerformed

    private void txt_quantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantidadeActionPerformed

    private void btn_cadastrar_ofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrar_ofActionPerformed

        Pedido p1 = new Pedido();
        PedidoDAO pdao = new PedidoDAO();
        p1.setCliente(c);
        p1.setOF(txt_OF.getText());
        p1.setCodigo(txt_codigo.getText());
        p1.setData_pedido(txtf_data_pedido.getText());
        p1.setData_entrega(txtf_data_entrega.getText());
        p1.setQuantidade(Integer.parseInt(txt_quantidade.getText()));
        p1.setTipo(cmb_produto.getSelectedItem().toString());
        p1.setPath_desenho(caminho);
        p1.setStatus("Aberto");
        p1.setCliente(c);

        pdao.create(p1);
        limparCampos();
        readForID(); //atualiza tabela
    }//GEN-LAST:event_btn_cadastrar_ofActionPerformed

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        limparCampos();
        txt_OF.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        txt_codigo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        txtf_data_pedido.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        txtf_data_entrega.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        txt_quantidade.setText(jTable1.getValueAt(jTable1.getSelectedRow(),6).toString());
        cmb_produto.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
        caminho = jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString();
        try {
            if(caminho.isEmpty()){
            tick.setIcon(new ImageIcon(getClass().getResource("/images/cancel.png"))); // troca a imagem para o V certo
        }
            else
                tick.setIcon(new ImageIcon(getClass().getResource("/images/tick.png"))); // troca a imagem para o V certo
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here
        limparCampos();
        txt_OF.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        txt_codigo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        txtf_data_pedido.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        txtf_data_entrega.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        txt_quantidade.setText(jTable1.getValueAt(jTable1.getSelectedRow(),6).toString());
        cmb_produto.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
        caminho = jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString();
        try {
            if(caminho.isEmpty()){
            tick.setIcon(new ImageIcon(getClass().getResource("/images/cancel.png"))); // troca a imagem para o V certo
        }
            else
                tick.setIcon(new ImageIcon(getClass().getResource("/images/tick.png"))); // troca a imagem para o V certo
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void btn_baixa_ofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_baixa_ofActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() != -1) { 
        Pedido p1 = new Pedido();
        PedidoDAO pdao = new PedidoDAO();
       
        p1.setID_pedido((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        
        pdao.updateStatus(p1);
        readForID();
       
       }
       else
           JOptionPane.showMessageDialog(null,"Selecione uma linha para DAR BAIXA","ERRO AO DAR BAIXA",JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_btn_baixa_ofActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Selecione um desenho:");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int opc = fc.showOpenDialog(this);
        if(opc == JFileChooser.APPROVE_OPTION){
            File path = new File("Path");
            path = fc.getSelectedFile(); //recebe o caminho do arquivo
            caminho = path.getAbsolutePath();
            
            ImageIcon certo = new ImageIcon("images/tick.png"); 
            tick.setIcon(new ImageIcon(getClass().getResource("/images/tick.png"))); // troca a imagem para o V certo
        }
        else
            JOptionPane.showMessageDialog(null,"Erro","ERRO AO ABRIR O ARQUIVO",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tickMouseClicked
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() != -1) { 
        
        caminho=jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString();
        
            try {
                ProcessBuilder pb = new ProcessBuilder();
                pb.command("cmd.exe","/c",caminho);
                pb.start();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Erro","ERRO AO ABRIR O ARQUIVO",JOptionPane.ERROR_MESSAGE);
            }
       
       }
        
    }//GEN-LAST:event_tickMouseClicked

    private void tickMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tickMouseReleased
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() != -1) { 
        
        caminho=jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString();
        
            try {
                ProcessBuilder pb = new ProcessBuilder();
                pb.command("cmd.exe","/c",caminho);
                pb.start();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Erro","ERRO AO ABRIR O ARQUIVO",JOptionPane.ERROR_MESSAGE);
            }
       
       }
        
    }//GEN-LAST:event_tickMouseReleased

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

    private void tbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clienteMouseClicked
        // TODO add your handling code here:
        c = (Cliente) tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0);
        System.out.println(c.getID_CLIENTE());
        txt_cliente.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0).toString());
        tbl_cliente.setVisible(false);
    }//GEN-LAST:event_tbl_clienteMouseClicked

    private void tbl_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_clienteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            c = (Cliente) tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0);
            txt_cliente.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0).toString());
            tbl_cliente.setVisible(false);
            txt_OF.requestFocus();
        }
    }//GEN-LAST:event_tbl_clienteKeyPressed

    private void btn_cadastrar_ofKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_cadastrar_ofKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_cadastrar_of.doClick();
        }
    }//GEN-LAST:event_btn_cadastrar_ofKeyPressed

    private void btn_baixa_ofKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_baixa_ofKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_baixa_of.doClick();
        }
    }//GEN-LAST:event_btn_baixa_ofKeyPressed

    private void filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroActionPerformed

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
        // TODO add your handling code here:
        String query = filtro.getText();
        filtro2(query);
    }//GEN-LAST:event_filtroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_baixa_of;
    private javax.swing.JButton btn_cadastrar_of;
    private javax.swing.JComboBox<String> cmb_produto;
    private javax.swing.JTextField filtro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbl_cliente;
    private javax.swing.JLabel tick;
    private javax.swing.JTextField txt_OF;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_quantidade;
    private javax.swing.JFormattedTextField txtf_data_entrega;
    private javax.swing.JFormattedTextField txtf_data_pedido;
    // End of variables declaration//GEN-END:variables
}
