/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.TelasEstoque;

import java.awt.Color;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Entrada_Produto;
import model.bean.Estoque;
import model.bean.Produto;
import model.bean.Saida_Produto;
import model.dao.ClienteDAO;
import model.dao.Entrada_ProdutoDAO;
import model.dao.EstoqueDAO;
import model.dao.ProdutoDAO;
import model.dao.Saida_ProdutoDAO;

/**
 *
 * @author gilberto
 */
public class TelaSaidaProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaEntradaProduto
     */
    public TelaSaidaProduto() {
        initComponents();
        ProdutoDAO pdao = new ProdutoDAO();
        
        for(Produto p: pdao.find()){
            cmb_produto.addItem(p);
        }
        //====== COR NOS BOTOES=========
        Color VERMELHO = new Color(246, 165, 182);
        btn_retirar.setBackground(VERMELHO);
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
        jLabel2 = new javax.swing.JLabel();
        txt_qtde = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_preco = new javax.swing.JTextField();
        cmb_produto = new javax.swing.JComboBox<>();
        btn_retirar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmb_banho = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Registrar Saida de Produto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Saida de Produto"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Produto:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Quantidade:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/thumbnail_METALFLEX (fundo branco).png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Preço:");

        txt_preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precoActionPerformed(evt);
            }
        });

        cmb_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_produtoActionPerformed(evt);
            }
        });

        btn_retirar.setText("Retirar");
        btn_retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retirarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Banho:");

        cmb_banho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COBRE 1", "COBRE 2", "NIQUEL 1", "NIQUEL 2", "CROMO", "FOSFATO", "ROTATIVO 1", "ROTATIVO 2", "ROTATIVO 3", "PARADO", "TRATAMENTO E.T.E" }));
        cmb_banho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_banhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cmb_banho, 0, 144, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_qtde, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btn_retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_banho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_qtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btn_retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_produtoActionPerformed
        // TODO add your handling code here:
        Produto produto = (Produto) cmb_produto.getSelectedItem();
        Estoque e = new Estoque();
        EstoqueDAO edao = new EstoqueDAO();
        edao.findPreco(produto);
        for(Estoque a: edao.findPreco(produto)){
            a.getValor_unitario();
            txt_preco.setText(String.valueOf(a.getValor_unitario()).replace(".", ","));
        }
        
        
        
        
        
        
    }//GEN-LAST:event_cmb_produtoActionPerformed

    private void btn_retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retirarActionPerformed
        // TODO add your handling code here:
        //=====VERIFICA SE QUANTIDADE A SER RETIRADA É MAIOR QUE QUANTIDADE DISPONIVEL NO ESTOQUE E NUMEROS SAO POSITIVOS=========
        if(Double.parseDouble(txt_qtde.getText().replace(",", "."))<=0.0 || Double.parseDouble(txt_preco.getText().replace(",", ".")) <=0.0 ){
            JOptionPane.showMessageDialog(null,"Imposivel utilizar valores Negativos ou Nulos!","ERRO AO RETIRAR",JOptionPane.ERROR_MESSAGE);
        }
        else{
        EstoqueDAO eDAO = new EstoqueDAO();
        Double qtdDisponivel = eDAO.findQtde((Produto)cmb_produto.getSelectedItem());
        
        if(Double.parseDouble(txt_qtde.getText().replace(",", "."))>qtdDisponivel){
            JOptionPane.showMessageDialog(null,"ERRO! Quantidade Disponivel em Estoque é: "+qtdDisponivel.toString().replace(".", ","),"ERRO AO RETIRAR",JOptionPane.ERROR_MESSAGE);
        }
        else{
        
        
        
        //================================================================================================
        Produto produto = (Produto) cmb_produto.getSelectedItem();
        Saida_Produto p = new Saida_Produto();
        Saida_ProdutoDAO pdao = new Saida_ProdutoDAO();
        p.setID_produto(produto);
        
        
        
        p.setQtde(Double.parseDouble(txt_qtde.getText().replace(",", ".")));
        p.setValor_unitario(Double.parseDouble(txt_preco.getText().replace(",", ".")));
        p.setBanho(cmb_banho.getSelectedItem().toString());
        
        
        pdao.create(p);
        //txt_preco.setText("");
        txt_qtde.setText("");

        }
        }
    }//GEN-LAST:event_btn_retirarActionPerformed

    private void cmb_banhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_banhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_banhoActionPerformed

    private void txt_precoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precoActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_txt_precoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_retirar;
    private javax.swing.JComboBox<String> cmb_banho;
    private javax.swing.JComboBox<Object> cmb_produto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_preco;
    private javax.swing.JTextField txt_qtde;
    // End of variables declaration//GEN-END:variables
}