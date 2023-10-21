/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.qualidade;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.bean.Qualidade;
import model.dao.ClienteDAO;
import model.dao.QualidadeDAO;

/**
 *
 * @author gilberto
 */
public class TelaMedidas extends javax.swing.JInternalFrame {
    private int ID_cliente = 0;
    /**
     * Creates new form TelaMedidas
     */
    public TelaMedidas() {
        initComponents();
        this.setSize(1260,600);
        //======Ordenar a tabela=======
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));
        //====== COR NOS BOTOES=========
        Color VERMELHO = new Color(246, 165, 182);
        Color AZUL = new Color(180, 194, 240);
        Color VERDE = new Color(180, 240, 206);
        btn_atualizar.setBackground(AZUL);
        btn_lancar.setBackground(VERDE);
        btn_excluir.setBackground(VERMELHO);
        
        
        ClienteDAO cdao = new ClienteDAO();
        
        popularCmb();
        
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());
        //============================================================================
        findMedidas(data1,data2);
    }
    //===================FILTRAR PALAVRA JTABLE=========================
    public void filtro(String query){
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    //==================================================================
    public void limparCampos(){
        txt_ID.setText("");
        txt_of.setText("");
        txt_codigo.setText("");
        //cmb_cliente.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 3));
        txt_qtde.setText("");
        txt_sobra.setText("");
        txt_abertura.setText("");
        txt_arame.setText("");
        txt_interno.setText("");
        txt_externo.setText("");
        txt_passo.setText("");
        txt_lo_corpo.setText("");
        txt_lo_total.setText("");
        txt_espiras.setText("");
        cmb_acabamento.setSelectedIndex(-1);
        txt_obs.setText("");
    
    }
    
    public void popularCmb(){
        ClienteDAO cdao = new ClienteDAO();
        for (Cliente c : cdao.find()) {
            cmb_cliente.addItem(c);
        }
    }
    
    
    public void findMedidas(String d1, String d2) {              //PREENCHE TABELA COM OS VALORES
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        QualidadeDAO qdao = new QualidadeDAO();
        
        for (Qualidade q : qdao.readPorData(d1, d2)) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            modelo.addRow(new Object[]{
                q.getID_qualidade(),
                q.getOf(),
                q.getCodigo(),
                q.getCliente(),
                q.getQtde(),
                q.getSobra(),
                q.getAbertura().replace(".", ","),
                q.getArame().replace(".", ","),
                q.getInterno().replace(".", ","),
                q.getExterno().replace(".", ","),
                q.getPasso().replace(".", ","),
                q.getLo_corpo().replace(".", ","),
                q.getLo_total().replace(".", ","),
                q.getEspiras().replace(".", ","),
                q.getAcabamento(),
                q.getObs(),
                formato.format(q.getData())
                    

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_of = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        txt_qtde = new javax.swing.JTextField();
        txt_sobra = new javax.swing.JTextField();
        txt_obs = new javax.swing.JTextField();
        cmb_cliente = new javax.swing.JComboBox<>();
        txt_abertura = new javax.swing.JTextField();
        txt_arame = new javax.swing.JTextField();
        txt_externo = new javax.swing.JTextField();
        txt_interno = new javax.swing.JTextField();
        txt_passo = new javax.swing.JTextField();
        txt_lo_corpo = new javax.swing.JTextField();
        txt_lo_total = new javax.swing.JTextField();
        txt_espiras = new javax.swing.JTextField();
        cmb_acabamento = new javax.swing.JComboBox<>();
        txt_ID = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btn_lancar = new javax.swing.JButton();
        btn_atualizar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        filtro = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Medida de Molas");
        setPreferredSize(new java.awt.Dimension(1200, 621));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("O.F:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("CODIGO:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("CLIENTE:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("ABERTURA:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("ARAME:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("EXTERNO:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("INTERNO:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("LO(CORPO)");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("PASSO:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("LO(TOTAL)");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("ESPIRAS:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("QUANTIDADE:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("SOBRA:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("ACABAMENTO:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("OBS:");

        txt_of.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ofKeyPressed(evt);
            }
        });

        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoKeyPressed(evt);
            }
        });

        txt_qtde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_qtdeKeyPressed(evt);
            }
        });

        txt_sobra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_sobraKeyPressed(evt);
            }
        });

        txt_obs.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_obs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_obsActionPerformed(evt);
            }
        });
        txt_obs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_obsKeyPressed(evt);
            }
        });

        cmb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_clienteActionPerformed(evt);
            }
        });
        cmb_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_clienteKeyPressed(evt);
            }
        });

        txt_abertura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_aberturaKeyPressed(evt);
            }
        });

        txt_arame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_arameKeyPressed(evt);
            }
        });

        txt_externo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_externoKeyPressed(evt);
            }
        });

        txt_interno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_internoKeyPressed(evt);
            }
        });

        txt_passo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passoKeyPressed(evt);
            }
        });

        txt_lo_corpo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_lo_corpoKeyPressed(evt);
            }
        });

        txt_lo_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_lo_totalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_lo_totalKeyReleased(evt);
            }
        });

        txt_espiras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_espirasKeyPressed(evt);
            }
        });

        cmb_acabamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INOX", "OLEADA", "ZINCADA", "BICROMATIZADA", "PINTADA", "NIQUELADA", "TRIVALENTE" }));
        cmb_acabamento.setSelectedIndex(-1);
        cmb_acabamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_acabamentoActionPerformed(evt);
            }
        });
        cmb_acabamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_acabamentoKeyPressed(evt);
            }
        });

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Data Inicio:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Data Fim:");

        btn_lancar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_lancar.setText("LANÇAR");
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

        btn_atualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_atualizar.setText("ATUALIZAR");
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

        btn_excluir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_excluir.setText("EXCLUIR");
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

        filtro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Pesquisar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_of, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_qtde, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sobra, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txt_obs, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_abertura))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_arame))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_interno))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_externo))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_passo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_lo_corpo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_lo_total, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_espiras, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmb_acabamento, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_lancar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_atualizar)
                            .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19)
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sobra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_qtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_of)
                                    .addComponent(txt_obs)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_abertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_arame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_externo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_interno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_passo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_lo_corpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_lo_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_espiras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_acabamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_lancar)
                            .addGap(24, 24, 24)
                            .addComponent(btn_atualizar)
                            .addGap(18, 18, 18)
                            .addComponent(btn_excluir))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "O.F", "CODIGO", "CLIENTE", "QTDE", "SOBRA", "ABTRA", "ARAME", "INTE", "EXTE", "PASSO", "LO(CPO)", "LO(TOTAL)", "ESPI", "ACAB", "OBS", "DATA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(11).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(12).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(13).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(14).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(15).setPreferredWidth(1);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null,"Selecione uma linha para atualizar","ERRO AO ATUALIZAR",JOptionPane.ERROR_MESSAGE);
        } else {
        Qualidade q = new Qualidade();
        QualidadeDAO qDAO = new QualidadeDAO();
        q.setQtde(Integer.parseInt(txt_qtde.getText()));
        q.setID_qualidade(Integer.parseInt(txt_ID.getText()));
        q.setAbertura(txt_abertura.getText().replace(",", "."));
        q.setAcabamento(cmb_acabamento.getSelectedItem().toString());
        q.setArame(txt_arame.getText().replace(",", "."));
        q.setInterno(txt_interno.getText().replace(",", "."));
        q.setExterno(txt_externo.getText().replace(",", "."));
        q.setID_cliente(ID_cliente);
        q.setEspiras(txt_espiras.getText().replace(",", "."));
        q.setCodigo(txt_codigo.getText());
        q.setOf(Integer.parseInt(txt_of.getText()));
        q.setLo_corpo(txt_lo_corpo.getText().replace(",", "."));
        q.setLo_total(txt_lo_total.getText().replace(",", "."));
        q.setPasso(txt_passo.getText().replace(",", "."));
        q.setSobra(Integer.parseInt(txt_sobra.getText()));
        q.setObs(txt_obs.getText());
        q.setAcabamento(cmb_acabamento.getSelectedItem().toString());
        qDAO.update(q);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());
        findMedidas(data1, data2);
        limparCampos();
        }
    }//GEN-LAST:event_btn_atualizarActionPerformed

    private void btn_lancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lancarActionPerformed
        // TODO add your handling code here:
        Qualidade q = new Qualidade();
        QualidadeDAO qDAO = new QualidadeDAO();
        q.setOf(Integer.parseInt(txt_of.getText()));
        q.setCodigo(txt_codigo.getText());
        q.setID_cliente(ID_cliente);
        q.setQtde(Integer.parseInt(txt_qtde.getText()));
        q.setSobra(Integer.parseInt(txt_sobra.getText()));
        q.setAbertura(txt_abertura.getText().replace(",", "."));
        q.setArame(txt_arame.getText().replace(",", "."));
        q.setInterno(txt_interno.getText().replace(",", "."));
        q.setExterno(txt_externo.getText().replace(",", "."));
        q.setPasso(txt_passo.getText().replace(",", "."));
        q.setLo_corpo(txt_lo_corpo.getText().replace(",", "."));
        q.setLo_total(txt_lo_total.getText().replace(",", "."));
        q.setEspiras(txt_espiras.getText().replace(",", "."));
        q.setObs(txt_obs.getText());
        q.setAcabamento(cmb_acabamento.getSelectedItem().toString());
        qDAO.create(q,ID_cliente);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());
        findMedidas(data1,data2);
        limparCampos();
        
    }//GEN-LAST:event_btn_lancarActionPerformed

    private void cmb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_clienteActionPerformed
        // TODO add your handling code here:
        try {
        Cliente cliente = (Cliente) cmb_cliente.getSelectedItem();
        ID_cliente = cliente.getID_CLIENTE();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_cmb_clienteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        //-----------GAMBIARRA PARA FAZER O CMB_CLIENTE PEGAR O NOME---------
        Cliente c = new Cliente();
        c = (Cliente)jTable1.getValueAt(jTable1.getSelectedRow(), 3);
        cmb_cliente.getModel().setSelectedItem(c);
        //--------------------------------------------------------------------
        
        txt_ID.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        txt_of.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        txt_codigo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        cmb_cliente.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 3));
        txt_qtde.setText(jTable1.getValueAt(jTable1.getSelectedRow(),4).toString());
        txt_sobra.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        txt_abertura.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString().replace(",", "."));
        txt_arame.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString().replace(",", "."));
        txt_interno.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString().replace(",", "."));
        txt_externo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString().replace(",", "."));
        txt_passo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString().replace(",", "."));
        txt_lo_corpo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 11).toString().replace(",", "."));
        txt_lo_total.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 12).toString().replace(",", "."));
        txt_espiras.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 13).toString().replace(",", "."));
        cmb_acabamento.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 14));
        txt_obs.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 15).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());
        findMedidas(data1,data2);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        // TODO add your handling code here:
        Qualidade q = new Qualidade();
        QualidadeDAO qDAO = new QualidadeDAO();
        q.setID_qualidade(Integer.parseInt(txt_ID.getText()));
        qDAO.delete(q);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String data1 = dateFormat.format(jDateChooser1.getDate());
        String data2 = dateFormat.format(jDateChooser2.getDate());
        findMedidas(data1,data2);
        limparCampos();
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        //-----------GAMBIARRA PARA FAZER O CMB_CLIENTE PEGAR O NOME---------
        Cliente c = new Cliente();
        c = (Cliente)jTable1.getValueAt(jTable1.getSelectedRow(), 3);
        cmb_cliente.getModel().setSelectedItem(c);
        //--------------------------------------------------------------------
        
        txt_ID.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        txt_of.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        txt_codigo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        cmb_cliente.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 3));
        txt_qtde.setText(jTable1.getValueAt(jTable1.getSelectedRow(),4).toString());
        txt_sobra.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        txt_abertura.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString().replace(",", "."));
        txt_arame.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString().replace(",", "."));
        txt_interno.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString().replace(",", "."));
        txt_externo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString().replace(",", "."));
        txt_passo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString().replace(",", "."));
        txt_lo_corpo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 11).toString().replace(",", "."));
        txt_lo_total.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 12).toString().replace(",", "."));
        txt_espiras.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 13).toString().replace(",", "."));
        cmb_acabamento.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 14));
        txt_obs.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 15).toString());
    }//GEN-LAST:event_jTable1KeyReleased

    private void txt_obsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_obsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_obsActionPerformed

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
        // TODO add your handling code here:
        String query = filtro.getText();
        filtro(query);
    }//GEN-LAST:event_filtroKeyReleased

    private void filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroActionPerformed

    private void txt_obsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_obsKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_abertura.requestFocus();
        }
    }//GEN-LAST:event_txt_obsKeyPressed

    private void txt_passoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_lo_corpo.requestFocus();
        }
    }//GEN-LAST:event_txt_passoKeyPressed

    private void cmb_acabamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_acabamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_acabamentoActionPerformed

    private void cmb_acabamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_acabamentoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_lancar.requestFocus();
        }
    }//GEN-LAST:event_cmb_acabamentoKeyPressed

    private void btn_lancarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_lancarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            btn_atualizar.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_lancar.doClick();
        }
    }//GEN-LAST:event_btn_lancarKeyPressed

    private void btn_atualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_atualizarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btn_lancar.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            btn_excluir.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_atualizar.doClick();
        }
    }//GEN-LAST:event_btn_atualizarKeyPressed

    private void btn_excluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_excluirKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btn_atualizar.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_excluir.doClick();
        }
    }//GEN-LAST:event_btn_excluirKeyPressed

    private void txt_ofKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ofKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_codigo.requestFocus();
        }
    }//GEN-LAST:event_txt_ofKeyPressed

    private void txt_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmb_cliente.requestFocus();
        }
    }//GEN-LAST:event_txt_codigoKeyPressed

    private void cmb_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_clienteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_qtde.requestFocus();
        }
    }//GEN-LAST:event_cmb_clienteKeyPressed

    private void txt_qtdeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_qtdeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_sobra.requestFocus();
        }
    }//GEN-LAST:event_txt_qtdeKeyPressed

    private void txt_sobraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sobraKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_obs.requestFocus();
        }
    }//GEN-LAST:event_txt_sobraKeyPressed

    private void txt_aberturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_aberturaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_arame.requestFocus();
        }
    }//GEN-LAST:event_txt_aberturaKeyPressed

    private void txt_arameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_arameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_interno.requestFocus();
        }
    }//GEN-LAST:event_txt_arameKeyPressed

    private void txt_internoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_internoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_externo.requestFocus();
        }
    }//GEN-LAST:event_txt_internoKeyPressed

    private void txt_externoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_externoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_passo.requestFocus();
        }
    }//GEN-LAST:event_txt_externoKeyPressed

    private void txt_lo_corpoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lo_corpoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_lo_total.requestFocus();
        }
    }//GEN-LAST:event_txt_lo_corpoKeyPressed

    private void txt_lo_totalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lo_totalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lo_totalKeyReleased

    private void txt_lo_totalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lo_totalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_espiras.requestFocus();
        }
    }//GEN-LAST:event_txt_lo_totalKeyPressed

    private void txt_espirasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_espirasKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmb_acabamento.requestFocus();
        }
    }//GEN-LAST:event_txt_espirasKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_lancar;
    private javax.swing.JComboBox<String> cmb_acabamento;
    private javax.swing.JComboBox<Object> cmb_cliente;
    private javax.swing.JTextField filtro;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_abertura;
    private javax.swing.JTextField txt_arame;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_espiras;
    private javax.swing.JTextField txt_externo;
    private javax.swing.JTextField txt_interno;
    private javax.swing.JTextField txt_lo_corpo;
    private javax.swing.JTextField txt_lo_total;
    private javax.swing.JTextField txt_obs;
    private javax.swing.JTextField txt_of;
    private javax.swing.JTextField txt_passo;
    private javax.swing.JTextField txt_qtde;
    private javax.swing.JTextField txt_sobra;
    // End of variables declaration//GEN-END:variables
}
