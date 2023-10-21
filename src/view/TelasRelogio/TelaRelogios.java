/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.TelasRelogio;

import java.awt.Color;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Pedido;
import model.bean.Relogio;
import model.dao.PedidoDAO;
import model.dao.RelogioDAO;

/**
 *
 * @author gilberto
 */
public class TelaRelogios extends javax.swing.JInternalFrame {
    Double resultado1;
    Double resultado2;
    
    
    /**
     * Creates new form TelaRelogios
     */
    public TelaRelogios() {
        initComponents();
        

        //-------ORDENA TABELA 1--------
        DefaultTableModel modelo = (DefaultTableModel) jTable5.getModel();
        jTable5.setRowSorter(new TableRowSorter(modelo));
        //-------ORDENA TABELA 2--------
        DefaultTableModel modelo1 = (DefaultTableModel) jTable8.getModel();
        jTable8.setRowSorter(new TableRowSorter(modelo1));
        //====== COR NOS BOTOES=========
        Color VERMELHO = new Color(246, 165, 182);
        Color AZUL = new Color(180, 194, 240);
        Color VERDE = new Color(180, 240, 206);
        btn_atualizar1.setBackground(AZUL);
        btn_lancar1.setBackground(VERDE);
        btn_atualizar3.setBackground(VERMELHO);
        btn_atualizar2.setBackground(AZUL);
        btn_lancar2.setBackground(VERDE);
        btn_atualizar4.setBackground(VERMELHO);

        //======================Deixar o jDateChooser com data Default================
        Calendar c1 = Calendar.getInstance();   // this takes current date
        c1.set(Calendar.DAY_OF_MONTH, 1);       // pega o primeiro dia do mes

        Integer ultimo_dia = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH); // pega o ultimo dia do mes

        Calendar c2 = Calendar.getInstance();   // this takes current date
        c2.set(Calendar.DAY_OF_MONTH, ultimo_dia);  //pega o primeiro dia do mes

        //RELOGIO 1
        Date date1 = new Date();
        Date date2 = new Date();
        date1 = c1.getTime();
        date2 = c2.getTime();
        //RELOGIO 2
        Date date3 = new Date();
        Date date4 = new Date();
        date3 = c1.getTime();
        date4 = c2.getTime();

        jDateChooser1.setDate(date1);
        jDateChooser2.setDate(date2);
        jDateChooser3.setDate(date3);
        jDateChooser4.setDate(date4);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //RELOGIO1
        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());
        //RELOGIO 2
        String data3 = dateFormat.format(jDateChooser3.getDate());
        String data4 = dateFormat.format(jDateChooser4.getDate());
        findRelogio1(data1, data2);
        findRelogio2(data3, data4);
        //=======total de gasto=======
        totalGastoRelogioMes(1);
        totalGastoRelogioMes(2);
    }
    public void totalGastoRelogioMes(int tabela){
        Double totalCima=0.0;
        Double totalBaixo=0.0;
        DecimalFormat formatoDec = new DecimalFormat("0.00");
        if(tabela==1){
        //Soma as colunas da tablea 1
        for (int i = 0; i < jTable5.getRowCount(); i++) {
            totalCima = totalCima + Double.parseDouble(jTable5.getValueAt(i, 3).toString().replace(",", "."));
        }
        
        total_cima.setText(formatoDec.format(totalCima));
        }
        
        else{
        //Soma as colunas da tablea 2
        for (int i = 0; i < jTable8.getRowCount(); i++) {
            totalBaixo = totalBaixo + Double.parseDouble(jTable8.getValueAt(i, 3).toString().replace(",", "."));
        }
        total_baixo.setText(formatoDec.format(totalBaixo));
        }
    }

    public void findRelogio1(String data1, String data2) {
        DefaultTableModel modelo = (DefaultTableModel) jTable5.getModel();
        modelo.setNumRows(0);
        RelogioDAO rdao = new RelogioDAO();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat formatoDec = new DecimalFormat("0.00");
        for (Relogio r : rdao.read1(data1, data2)) {
            resultado1 =((r.getFim() - r.getInicio()))*1.0;
            resultado1 = resultado1/100;
            modelo.addRow(new Object[]{
                r.getID_relogio(),
                r.getInicio(),
                r.getFim(),
                formatoDec.format(resultado1),
                formato.format(r.getData())

            });

        }
    }

    public void findRelogio2(String data3, String data4) {
        DefaultTableModel modelo = (DefaultTableModel) jTable8.getModel();
        modelo.setNumRows(0);
        RelogioDAO rdao = new RelogioDAO();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat formatoDec = new DecimalFormat("0.00");
        for (Relogio r : rdao.read2(data3, data4)) {
            resultado2 =((r.getFim() - r.getInicio()))*1.0;
            resultado2 = resultado2/100;
            modelo.addRow(new Object[]{
                r.getID_relogio(),
                r.getInicio(),
                r.getFim(),
                formatoDec.format(resultado2),
                formato.format(r.getData())

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
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        txt_inicio1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_fim1 = new javax.swing.JTextField();
        btn_lancar1 = new javax.swing.JButton();
        btn_atualizar1 = new javax.swing.JButton();
        txt_ID1 = new javax.swing.JTextField();
        btn_atualizar3 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btn_lancar4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        total_cima = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        txt_inicio2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_fim2 = new javax.swing.JTextField();
        btn_lancar2 = new javax.swing.JButton();
        btn_atualizar2 = new javax.swing.JButton();
        txt_ID2 = new javax.swing.JTextField();
        btn_atualizar4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        btn_lancar3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        total_baixo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Relogio (Cima)/Relogio (Baixo)");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relogio (Cima)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Inicio Dia", "Fim Dia", "Consumo Total", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.getTableHeader().setReorderingAllowed(false);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jTable5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable5KeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(0).setResizable(false);
            jTable5.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable5.getColumnModel().getColumn(1).setResizable(false);
            jTable5.getColumnModel().getColumn(2).setResizable(false);
            jTable5.getColumnModel().getColumn(3).setResizable(false);
            jTable5.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Inico do Dia:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Fim do Dia:");

        btn_lancar1.setText("Lançar");
        btn_lancar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lancar1ActionPerformed(evt);
            }
        });

        btn_atualizar1.setText("Atualizar");
        btn_atualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizar1ActionPerformed(evt);
            }
        });

        txt_ID1.setText("ID");
        txt_ID1.setEnabled(false);

        btn_atualizar3.setText("Excluir");
        btn_atualizar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizar3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Data Inicio:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Data Fim:");

        btn_lancar4.setText("Buscar Por Data");
        btn_lancar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lancar4ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Total Relogio Cima:");

        total_cima.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total_cima.setText("  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_inicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_fim1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_atualizar3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_atualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lancar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_cima, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_lancar4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel3)
                            .addComponent(total_cima))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_lancar4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_fim1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_lancar1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_inicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_atualizar1)
                    .addComponent(txt_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_atualizar3)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relogio (Baixo)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Inicio Dia", "Fim Dia", "Consumo Total", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable8.getTableHeader().setReorderingAllowed(false);
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jTable8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable8KeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(jTable8);
        if (jTable8.getColumnModel().getColumnCount() > 0) {
            jTable8.getColumnModel().getColumn(0).setResizable(false);
            jTable8.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable8.getColumnModel().getColumn(1).setResizable(false);
            jTable8.getColumnModel().getColumn(2).setResizable(false);
            jTable8.getColumnModel().getColumn(3).setResizable(false);
            jTable8.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Inico do Dia:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Fim do Dia:");

        btn_lancar2.setText("Lançar");
        btn_lancar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lancar2ActionPerformed(evt);
            }
        });

        btn_atualizar2.setText("Atualizar");
        btn_atualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizar2ActionPerformed(evt);
            }
        });

        txt_ID2.setText("ID");
        txt_ID2.setEnabled(false);

        btn_atualizar4.setText("Excluir");
        btn_atualizar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizar4ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Data Inicio:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Data Fim:");

        btn_lancar3.setText("Buscar Por Data");
        btn_lancar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lancar3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total Relogio Baixo:");

        total_baixo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total_baixo.setText("  ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(btn_atualizar4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(txt_ID2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_atualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_inicio2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_fim2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_lancar2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel19))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(total_baixo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_lancar3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel4)
                            .addComponent(total_baixo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_lancar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_inicio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_fim2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_lancar2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_atualizar2)
                    .addComponent(txt_ID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_atualizar4)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_lancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lancar1ActionPerformed
        // TODO add your handling code here:
        //-----LANÇA NO BANCO DE DADOS--------
        Relogio r = new Relogio();
        RelogioDAO rDAO = new RelogioDAO();

        r.setInicio(Integer.parseInt(txt_inicio1.getText()));
        r.setFim(Integer.parseInt(txt_fim1.getText()));
        r.setStatus("r1");
        rDAO.create(r);

        //------PEGA MODELO DA TABELA---------
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //RELOGIO1
        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());
        findRelogio1(data1, data2);
        btn_lancar1.setEnabled(false);
        txt_inicio1.setText("");
        txt_fim1.setText("");
        //=======total de gasto=======
        totalGastoRelogioMes(1);
    }//GEN-LAST:event_btn_lancar1ActionPerformed

    private void btn_lancar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lancar2ActionPerformed
        // TODO add your handling code here:
        //-----LANÇA NO BANCO DE DADOS--------
        Relogio r = new Relogio();
        RelogioDAO rDAO = new RelogioDAO();

        r.setInicio(Integer.parseInt(txt_inicio2.getText()));
        r.setFim(Integer.parseInt(txt_fim2.getText()));
        r.setStatus("r2");
        rDAO.create(r);

        //------PEGA MODELO DA TABELA---------
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //RELOGIO1
        String data1 = dateFormat.format(jDateChooser3.getDate());
        String data2 = dateFormat.format(jDateChooser4.getDate());
        findRelogio2(data1, data2);
        btn_lancar2.setEnabled(false);
        txt_inicio2.setText("");
        txt_fim2.setText("");
        //=======total de gasto=======
        totalGastoRelogioMes(2);
    }//GEN-LAST:event_btn_lancar2ActionPerformed

    private void btn_atualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizar2ActionPerformed
        // TODO add your handling code here:
        if (jTable8.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para atualizar", "ERRO AO ATUALIZAR", JOptionPane.ERROR_MESSAGE);
        } else {
            int ID_relogio, inicio, fim;

            ID_relogio = Integer.parseInt(txt_ID2.getText());
            inicio = Integer.parseInt(txt_inicio2.getText());
            fim = Integer.parseInt(txt_fim2.getText());

            RelogioDAO rDAO = new RelogioDAO();
            rDAO.update2(ID_relogio, inicio, fim);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //RELOGIO1
            String data1 = dateFormat.format(jDateChooser3.getDate());
            String data2 = dateFormat.format(jDateChooser4.getDate());
            findRelogio2(data1, data2);

        }
        //=======total de gasto=======
        totalGastoRelogioMes(2);
    }//GEN-LAST:event_btn_atualizar2ActionPerformed

    private void btn_atualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizar1ActionPerformed
        // TODO add your handling code here:
        if (jTable5.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para atualizar", "ERRO AO ATUALIZAR", JOptionPane.ERROR_MESSAGE);
        } else {

            int ID_relogio, inicio, fim;

            ID_relogio = Integer.parseInt(txt_ID1.getText());
            inicio = Integer.parseInt(txt_inicio1.getText());
            fim = Integer.parseInt(txt_fim1.getText());

            RelogioDAO rDAO = new RelogioDAO();
            rDAO.update1(ID_relogio, inicio, fim);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //RELOGIO1
            String data1 = dateFormat.format(jDateChooser1.getDate());
            String data2 = dateFormat.format(jDateChooser2.getDate());
            findRelogio1(data1, data2);

        }
        //=======total de gasto=======
        totalGastoRelogioMes(1);
    }//GEN-LAST:event_btn_atualizar1ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
        txt_ID1.setText(jTable5.getValueAt(jTable5.getSelectedRow(), 0).toString());
        txt_inicio1.setText(jTable5.getValueAt(jTable5.getSelectedRow(), 1).toString());
        txt_fim1.setText(jTable5.getValueAt(jTable5.getSelectedRow(), 2).toString());


    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable5KeyReleased
        // TODO add your handling code here:
        txt_ID1.setText(jTable5.getValueAt(jTable5.getSelectedRow(), 0).toString());
        txt_inicio1.setText(jTable5.getValueAt(jTable5.getSelectedRow(), 1).toString());
        txt_fim1.setText(jTable5.getValueAt(jTable5.getSelectedRow(), 2).toString());

    }//GEN-LAST:event_jTable5KeyReleased

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
        // TODO add your handling code here:
        txt_ID2.setText(jTable8.getValueAt(jTable8.getSelectedRow(), 0).toString());
        txt_inicio2.setText(jTable8.getValueAt(jTable8.getSelectedRow(), 1).toString());
        txt_fim2.setText(jTable8.getValueAt(jTable8.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_jTable8MouseClicked

    private void jTable8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable8KeyReleased
        // TODO add your handling code here:
        txt_ID2.setText(jTable8.getValueAt(jTable8.getSelectedRow(), 0).toString());
        txt_inicio2.setText(jTable8.getValueAt(jTable8.getSelectedRow(), 1).toString());
        txt_fim2.setText(jTable8.getValueAt(jTable8.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_jTable8KeyReleased

    private void btn_atualizar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizar3ActionPerformed
        // TODO add your handling code here:
        if (jTable5.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para atualizar", "ERRO AO ATUALIZAR", JOptionPane.ERROR_MESSAGE);
        } else {

            int ID_relogio;

            ID_relogio = Integer.parseInt(txt_ID1.getText());

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //RELOGIO1
            String data1 = dateFormat.format(jDateChooser1.getDate());
            String data2 = dateFormat.format(jDateChooser2.getDate());

            RelogioDAO rDAO = new RelogioDAO();
            rDAO.delete(ID_relogio);
            findRelogio1(data1, data2);
            txt_ID1.setText("");
            txt_inicio1.setText("");
            txt_fim1.setText("");

        }
        //=======total de gasto=======
        totalGastoRelogioMes(1);
    }//GEN-LAST:event_btn_atualizar3ActionPerformed

    private void btn_atualizar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizar4ActionPerformed
        // TODO add your handling code here:
        if (jTable8.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para atualizar", "ERRO AO ATUALIZAR", JOptionPane.ERROR_MESSAGE);
        } else {

            int ID_relogio;

            ID_relogio = Integer.parseInt(txt_ID2.getText());

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //RELOGIO2
            String data1 = dateFormat.format(jDateChooser3.getDate());
            String data2 = dateFormat.format(jDateChooser4.getDate());

            RelogioDAO rDAO = new RelogioDAO();
            rDAO.delete(ID_relogio);
            findRelogio2(data1, data2);
            txt_ID2.setText("");
            txt_inicio2.setText("");
            txt_fim2.setText("");

        }
        //=======total de gasto=======
        totalGastoRelogioMes(2);
    }//GEN-LAST:event_btn_atualizar4ActionPerformed

    private void btn_lancar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lancar3ActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //RELOGIO1
        String data1 = dateFormat.format(jDateChooser3.getDate());
        String data2 = dateFormat.format(jDateChooser4.getDate());
        findRelogio2(data1, data2);
        //=======total de gasto=======
        totalGastoRelogioMes(2);
    }//GEN-LAST:event_btn_lancar3ActionPerformed

    private void btn_lancar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lancar4ActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //RELOGIO1
        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());
        findRelogio1(data1, data2);
        //=======total de gasto=======
        totalGastoRelogioMes(1);
    }//GEN-LAST:event_btn_lancar4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar1;
    private javax.swing.JButton btn_atualizar2;
    private javax.swing.JButton btn_atualizar3;
    private javax.swing.JButton btn_atualizar4;
    private javax.swing.JButton btn_lancar1;
    private javax.swing.JButton btn_lancar2;
    private javax.swing.JButton btn_lancar3;
    private javax.swing.JButton btn_lancar4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable8;
    private javax.swing.JLabel total_baixo;
    private javax.swing.JLabel total_cima;
    private javax.swing.JTextField txt_ID1;
    private javax.swing.JTextField txt_ID2;
    private javax.swing.JTextField txt_fim1;
    private javax.swing.JTextField txt_fim2;
    private javax.swing.JTextField txt_inicio1;
    private javax.swing.JTextField txt_inicio2;
    // End of variables declaration//GEN-END:variables
}
