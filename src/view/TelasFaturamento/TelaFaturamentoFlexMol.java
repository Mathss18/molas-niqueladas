/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.TelasFaturamento;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.bean.Faturamento;
import model.dao.ClienteDAO;
import model.dao.FaturamentoDAO;

/**
 *
 * @author gilberto
 */
public class TelaFaturamentoFlexMol extends javax.swing.JInternalFrame {

    Cliente c = new Cliente();

    /**
     * Creates new form TelaFaturamento
     */
    public TelaFaturamentoFlexMol() {
        initComponents();
        tbl_cliente.setVisible(false);

        //====== COR NOS BOTOES=========
        Color VERMELHO = new Color(246, 165, 182);
        Color AZUL = new Color(180, 194, 240);
        Color VERDE = new Color(180, 240, 206);
        btn_atualizar.setBackground(AZUL);
        btn_lancar.setBackground(VERDE);
        btn_excluir.setBackground(VERMELHO);

        //======================Deixar o jDateChooser com data Default================
        Calendar c1 = Calendar.getInstance();   // this takes current date
        c1.set(Calendar.DAY_OF_MONTH, 1);       // pega o primeiro dia do mes

        Integer ultimo_dia = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH); // pega o ultimo dia do mes

        Calendar c2 = Calendar.getInstance();   // this takes current date
        c2.set(Calendar.DAY_OF_MONTH, ultimo_dia);  //pega o primeiro dia do mes

        Date date1 = new Date();
        Date date2 = new Date();
        date1 = c1.getTime();
        date2 = c2.getTime();

        jDateChooser1.setDate(date1);
        jDateChooser2.setDate(date2);
        //=====================Mostrar Valores canto superior esquerdo===============
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());
        AtualizarValorPeso(data1, data2);
        //============================================================================

        popularJtable();

        DefaultTableModel modelo = (DefaultTableModel) jTable6.getModel();
        jTable6.setRowSorter(new TableRowSorter(modelo));

        jTable6.setSelectionBackground(Color.yellow);
        jTable6.setSelectionForeground(Color.BLACK);
        findFaturamentoPorData(data1, data2);
        corNaLinha();

    }

    //===================FILTRAR PALAVRA JTABLE=========================
    public void filtro(String query) {
        DefaultTableModel modelo = (DefaultTableModel) tbl_cliente.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        tbl_cliente.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    //==================================================================

    public void corNaLinha() {
        String classe = "Aberto";
        jTable6.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Color c = Color.BLACK;
                String situacao = table.getValueAt(row, 3).toString();
                if (situacao.equals("Aberto")) { // SE A SITUACAO FOR "Aberto" PINTARÁ AS LETRAS EM VERMELHO
                    c = Color.RED;
                }
                label.setForeground(c);
                return label;
            }

        });

    }

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

    public void findFaturamentoPorData(String d1, String d2) {              //PREENCHE TABELA COM OS VALORES
        DefaultTableModel modelo = (DefaultTableModel) jTable6.getModel();
        modelo.setNumRows(0);
        FaturamentoDAO fdao = new FaturamentoDAO();
        DecimalFormat formato = new DecimalFormat("0.00");
        for (Faturamento f : fdao.readPorDataFM(d1, d2)) {

            modelo.addRow(new Object[]{
                f.getID_faturamento(),
                f.getVale(),
                f.getNfe(),
                f.getSituacao(),
                f.getCliente(),
                formato.format(f.getPeso()),
                formato.format(f.getValor()), //f.getCliente().getID_CLIENTE()
            });

        }
    }

    public void AtualizarValorPeso(String data1, String data2) {
        Double valor;
        Double peso;
        Double aberto;
        DecimalFormat formatoDec = new DecimalFormat("###,###,##0.00");
        FaturamentoDAO fDAO = new FaturamentoDAO();
        valor = fDAO.readValorFM(data1, data2);
        peso = fDAO.readPesoFM(data1, data2);
        aberto = fDAO.readValorAbertoFM(data1, data2);

        lbl_valor.setText(formatoDec.format(valor));
        lbl_peso.setText(formatoDec.format(peso));
        lbl_valor_aberto.setText(formatoDec.format(aberto));
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
        txt_vale = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_situacao = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_peso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_lancar = new javax.swing.JButton();
        btn_atualizar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        txt_ID = new javax.swing.JTextField();
        btn_excluir = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_valor = new javax.swing.JLabel();
        lbl_peso = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_valor_aberto = new javax.swing.JLabel();
        txt_nfe = new javax.swing.JTextField();
        txt_cliente = new javax.swing.JTextField();
        tbl_cliente = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Faturamento Flex-Mol");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Faturamento"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("O.F:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("NF-e");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Situação:");

        cmb_situacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aberto", "Pago" }));
        cmb_situacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_situacaoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Peso:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Valor");

        btn_lancar.setText("Lançar");
        btn_lancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lancarActionPerformed(evt);
            }
        });
        btn_lancar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_lancarKeyPressed(evt);
            }
        });

        btn_atualizar.setText("Atualizar");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });
        btn_atualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_atualizarKeyPressed(evt);
            }
        });

        jTable6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "O.F:", "NF-e", "Situação", "Cliente", "Peso", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.getTableHeader().setReorderingAllowed(false);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jTable6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable6KeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(0).setResizable(false);
            jTable6.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable6.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        txt_ID.setEnabled(false);
        txt_ID.setFocusable(false);
        txt_ID.setOpaque(false);
        txt_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDActionPerformed(evt);
            }
        });

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });
        btn_excluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_excluirKeyPressed(evt);
            }
        });

        jDateChooser2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDateChooser2FocusGained(evt);
            }
        });
        jDateChooser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser2MouseClicked(evt);
            }
        });
        jDateChooser2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser2KeyReleased(evt);
            }
        });

        jButton4.setText("Buscar por Data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Data Inicio:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Data Fim:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Faturamento Total:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Peso Total");

        lbl_valor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_valor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbl_peso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("R$:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("KG:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Faturamento Em Aberto:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("R$:");

        lbl_valor_aberto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_valor_aberto.setForeground(new java.awt.Color(255, 0, 0));
        lbl_valor_aberto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cliente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_vale, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(txt_peso, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel1)
                            .addComponent(btn_lancar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(txt_nfe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(56, 56, 56)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(cmb_situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_cliente)
                    .addComponent(tbl_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_peso, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_valor_aberto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addComponent(lbl_valor_aberto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel11))
                            .addComponent(lbl_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel12))
                            .addComponent(lbl_peso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_vale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_excluir)
                            .addComponent(btn_lancar)
                            .addComponent(btn_atualizar)))
                    .addComponent(tbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_lancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lancarActionPerformed
        // TODO add your handling code here:
        popularJtable();
        Faturamento f = new Faturamento();
        FaturamentoDAO fDAO = new FaturamentoDAO();

        f.setVale(txt_vale.getText());
        f.setNfe(txt_nfe.getText());
        f.setSituacao(cmb_situacao.getSelectedItem().toString());
        f.setCliente(c);
        f.setPeso(Double.parseDouble(txt_peso.getText().replace(",", ".")));
        f.setValor(Double.parseDouble(txt_valor.getText().replace(",", ".")));
        fDAO.createFM(f);
        //--------------------------------------------------------
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());

        findFaturamentoPorData(data1, data2);

        txt_ID.setText("");
        txt_vale.setText("");
        txt_nfe.setText("");
        txt_peso.setText("");
        txt_valor.setText("");
        txt_cliente.setText("");
        c = null;

        AtualizarValorPeso(data1, data2);

    }//GEN-LAST:event_btn_lancarActionPerformed

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        // TODO add your handling code here:
        if (jTable6.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para atualizar", "ERRO AO ATUALIZAR", JOptionPane.ERROR_MESSAGE);
        } else {

            int ID_faturamento;
            String situacao, vale, nfe;
            Double peso, valor;
            Cliente cliente;

            ID_faturamento = Integer.parseInt(txt_ID.getText());
            vale = txt_vale.getText();
            nfe = txt_nfe.getText();
            situacao = cmb_situacao.getSelectedItem().toString();
            cliente = (c);
            peso = Double.parseDouble(txt_peso.getText().replace(",", "."));
            valor = Double.parseDouble(txt_valor.getText().replace(",", "."));

            FaturamentoDAO fDAO = new FaturamentoDAO();
            fDAO.updateFM(ID_faturamento, vale, nfe, situacao, cliente, peso, valor);
            //--------------------------------------------------------------------------
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String data1 = dateFormat.format(jDateChooser1.getDate());
            String data2 = dateFormat.format(jDateChooser2.getDate());

            findFaturamentoPorData(data1, data2);
            txt_ID.setText("");
            txt_vale.setText("");
            txt_nfe.setText("");
            txt_peso.setText("");
            txt_valor.setText("");
            txt_cliente.setText("");
            c = null;

            AtualizarValorPeso(data1, data2);

        }
    }//GEN-LAST:event_btn_atualizarActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:

        txt_ID.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 0).toString());
        txt_vale.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 1).toString());
        txt_nfe.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 2).toString());
        cmb_situacao.setSelectedItem(jTable6.getValueAt(jTable6.getSelectedRow(), 3).toString());
        c = (Cliente) jTable6.getValueAt(jTable6.getSelectedRow(), 4);
        txt_cliente.setText(c.getNOME());
        txt_peso.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 5).toString());
        txt_valor.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 6).toString());

    }//GEN-LAST:event_jTable6MouseClicked

    private void jTable6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable6KeyReleased
        // TODO add your handling code here:

        txt_ID.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 0).toString());
        txt_vale.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 1).toString());
        txt_nfe.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 2).toString());
        cmb_situacao.setSelectedItem(jTable6.getValueAt(jTable6.getSelectedRow(), 3).toString());
        c = (Cliente) jTable6.getValueAt(jTable6.getSelectedRow(), 4);
        txt_cliente.setText(c.getNOME());
        txt_peso.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 5).toString());
        txt_valor.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 6).toString());

    }//GEN-LAST:event_jTable6KeyReleased

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        // TODO add your handling code here:
        if (jTable6.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir", "ERRO AO EXCLUIR", JOptionPane.ERROR_MESSAGE);
        } else {
            FaturamentoDAO fDAO = new FaturamentoDAO();
            int ID_faturamento;
            ID_faturamento = Integer.parseInt(txt_ID.getText());
            fDAO.delete(ID_faturamento);
            //------------------------------------------
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String data1 = dateFormat.format(jDateChooser1.getDate());
            String data2 = dateFormat.format(jDateChooser2.getDate());
            
            //ATUALIZA JTABLE
            findFaturamentoPorData(data1, data2);
            //LIMPA OS CAMPOS
            txt_ID.setText("");
            txt_vale.setText("");
            txt_nfe.setText("");
            txt_peso.setText("");
            txt_valor.setText("");
            txt_cliente.setText("");
            c = null;
            //ATUALIZA INFOSRMAÇÕES CANTO SUPERIOR ESQUERDO
            AtualizarValorPeso(data1, data2);
        }
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void jDateChooser2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jDateChooser2MouseClicked

    private void jDateChooser2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChooser2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser2FocusGained

    private void txt_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());
        findFaturamentoPorData(data1, data2);

        AtualizarValorPeso(data1, data2);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jDateChooser2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser2KeyReleased

    private void cmb_situacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_situacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_situacaoActionPerformed

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
        System.out.println(txt_cliente.getText().toString().length());
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tbl_cliente.changeSelection(0, 0, false, false);
            tbl_cliente.requestFocus();
        }
    }//GEN-LAST:event_txt_clienteKeyReleased

    private void tbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clienteMouseClicked
        // TODO add your handling code here:

        c = (Cliente) tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0);
        txt_cliente.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0).toString());
        tbl_cliente.setVisible(false);
    }//GEN-LAST:event_tbl_clienteMouseClicked

    private void tbl_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_clienteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            c = (Cliente) tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0);
            txt_cliente.setText(tbl_cliente.getValueAt(tbl_cliente.getSelectedRow(), 0).toString());
            tbl_cliente.setVisible(false);
            txt_peso.requestFocus();
        }
    }//GEN-LAST:event_tbl_clienteKeyPressed

    private void btn_lancarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_lancarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_lancar.doClick();
        }
    }//GEN-LAST:event_btn_lancarKeyPressed

    private void btn_atualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_atualizarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_atualizar.doClick();
        }
    }//GEN-LAST:event_btn_atualizarKeyPressed

    private void btn_excluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_excluirKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_excluir.doClick();
        }
    }//GEN-LAST:event_btn_excluirKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_lancar;
    private javax.swing.JComboBox<String> cmb_situacao;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable6;
    private javax.swing.JLabel lbl_peso;
    private javax.swing.JLabel lbl_valor;
    private javax.swing.JLabel lbl_valor_aberto;
    private javax.swing.JTable tbl_cliente;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_nfe;
    private javax.swing.JTextField txt_peso;
    private javax.swing.JTextField txt_vale;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
