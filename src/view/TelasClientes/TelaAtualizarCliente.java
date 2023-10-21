/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.TelasClientes;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.dao.ClienteDAO;

/**
 *
 * @author gilberto
 */
public class TelaAtualizarCliente extends javax.swing.JInternalFrame {
    private int ID_cliente=0;
    String telefone1="";
    String telefone2="";
    Cliente c_global;
    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaAtualizarCliente() {
        initComponents();
        popularJtable();
        //====== COR NOS BOTOES=========
        Color AZUL = new Color(180, 194, 240);
        btn_atualizar.setBackground(AZUL);
        //===============================
        tbl_cliente.setVisible(false);
    }
    //===================FILTRAR PALAVRA JTABLE=========================
    public void filtro(String query) {
        DefaultTableModel modelo = (DefaultTableModel) tbl_cliente.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        tbl_cliente.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    //==================================================================
    private void limparCampos(){
        txt_cliente.setText("");
        txt_bairro.setText("");
        txt_bairro.setText("");
        txt_cep.setText("");
        txt_cidade.setText("");
        txt_contato.setText("");
        txt_cpf.setText("");
        txt_email.setText("");
        txt_logradouro.setText("");
        txt_numero.setText("");
        txt_telefone.setText("");
        txt_telefone2.setText("");
        txt_inscricao.setText("");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_contato = new javax.swing.JTextField();
        txt_cliente = new javax.swing.JTextField();
        tbl_cliente = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_logradouro = new javax.swing.JTextField();
        txt_telefone = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_uf = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_cep = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        btn_cep = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_telefone2 = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_inscricao = new javax.swing.JTextField();
        btn_atualizar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Atualização de Cadastro de Cliente");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jLabel1.setText("Nome:");

        jLabel2.setText("CPF/CNPJ");

        jLabel7.setText("E-mail:");

        jLabel12.setText("Contato:");

        txt_contato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contatoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(txt_contato, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(txt_email)
                    .addComponent(jLabel2)
                    .addComponent(txt_cpf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(tbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/thumbnail_METALFLEX (fundo branco).png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço e Contato"));

        txt_logradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_logradouroActionPerformed(evt);
            }
        });

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Rua:");

        jLabel6.setText("Telefone:");

        txt_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cidadeActionPerformed(evt);
            }
        });

        jLabel8.setText("Cidade:");

        jLabel9.setText("UF:");

        cmb_uf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cmb_uf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ufActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero:");

        txt_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numeroActionPerformed(evt);
            }
        });

        jLabel10.setText("CEP:");

        try {
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Bairro:");

        txt_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bairroActionPerformed(evt);
            }
        });

        btn_cep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cep.setText("Buscar CEP");
        btn_cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cepActionPerformed(evt);
            }
        });

        jLabel15.setText("Fixo:");

        jLabel16.setText("Celular:");

        try {
            txt_telefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel17.setText("Inscrição Estadual:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_telefone2))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_logradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(cmb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11)
                    .addComponent(jLabel17)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_inscricao, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_bairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_logradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cep)
                            .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_telefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txt_inscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btn_atualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_atualizar.setText("Atualizar Cadastro");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_atualizar)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_atualizar)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_ufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_ufActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmb_ufActionPerformed

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        // TODO add your handling code here:
        telefone1 = txt_telefone.getText();
        telefone2 = txt_telefone2.getText();
        System.out.println(telefone1);
        System.out.println(telefone2);
        
        Cliente c = new Cliente();
        ClienteDAO cdao = new ClienteDAO();
        c.setNOME(txt_cliente.getText());
        c.setCPF_CNPJ(txt_cpf.getText());
        c.setEMAIL(txt_email.getText());
        c.setTELEFONE(txt_telefone.getText());
        c.setTELEFONE2(txt_telefone2.getText());
        c.setINSCRICAO_ESTADUAL(txt_inscricao.getText());
        c.setLOGRADOURO(txt_logradouro.getText());
        c.setNUMERO(txt_numero.getText());
        c.setCIDADE(txt_cidade.getText());
        c.setUF(cmb_uf.getSelectedItem().toString());
        c.setID_CLIENTE(ID_cliente);
        c.setBAIRRO(txt_bairro.getText());
        c.setCONTATO(txt_contato.getText());
        c.setCEP(txt_cep.getText());
        cdao.update(c);
        limparCampos();
        tbl_cliente.removeAll();
        popularJtable();
        c_global=null;
        
    }//GEN-LAST:event_btn_atualizarActionPerformed

    private void txt_logradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_logradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_logradouroActionPerformed

    private void txt_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cidadeActionPerformed

    private void txt_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numeroActionPerformed

    private void txt_contatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contatoActionPerformed

    private void txt_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bairroActionPerformed

    private void btn_cepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cepActionPerformed
        // TODO add your handling code here:
        WebServiceCep CEP = WebServiceCep.searchCep(txt_cep.getText());
        if(CEP.wasSuccessful()){
            txt_cidade.setText(CEP.getCidade());
            txt_logradouro.setText(CEP.getLogradouro());
            txt_bairro.setText(CEP.getBairro());
            cmb_uf.setSelectedItem(CEP.getUf());
        }
        else{
            JOptionPane.showMessageDialog(null, "CEP não localizado!","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_cepActionPerformed

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

        try {
                limparCampos();
                c_global = (Cliente) tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0);
            txt_cliente.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0).toString());
            ID_cliente = c_global.getID_CLIENTE();
            txt_bairro.setText(c_global.getBAIRRO());
            txt_cep.setText(c_global.getCEP());
            txt_cidade.setText(c_global.getCIDADE());
            cmb_uf.setSelectedItem(c_global.getUF().toString());
            txt_contato.setText(c_global.getCONTATO());
            txt_cpf.setText(c_global.getCPF_CNPJ());
            txt_email.setText(c_global.getEMAIL());
            txt_inscricao.setText(c_global.getINSCRICAO_ESTADUAL());
            txt_logradouro.setText(c_global.getLOGRADOURO());
            txt_numero.setText(c_global.getNUMERO());
            txt_telefone.setText(c_global.getTELEFONE());
            txt_telefone2.setText(c_global.getTELEFONE2());
            tbl_cliente.setVisible(false);
            txt_email.requestFocus();
            } catch (Exception e) {
            }
        
    }//GEN-LAST:event_tbl_clienteMouseClicked

    private void tbl_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_clienteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                limparCampos();
                c_global = (Cliente) tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0);
            txt_cliente.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0).toString());
            ID_cliente = c_global.getID_CLIENTE();
            txt_bairro.setText(c_global.getBAIRRO());
            txt_cep.setText(c_global.getCEP());
            txt_cidade.setText(c_global.getCIDADE());
            cmb_uf.setSelectedItem(c_global.getUF().toString());
            txt_contato.setText(c_global.getCONTATO());
            txt_cpf.setText(c_global.getCPF_CNPJ());
            txt_email.setText(c_global.getEMAIL());
            txt_inscricao.setText(c_global.getINSCRICAO_ESTADUAL());
            txt_logradouro.setText(c_global.getLOGRADOURO());
            txt_numero.setText(c_global.getNUMERO());
            txt_telefone.setText(c_global.getTELEFONE());
            txt_telefone2.setText(c_global.getTELEFONE2());
            tbl_cliente.setVisible(false);
            txt_email.requestFocus();
            } catch (Exception e) {
            }
            
        }
    }//GEN-LAST:event_tbl_clienteKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_cep;
    private javax.swing.JComboBox<String> cmb_uf;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable tbl_cliente;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_contato;
    private javax.swing.JTextField txt_cpf;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_inscricao;
    private javax.swing.JTextField txt_logradouro;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JFormattedTextField txt_telefone;
    private javax.swing.JFormattedTextField txt_telefone2;
    // End of variables declaration//GEN-END:variables
}
