/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.TelasEstoque;

import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Estoque;
import model.dao.EstoqueDAO;
import model.dao.ProdutoDAO;

/**
 *
 * @author gilberto
 */
public class TelaEqualizador extends javax.swing.JInternalFrame {
    Double dias_trab_aux;
    String banho_aux;
    Double c1,c2,n1,n2,p,r1,r2,r3 =0.0;
    /**
     * Creates new form TelaPesquisaClientes
     */
    public TelaEqualizador() {
        initComponents();
        
        
        
        
        //======================Deixar o jDateChooser com data Default================
        Calendar c1 = Calendar.getInstance();   // this takes current date
        c1.set(Calendar.DAY_OF_YEAR, 1);       // pega o primeiro dia do mes
        
        Integer ultimo_dia = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR); // pega o ultimo dia do ano
        
        Calendar c2 = Calendar.getInstance();   // this takes current date
        c2.set(Calendar.DAY_OF_YEAR, ultimo_dia);  //pega o ultimo dia do ano
        
        Date date1 = new Date();
        Date date2 = new Date();
        date1 = c1.getTime();
        date2 = c2.getTime();
        
        jDateChooser1.setDate(date1);
        jDateChooser2.setDate(date2);
        //==================SET INTERVALO DE X DIAS ===================================
        Date dataInico = jDateChooser1.getDate();
        Date dataFim =  jDateChooser2.getDate();
        long diffInMillies = Math.abs(dataFim.getTime() - dataInico.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)+1;

        jLabel5.setText(String.valueOf(diff));
        //============================================================================
        
        jTable1.setSelectionBackground(Color.yellow);
        jTable1.setSelectionForeground(Color.BLACK);
        
                
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));
        //============= COLOCAR COR NAS LINHAS (VERMELHO/AZUL)=====================
        corNaLinha();
        //=============AVISOS PARA MANUTENÇÃO NOS BANHOS===========================
        verificarAvisosBanho();
        
        
    }
    public void verificarAvisosBanho(){
    for(int i=0;i<11;i++){
        
            cmb_banho.setSelectedIndex(i);
            jButton1.doClick();
            switch(cmb_banho.getSelectedItem().toString()){
                case "COBRE 1":
                    c1 = dias_trab_aux;
                    break;
                case "COBRE 2":
                    c2 = dias_trab_aux;
                    break;
                case "NIQUEL 1":
                    n1 = dias_trab_aux;
                    break;
                case "NIQUEL 2":
                    n2 = dias_trab_aux;
                    break;
                case "ROTATIVO 1":
                    r1 = dias_trab_aux;
                    break;
                case "ROTATIVO 2":
                    r2 = dias_trab_aux;
                    break;
                case "ROTATIVO 3":
                    r3 = dias_trab_aux;
                    break;
                case "PARADO":
                    p = dias_trab_aux;
                    break;
                    
            }
    }
        cmb_banho.setSelectedIndex(0);
        jButton1.doClick();
        verificaAvisoBanhoFor();
    }
    public void verificaAvisoBanhoFor(){
            //=======INFORMAÇÃO COBRE===========
            if(c1>0.0 && (c1%25==0.0||c1%26==0.0)){
                JOptionPane.showMessageDialog(null,"FILTRAR COBRE 1","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
                
            }
            if(c2>0.0 && (c2%25==0.0||c2%26==0.0)){
                JOptionPane.showMessageDialog(null,"FILTRAR COBRE 2","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            //=======INFORMAÇÃO NIQUEL===========
            if(n1>0.0 && (n1%44==0.0||n1%45==0.0)){
                JOptionPane.showMessageDialog(null,"FILTRAR NIQUEL 1","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            if(n2>0.0 && (n2%44==0.0||n2%45==0.0)){
                JOptionPane.showMessageDialog(null,"FILTRAR NIQUEL 2","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            
            
            if(n1>0.0 && (n1%27==0.0||n1%28==0.0)){
                JOptionPane.showMessageDialog(null,"TROCAR ACIDO SULFURICO NIQUEL 1","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            if(n2>0.0 && (n2%27==0.0||n2%28==0.0)){
                JOptionPane.showMessageDialog(null,"TROCAR ACIDO SULFURICO NIQUEL 2","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            
            
            if(n1>0.0 && (n1%45==0.0||n1%46==0.0)){
                JOptionPane.showMessageDialog(null,"FAZER SELETIVA NIQUEL 1","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            if(n2>0.0 && (n2%45==0.0||n2%46==0.0)){
                JOptionPane.showMessageDialog(null,"FAZER SELETIVA NIQUEL 2","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            
            
            if(n1>0.0 && (n1%100==0.0||n1%101==0.0)){
                JOptionPane.showMessageDialog(null,"TROCAR ACIDO CLORIDRICO NIQUEL 1","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            if(n2>0.0 && (n2%100==0.0||n2%101==0.0)){
                JOptionPane.showMessageDialog(null,"TROCAR ACIDO CLORIDRICO NIQUEL 2","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            
            
            if(n1>0.0 && (n1%30==0.0||n1%31==0.0)){
                JOptionPane.showMessageDialog(null,"TROCAR DESENGRAXANTE(QUENTE) NIQUEL 1","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            if(n2>0.0 && (n2%30==0.0||n2%31==0.0)){
                JOptionPane.showMessageDialog(null,"TROCAR DESENGRAXANTE(QUENTE) NIQUEL 2","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            
            
            if(n1>0.0 && (n1%90==0.0||n1%91==0.0)){
                JOptionPane.showMessageDialog(null,"REFORÇAR DESENGRAXANTE ELETROLITICO (1 SACO) NIQUEL 1","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            if(n2>0.0 && (n2%90==0.0||n2%91==0.0)){
                JOptionPane.showMessageDialog(null,"REFORÇAR DESENGRAXANTE ELETROLITICO (1 SACO) NIQUEL 2","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            //============================BANHO ROTATIVO==========
            if(r1>0.0 && (r1%55==0.0||r1%56==0.0)){
                JOptionPane.showMessageDialog(null,"FILTRAR ROTATIVO 1","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            if(r2>0.0 && (r2%55==0.0||r2%56==0.0)){
                JOptionPane.showMessageDialog(null,"FILTRAR ROTATIVO 2","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            if(r3>0.0 && (r3%55==0.0||r3%56==0.0)){
                JOptionPane.showMessageDialog(null,"FILTRAR ROTATIVO 3","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            //============================BANHO PARADO==========
            if(p>0.0 && (p%55==0.0||p%56==0.0)){
                JOptionPane.showMessageDialog(null,"FILTRAR BANHO PARADO","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
            if(p>0.0 && (p%30==0.0||p%31==0.0)){
                JOptionPane.showMessageDialog(null,"TROCAR DESENGRAXANTE QUIMICO(QUENTE)","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
            }
    
    }
    
    
    
    public void findJtable(String banho,String dataInicio,String dataFim,String produto_coringa){
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        modelo.setNumRows(0);
        EstoqueDAO edao = new EstoqueDAO();
        int dias_trabalhados=edao.findDiasTrabalhadosPorProduto(banho, dataInicio, dataFim,produto_coringa);
        Double aux = dias_trabalhados*1.0;
        lbl_dias_trabalhados.setText(""+dias_trabalhados);
        dias_trab_aux =  aux;
        banho_aux = banho;
        float ideal_dia;
        String ideal_dia_formatado;
        String diferencaString;
        float diferencaDouble;
        DecimalFormat formatoDec = new DecimalFormat("0.00");
        DecimalFormat formatoDecMenor = new DecimalFormat("0.0");
        
        for(Estoque e: edao.findRelatorioIdeal(banho,dataInicio,dataFim)){
            if(e.getIdeal_dia()*dias_trabalhados==0.0){
                ideal_dia = e.getIdeal_dia();
                diferencaDouble= e.getQuantidade_utilizada()-ideal_dia;
                diferencaString = formatoDec.format(diferencaDouble).replace(",", ".");
                ideal_dia_formatado = formatoDecMenor.format(ideal_dia);
              
            }
            else{
                ideal_dia =e.getIdeal_dia()*dias_trabalhados;
                diferencaDouble= e.getQuantidade_utilizada()-ideal_dia;
                diferencaString = formatoDec.format(diferencaDouble).replace(",", ".");
                ideal_dia_formatado = formatoDecMenor.format(ideal_dia);
            }
            
            modelo.addRow(new Object[]{
                e.getNome(),
                formatoDec.format(e.getQuantidade_utilizada()),
                formatoDec.format(ideal_dia),
                //dif
                //ideal_dia_formatado
                //formatoDecMenor.format(diferenca)
                //ideal_dia_formatado
                diferencaString
                
                
                
                    
            });
            
        }
    }
    
    public void corNaLinha(){
        String classe = "Aberto";
        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            
            @Override
            public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                Color c;
                Color corVerde = new Color(20, 170, 5);
                Double diferenca = Double.parseDouble(table.getValueAt(row, 3).toString());
                if(diferenca>0.0){
                    c = corVerde;
                    
                }
                else if(diferenca==0.0){
                    c = Color.BLUE;
                }
                else{
                    c = Color.RED;
                }
                label.setForeground(c);
                return label;
            }
        
        
        });
    
    
    }
    
    public void findJtableIdeal(String banho,String dataInicio,String dataFim){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        modelo.setNumRows(0);
        EstoqueDAO edao = new EstoqueDAO();
        Double total;
        for(Estoque e: edao.findRelatorioSaida(banho,dataInicio,dataFim)){
            
            modelo.addRow(new Object[]{
                e.getNome(),
                e.getQtde(),
                e.getValor_unitario(),
                total=e.getValor_unitario()*e.getQtde(),
                formato.format(e.getData())
                
                    
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
        cmb_banho = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbl_dias_trabalhados = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Equalizador de Produtos");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Quantidade Utilizada", "Quantidade Ideal", "Diferença"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(6);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(1);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Banho:");

        cmb_banho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COBRE 1", "COBRE 2", "NIQUEL 1", "NIQUEL 2", "CROMO", "FOSFATO", "ROTATIVO 1", "ROTATIVO 2", "ROTATIVO 3", "PARADO", "TRATAMENTO E.T.E" }));
        cmb_banho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_banhoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Intervalo de:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Data Inicio:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Data Fim:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Dias");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Dias Trabalhados:");

        lbl_dias_trabalhados.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_banho, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_dias_trabalhados, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(390, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_dias_trabalhados, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_banho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_banhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_banhoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmb_banhoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());
        Date dataInico = jDateChooser1.getDate();
        Date dataFim =  jDateChooser2.getDate();
        
        long diffInMillies = Math.abs(dataFim.getTime() - dataInico.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)+1;

        jLabel5.setText(String.valueOf(diff));
        //int dias;
        //dias = Integer.parseInt(jLabel5.getText());
        
        
        
        String produto_coringa="";
        String banho;
        //==========TROCA OS VALORES DE IDEAL_DIA POIS CADA BANHO PODE TER UM MESMO PRODUTO COM DIFERENTES VALORES DE UTILIZAÇÃO DELE POR DIA =============
        switch(cmb_banho.getSelectedItem().toString()){
            case("COBRE 1"):
                produto_coringa = "CUBRAC BRIGHTENER";
                break;
            case("COBRE 2"):
                produto_coringa = "CUBRAC BRIGHTENER";
                break;
            case("NIQUEL 1"):
                produto_coringa = "ABRILHANTADOR YEAR 2000";
                ProdutoDAO pdaon = new ProdutoDAO();
                pdaon.updateIdealDia(0.45, 18); // ID:18 = ACIDO BORICO
                break;
            case("NIQUEL 2"):
                produto_coringa = "ABRILHANTADOR YEAR 2000";
                break;
            case("CROMO"):
                produto_coringa = "CHROME 100 L"; //nao achei infos do fosfato e chromo
                break;
            case("FOSFATO"):
                produto_coringa = "FOSTATIZANTE LIP MANGANES"; // NAO ACHEI UM CURINGA NO ECXEL COLOQUE ESSE :P
                break;
            case("TRATAMENTO E.T.E"):
                produto_coringa = "CAL QUIMICA HIDRATADA (FR 22)"; // NAO ACHEI UM CURINGA NO ECXEL COLOQUE ESSE :P
                break;
            case("PARADO"):
                produto_coringa = "ZETAPLUS MAKE-UP"; 
                ProdutoDAO pdao = new ProdutoDAO();
                pdao.updateIdealDia(0.08, 18); // ID:18 = ACIDO BORICO
                pdao.updateIdealDia(0.31,7); // ID:7 = CLORETO DE ZINCO
                pdao.updateIdealDia(0.15,19); // ID:19 = ZETAPLUS MAINTENCE
                pdao.updateIdealDia(1.00,8); // ID:8 = CLORETO DE POTASSIO
                pdao.updateIdealDia(0.30,20); // ID:20 = ZETAPLUS MAKEUP
                break;
            case("ROTATIVO 1"):
                produto_coringa = "ZETAPLUS MAKE-UP"; 
                ProdutoDAO pdao2 = new ProdutoDAO();
                pdao2.updateIdealDia(0.04, 18); // ID:18 = ACIDO BORICO
                pdao2.updateIdealDia(0.17,7); // ID:7 = CLORETO DE ZINCO
                pdao2.updateIdealDia(0.15,19); // ID:19 = ZETAPLUS MAINTENCE
                pdao2.updateIdealDia(0.53,8); // ID:8 = CLORETO DE POTASSIO
                pdao2.updateIdealDia(0.30,20); // ID:20 = ZETAPLUS MAKEUP
                break;
            case("ROTATIVO 2"):
                produto_coringa = "ZETAPLUS MAKE-UP";
                ProdutoDAO pdao3 = new ProdutoDAO();
                pdao3.updateIdealDia(0.04, 18); // ID:18 = ACIDO BORICO
                pdao3.updateIdealDia(0.17,7); // ID:7 = CLORETO DE ZINCO
                pdao3.updateIdealDia(0.15,19); // ID:19 = ZETAPLUS MAINTENCE
                pdao3.updateIdealDia(0.53,8); // ID:8 = CLORETO DE POTASSIO
                pdao3.updateIdealDia(0.30,20); // ID:20 = ZETAPLUS MAKEUP
                break;
            case("ROTATIVO 3"):
                produto_coringa = "ZETAPLUS MAKE-UP)"; 
                ProdutoDAO pdao4 = new ProdutoDAO();
                pdao4.updateIdealDia(0.04, 18); // ID:18 = ACIDO BORICO
                pdao4.updateIdealDia(0.17,7); // ID:7 = CLORETO DE ZINCO
                pdao4.updateIdealDia(0.15,19); // ID:19 = ZETAPLUS MAINTENCE
                pdao4.updateIdealDia(0.53,8); // ID:8 = CLORETO DE POTASSIO
                pdao4.updateIdealDia(0.30,20); // ID:20 = ZETAPLUS MAKEUP
                break;
                
                    
        }
        banho = cmb_banho.getSelectedItem().toString();
        findJtable(banho,data1,data2,produto_coringa);      
        } catch (Exception e) {
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_banho;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_dias_trabalhados;
    // End of variables declaration//GEN-END:variables
}
