package vistas;

import Instancia.InstanceOf;
import Instancia.InstanceOfDonacion;
import Operaciones.OperacionesExcel;
import accesoDatos.OperacionesDonacion;
import accesoDatos.OperacionesUsuarios;
import Operaciones.OperacionesReportes;
import clases.Donacion;
import clases.Donante;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.write.WriteException;

//import org.apache.poi.ss.usermodel.*;
public class RecoleccionLeche extends javax.swing.JFrame {

    OperacionesUsuarios opU = new OperacionesUsuarios();
    OperacionesDonacion opD = new OperacionesDonacion();
    OperacionesExcel opX = new OperacionesExcel();
    OperacionesReportes opr = new OperacionesReportes();
    String usu;
    String nombre = "";
    String apellido = "";
    String documento = "";
    Date fechaNac = null;
    String peso = "";
    String estatura = "";
    String telefono = "";
    String direccion = "";
    String semGest = "";
    Date fechaParto = null;
    String vdrl = "";
    String hbsag = "";
    String hiv = "";
    String transSang = "";
    String tabaq = "";
    String etilis = "";
    String aptaDon = "";
    Date fechaObtDatos = null;

    /** Creates new form RecoleccionLeche */
    public RecoleccionLeche() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setLocationRelativeTo(null);
        opD.listarDonantes(jtDonantes);
        Date f = enviarFecha("2012-01-01");
        jcFechaParto.setDate(f);
        Date fe = new Date();
        jcFechaObtDatos.setDate(fe);
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/iconBLH.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bgTipoDonacion = new javax.swing.ButtonGroup();
        VDRL = new javax.swing.ButtonGroup();
        HbsAg = new javax.swing.ButtonGroup();
        HIV = new javax.swing.ButtonGroup();
        trans = new javax.swing.ButtonGroup();
        tab = new javax.swing.ButtonGroup();
        etilismo = new javax.swing.ButtonGroup();
        aptaD = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDonaciones = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jsEstatura = new javax.swing.JSpinner();
        jsSGest = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jcFechaNac = new org.freixas.jcalendar.JCalendarCombo();
        jLabel34 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jcFechaParto = new org.freixas.jcalendar.JCalendarCombo();
        jsPeso = new javax.swing.JSpinner();
        jLabel36 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jrbHivNoD = new javax.swing.JRadioButton();
        jrbHivNeg = new javax.swing.JRadioButton();
        jrbHivPos = new javax.swing.JRadioButton();
        jrbVdrlPos = new javax.swing.JRadioButton();
        jrbVdrlNeg = new javax.swing.JRadioButton();
        jrbVdrlNoD = new javax.swing.JRadioButton();
        jrbHbsagPos = new javax.swing.JRadioButton();
        jrbHbsagNeg = new javax.swing.JRadioButton();
        jrbHbsagNoD = new javax.swing.JRadioButton();
        label = new javax.swing.JLabel();
        jrbTransSangSI = new javax.swing.JRadioButton();
        jrbTransSangNO = new javax.swing.JRadioButton();
        jLabel31 = new javax.swing.JLabel();
        jrbTabaqSI = new javax.swing.JRadioButton();
        jrbTabaqNO = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        jrbEtilNO = new javax.swing.JRadioButton();
        jrbEtilSI = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        jrbAptaSI = new javax.swing.JRadioButton();
        jrbAptaNO = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        jcFechaObtDatos = new org.freixas.jcalendar.JCalendarCombo();
        jLabel29 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtDonantes = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbSeleccionarBusquedaDonante = new javax.swing.JComboBox();
        jtfABuscar = new javax.swing.JTextField();
        jbBuscarDonante = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jbEliminarDonacion = new javax.swing.JButton();
        jbAbrirDonacion = new javax.swing.JButton();
        jbNuevaDonacion = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jbAbrirInfoDonante = new javax.swing.JButton();
        jbEliminarDonante = new javax.swing.JButton();
        jbNuevaDonante = new javax.swing.JButton();
        jbExcel = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jbCancelar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbPrint = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfTelefono = new javax.swing.JTextField();
        jcbTipoDocumento = new javax.swing.JComboBox();
        jtfNombre = new javax.swing.JTextField();
        jtfApellido = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jepDireccion = new javax.swing.JEditorPane();
        jLabel25 = new javax.swing.JLabel();
        jtfDocumento = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Donación -  Banco de Leche Humana");
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        net.java.dev.koalalayout.KoalaLayout koalaLayout1 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout1.setGridheight(30);
        koalaLayout1.setGridwidth(30);
        jPanel1.setLayout(koalaLayout1);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout6 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout6.setGridheight(30);
        koalaLayout6.setGridwidth(30);
        jPanel4.setLayout(koalaLayout6);

        jtDonaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Donacion", "Racion Donada", "Tipo", "Estatura(cm)", "Peso(lb)"
            }
        ));
        jtDonaciones.setRowHeight(25);
        jScrollPane1.setViewportView(jtDonaciones);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 30;
        gridBagConstraints.gridheight = 30;
        jPanel4.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 6;
        jPanel1.add(jPanel4, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(450, 345));
        net.java.dev.koalalayout.KoalaLayout koalaLayout8 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout8.setGridheight(30);
        koalaLayout8.setGridwidth(30);
        jPanel5.setLayout(koalaLayout8);

        jsEstatura.setEnabled(false);
        jsEstatura.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jsEstaturaMouseWheelMoved(evt);
            }
        });
        jsEstatura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsEstaturaStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        jPanel5.add(jsEstatura, gridBagConstraints);

        jsSGest.setEnabled(false);
        jsSGest.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jsSGestMouseWheelMoved(evt);
            }
        });
        jsSGest.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsSGestStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        jPanel5.add(jsSGest, gridBagConstraints);

        jLabel16.setText("Estatura (cm):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        jPanel5.add(jLabel16, gridBagConstraints);

        jLabel28.setText("Fecha de Nacimiento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 28;
        gridBagConstraints.gridheight = 2;
        jPanel5.add(jLabel28, gridBagConstraints);

        jcFechaNac.setDate(new java.util.Date(631202824000L));
        jcFechaNac.setEnabled(false);
        jcFechaNac.addDateListener(new org.freixas.jcalendar.DateListener() {
            public void dateChanged(org.freixas.jcalendar.DateEvent evt) {
                jcFechaNacDateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jcFechaNac, gridBagConstraints);

        jLabel34.setText("Sem. Gestación:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        jPanel5.add(jLabel34, gridBagConstraints);

        jLabel22.setText("Fecha del parto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        jPanel5.add(jLabel22, gridBagConstraints);

        jcFechaParto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lunes 1 de enero de 2012" }));
        jcFechaParto.setDate(new java.util.Date(631202824000L));
        jcFechaParto.setEnabled(false);
        jcFechaParto.addDateListener(new org.freixas.jcalendar.DateListener() {
            public void dateChanged(org.freixas.jcalendar.DateEvent evt) {
                jcFechaPartoDateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 28;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jcFechaParto, gridBagConstraints);

        jsPeso.setEnabled(false);
        jsPeso.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jsPesoMouseWheelMoved(evt);
            }
        });
        jsPeso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsPesoStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        jPanel5.add(jsPeso, gridBagConstraints);

        jLabel36.setText("Peso (lb):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        jPanel5.add(jLabel36, gridBagConstraints);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos/fondito1.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 30;
        gridBagConstraints.gridheight = 30;
        jPanel5.add(jLabel11, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 18;
        jPanel1.add(jPanel5, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(85, 142, 213));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12));
        jLabel1.setText("Donaciones:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(758, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 24;
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout13 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout13.setGridheight(30);
        koalaLayout13.setGridwidth(30);
        jPanel8.setLayout(koalaLayout13);

        jLabel19.setText("HbsAg:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jLabel19, gridBagConstraints);

        jLabel20.setText("Examenes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jLabel20, gridBagConstraints);

        jLabel21.setText("HIV:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jLabel21, gridBagConstraints);

        jLabel23.setText("VDRL:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jLabel23, gridBagConstraints);

        HIV.add(jrbHivNoD);
        jrbHivNoD.setText("No disp.");
        jrbHivNoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbHivNoDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbHivNoD, gridBagConstraints);

        HIV.add(jrbHivNeg);
        jrbHivNeg.setText("-");
        jrbHivNeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbHivNegActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbHivNeg, gridBagConstraints);

        HIV.add(jrbHivPos);
        jrbHivPos.setText("+");
        jrbHivPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbHivPosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbHivPos, gridBagConstraints);

        VDRL.add(jrbVdrlPos);
        jrbVdrlPos.setText("+");
        jrbVdrlPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbVdrlPosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbVdrlPos, gridBagConstraints);

        VDRL.add(jrbVdrlNeg);
        jrbVdrlNeg.setText("-");
        jrbVdrlNeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbVdrlNegActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbVdrlNeg, gridBagConstraints);

        VDRL.add(jrbVdrlNoD);
        jrbVdrlNoD.setText("No disp.");
        jrbVdrlNoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbVdrlNoDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbVdrlNoD, gridBagConstraints);

        HbsAg.add(jrbHbsagPos);
        jrbHbsagPos.setText("+");
        jrbHbsagPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbHbsagPosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbHbsagPos, gridBagConstraints);

        HbsAg.add(jrbHbsagNeg);
        jrbHbsagNeg.setText("-");
        jrbHbsagNeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbHbsagNegActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbHbsagNeg, gridBagConstraints);

        HbsAg.add(jrbHbsagNoD);
        jrbHbsagNoD.setText("No disp.");
        jrbHbsagNoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbHbsagNoDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbHbsagNoD, gridBagConstraints);

        label.setText("(últimos 5 años)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(label, gridBagConstraints);

        trans.add(jrbTransSangSI);
        jrbTransSangSI.setText("Si");
        jrbTransSangSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTransSangSIActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbTransSangSI, gridBagConstraints);

        trans.add(jrbTransSangNO);
        jrbTransSangNO.setText("No");
        jrbTransSangNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTransSangNOActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbTransSangNO, gridBagConstraints);

        jLabel31.setText("Transf. sanguínea");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jLabel31, gridBagConstraints);

        jrbTabaqSI.setBackground(new java.awt.Color(255, 255, 255));
        tab.add(jrbTabaqSI);
        jrbTabaqSI.setText("Si");
        jrbTabaqSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTabaqSIActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbTabaqSI, gridBagConstraints);

        jrbTabaqNO.setBackground(new java.awt.Color(255, 255, 255));
        tab.add(jrbTabaqNO);
        jrbTabaqNO.setText("No");
        jrbTabaqNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTabaqNOActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbTabaqNO, gridBagConstraints);

        jLabel32.setText("Tabaquismo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jLabel32, gridBagConstraints);

        jrbEtilNO.setBackground(new java.awt.Color(255, 255, 255));
        etilismo.add(jrbEtilNO);
        jrbEtilNO.setText("No");
        jrbEtilNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEtilNOActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbEtilNO, gridBagConstraints);

        jrbEtilSI.setBackground(new java.awt.Color(255, 255, 255));
        etilismo.add(jrbEtilSI);
        jrbEtilSI.setText("Si");
        jrbEtilSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEtilSIActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbEtilSI, gridBagConstraints);

        jLabel33.setText("Etilismo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jLabel33, gridBagConstraints);

        jrbAptaSI.setBackground(new java.awt.Color(255, 255, 255));
        aptaD.add(jrbAptaSI);
        jrbAptaSI.setFont(new java.awt.Font("Tahoma", 1, 11));
        jrbAptaSI.setText("Si");
        jrbAptaSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAptaSIActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbAptaSI, gridBagConstraints);

        jrbAptaNO.setBackground(new java.awt.Color(255, 255, 255));
        aptaD.add(jrbAptaNO);
        jrbAptaNO.setFont(new java.awt.Font("Tahoma", 1, 11));
        jrbAptaNO.setText("No");
        jrbAptaNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAptaNOActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jrbAptaNO, gridBagConstraints);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel35.setText("Apta para donar?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jLabel35, gridBagConstraints);

        jcFechaObtDatos.setDate(new java.util.Date(631202824000L));
        jcFechaObtDatos.setEnabled(false);
        jcFechaObtDatos.addDateListener(new org.freixas.jcalendar.DateListener() {
            public void dateChanged(org.freixas.jcalendar.DateEvent evt) {
                jcFechaObtDatosDateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.gridheight = 3;
        jPanel8.add(jcFechaObtDatos, gridBagConstraints);

        jLabel29.setText("Fecha obtención de datos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.gridheight = 2;
        jPanel8.add(jLabel29, gridBagConstraints);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos/fondito1.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 30;
        gridBagConstraints.gridheight = 30;
        jPanel8.add(jLabel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 18;
        jPanel1.add(jPanel8, gridBagConstraints);

        jtDonantes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtDonantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Donantes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtDonantes.setToolTipText("Donantes");
        jtDonantes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtDonantes.setRowHeight(25);
        jScrollPane6.setViewportView(jtDonantes);
        jtDonantes.getColumnModel().getColumn(0).setResizable(false);
        jtDonantes.getColumnModel().getColumn(0).setPreferredWidth(30);
        jtDonantes.getColumnModel().getColumn(1).setResizable(false);
        jtDonantes.getColumnModel().getColumn(1).setPreferredWidth(167);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 11;
        jPanel1.add(jScrollPane6, gridBagConstraints);

        jPanel9.setBackground(new java.awt.Color(0, 74, 138));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout14 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout14.setGridheight(8);
        koalaLayout14.setGridwidth(20);
        jPanel9.setLayout(koalaLayout14);

        jLabel2.setBackground(new java.awt.Color(255, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar por:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        jPanel9.add(jLabel2, gridBagConstraints);

        jcbSeleccionarBusquedaDonante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Documento", "Nombres\t", "Apellidos" }));
        jcbSeleccionarBusquedaDonante.setToolTipText("Seleccione una opción");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        jPanel9.add(jcbSeleccionarBusquedaDonante, gridBagConstraints);

        jtfABuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfABuscarKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 2;
        jPanel9.add(jtfABuscar, gridBagConstraints);

        jbBuscarDonante.setText("Buscar");
        jbBuscarDonante.setToolTipText("Buscar donante");
        jbBuscarDonante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarDonanteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        jPanel9.add(jbBuscarDonante, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 7;
        jPanel1.add(jPanel9, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(85, 142, 213));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 12));
        jLabel8.setText("Donante: ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addContainerGap(771, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 24;
        jPanel1.add(jPanel6, gridBagConstraints);

        jPanel10.setBackground(new java.awt.Color(85, 142, 213));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout15 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout15.setGridheight(4);
        koalaLayout15.setGridwidth(60);
        jPanel10.setLayout(koalaLayout15);

        jbEliminarDonacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        jbEliminarDonacion.setToolTipText("Eliminar donación");
        jbEliminarDonacion.setEnabled(false);
        jbEliminarDonacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarDonacionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        jPanel10.add(jbEliminarDonacion, gridBagConstraints);

        jbAbrirDonacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/folder.png"))); // NOI18N
        jbAbrirDonacion.setToolTipText("Abrir donación");
        jbAbrirDonacion.setEnabled(false);
        jbAbrirDonacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbrirDonacionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        jPanel10.add(jbAbrirDonacion, gridBagConstraints);

        jbNuevaDonacion.setBackground(new java.awt.Color(255, 255, 255));
        jbNuevaDonacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        jbNuevaDonacion.setToolTipText("Nueva donación");
        jbNuevaDonacion.setBorder(null);
        jbNuevaDonacion.setEnabled(false);
        jbNuevaDonacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbNuevaDonacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevaDonacionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        jPanel10.add(jbNuevaDonacion, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        jPanel1.add(jPanel10, gridBagConstraints);

        jPanel12.setBackground(new java.awt.Color(0, 74, 138));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout19 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout19.setGridheight(2);
        koalaLayout19.setGridwidth(20);
        jPanel12.setLayout(koalaLayout19);

        jLabel9.setBackground(new java.awt.Color(255, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 12));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Donantes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        jPanel12.add(jLabel9, gridBagConstraints);

        jbAbrirInfoDonante.setBackground(new java.awt.Color(255, 255, 255));
        jbAbrirInfoDonante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/folder.png"))); // NOI18N
        jbAbrirInfoDonante.setToolTipText("Ver donante seleccionada");
        jbAbrirInfoDonante.setBorder(null);
        jbAbrirInfoDonante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAbrirInfoDonante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbrirInfoDonanteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        jPanel12.add(jbAbrirInfoDonante, gridBagConstraints);

        jbEliminarDonante.setBackground(new java.awt.Color(255, 255, 255));
        jbEliminarDonante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        jbEliminarDonante.setToolTipText("Eliminar donante");
        jbEliminarDonante.setBorder(null);
        jbEliminarDonante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEliminarDonante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarDonanteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        jPanel12.add(jbEliminarDonante, gridBagConstraints);

        jbNuevaDonante.setBackground(new java.awt.Color(255, 255, 255));
        jbNuevaDonante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        jbNuevaDonante.setToolTipText("Nueva donante");
        jbNuevaDonante.setBorder(null);
        jbNuevaDonante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbNuevaDonante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevaDonanteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        jPanel12.add(jbNuevaDonante, gridBagConstraints);

        jbExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/page_excel.png"))); // NOI18N
        jbExcel.setToolTipText("Imprimir en Excel los datos de las donantes registradas");
        jbExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        jPanel12.add(jbExcel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 3;
        jPanel1.add(jPanel12, gridBagConstraints);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout17 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout17.setGridheight(4);
        koalaLayout17.setGridwidth(60);
        jPanel11.setLayout(koalaLayout17);

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        jbCancelar.setToolTipText("Cancelar información del donante");
        jbCancelar.setEnabled(false);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 57;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        jPanel11.add(jbCancelar, gridBagConstraints);

        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/disk.png"))); // NOI18N
        jbGuardar.setToolTipText("Guarda información del donante");
        jbGuardar.setEnabled(false);
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 51;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        jPanel11.add(jbGuardar, gridBagConstraints);

        jbModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modify.png"))); // NOI18N
        jbModificar.setToolTipText("Modifica la información del donante");
        jbModificar.setEnabled(false);
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 54;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        jPanel11.add(jbModificar, gridBagConstraints);

        jbPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Print.png"))); // NOI18N
        jbPrint.setToolTipText("Muestra los datos de todas las donante para imprimir");
        jbPrint.setEnabled(false);
        jbPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPrintActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 48;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        jPanel11.add(jbPrint, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        jPanel1.add(jPanel11, gridBagConstraints);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(205, 38, 211));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menjorpostura (Custom).jpg"))); // NOI18N
        jLabel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 5, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 9;
        jPanel1.add(jLabel13, gridBagConstraints);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout2 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout2.setGridheight(30);
        koalaLayout2.setGridwidth(30);
        jPanel13.setLayout(koalaLayout2);

        jLabel24.setText("Nombres:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        jPanel13.add(jLabel24, gridBagConstraints);

        jLabel3.setText("Tel:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        jPanel13.add(jLabel3, gridBagConstraints);

        jtfTelefono.setEnabled(false);
        jtfTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfTelefonoFocusLost(evt);
            }
        });
        jtfTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefonoKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 2;
        jPanel13.add(jtfTelefono, gridBagConstraints);

        jcbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NIT", "DUI", "Carnet Minoridad", "Otro" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.gridheight = 2;
        jPanel13.add(jcbTipoDocumento, gridBagConstraints);

        jtfNombre.setEnabled(false);
        jtfNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNombreFocusLost(evt);
            }
        });
        jtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.gridheight = 2;
        jPanel13.add(jtfNombre, gridBagConstraints);

        jtfApellido.setEnabled(false);
        jtfApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfApellidoFocusLost(evt);
            }
        });
        jtfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfApellidoKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.gridheight = 2;
        jPanel13.add(jtfApellido, gridBagConstraints);

        jepDireccion.setEnabled(false);
        jScrollPane2.setViewportView(jepDireccion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 28;
        gridBagConstraints.gridheight = 7;
        jPanel13.add(jScrollPane2, gridBagConstraints);

        jLabel25.setText("Apellidos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        jPanel13.add(jLabel25, gridBagConstraints);

        jtfDocumento.setEnabled(false);
        jtfDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfDocumentoFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.gridheight = 2;
        jPanel13.add(jtfDocumento, gridBagConstraints);

        jLabel26.setText("Documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        jPanel13.add(jLabel26, gridBagConstraints);

        jLabel27.setText("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        jPanel13.add(jLabel27, gridBagConstraints);

        jLabel4.setText("Direccion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        jPanel13.add(jLabel4, gridBagConstraints);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos/fondito1.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 30;
        gridBagConstraints.gridheight = 30;
        jPanel13.add(jLabel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 18;
        jPanel1.add(jPanel13, gridBagConstraints);

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1061)/2, (screenSize.height-618)/2, 1061, 618);
    }// </editor-fold>//GEN-END:initComponents

private void jbAbrirDonacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbrirDonacionActionPerformed
    String d = jtfDocumento.getText();
    String tip = "";
    new NuevaDonacionModf().setVisible(true);
    NuevaDonacionModf.jlDocumento.setText(d);
    NuevaDonacionModf.jcFechaDonacion.setDate(enviarFecha(jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 0).toString()));
    String fec = jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 0).toString();
    if ("Local".equals(jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 1))) {
        NuevaDonacionModf.jrbLocal.setSelected(true);
        tip = "Local";
    }
    if ("Domiciliar".equals(jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 1))) {
        NuevaDonacionModf.jrbDomiciliar.setSelected(true);
        tip = "Domiciliar";
    }
    Integer esta = new Integer(jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 4).toString());
    NuevaDonacionModf.jsEstatura.setValue(esta);

    Integer pes = new Integer(jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 5).toString());
    NuevaDonacionModf.jsPeso.setValue(pes);
    String racA = jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 2).toString();
    NuevaDonacionModf.jtfRacionAceptada.setText(racA);

    String racD = jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 3).toString();
    NuevaDonacionModf.jtfRacionDescartada.setText(racD);
    Donacion don = new Donacion(fec, tip, racA, racD, d, jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 4).toString(), jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 5).toString());
    NuevaDonacionModf.ori = don;

}//GEN-LAST:event_jbAbrirDonacionActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new InstanceOf().actividad.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

private void jbEliminarDonanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarDonanteActionPerformed
    try {
        if (jtDonantes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una donante para eliminar su información");
        } else {
            int msj = JOptionPane.showConfirmDialog(rootPane, "¿En verdad desea eliminar la información de la donante?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (msj == 0) {
                if (opU.isAdmin()) {

                    String dc = jtDonantes.getValueAt(jtDonantes.getSelectedRow(), 0).toString();
                    opD.eliminarDonante(dc);
                    usu = opU.usuarioUp();
                    opU.setEstado(usu, "El. donante " + dc);
                    DefaultTableModel model = (DefaultTableModel) jtDonantes.getModel();
                    model.removeRow(jtDonantes.getSelectedRow());
                    limpiarHabilitarValores(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Lo siento, usted no esta autorizado para realizar esta acción\nsolo un administrador puede hacerlo", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
    }
}//GEN-LAST:event_jbEliminarDonanteActionPerformed

private void jbNuevaDonanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevaDonanteActionPerformed
    VDRL.clearSelection();
    HIV.clearSelection();
    HbsAg.clearSelection();
    trans.clearSelection();
    tab.clearSelection();
    etilismo.clearSelection();
    aptaD.clearSelection();
    limpiarHabilitarValores(true);
    jbModificar.setEnabled(false);
    jtfDocumento.setEditable(true);
}//GEN-LAST:event_jbNuevaDonanteActionPerformed

private void jbNuevaDonacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevaDonacionActionPerformed
    new InstanceOfDonacion().newDonacion.setVisible(true);
    String d = jtfDocumento.getText();
    NuevaDonacion.jlDocumento.setText(d);
    NuevaDonacion.jsPeso.setValue(this.jsPeso.getValue());
    NuevaDonacion.jsEstatura.setValue(this.jsEstatura.getValue());
//    this.setVisible(false);
}//GEN-LAST:event_jbNuevaDonacionActionPerformed

    public void nuevaTabla() {
        jtDonaciones.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "Fecha", "Racion Donada", "Tipo", "Estatura(cm)", "Peso(cm)"
                }));
    }

    public void limpiarHabilitarValores(Boolean enabled) {
        nombre = "";
        apellido = "";
        documento = "";
        telefono = "";
        direccion = "";
        jtfNombre.setText("");
        jtfApellido.setText("");
        jtfDocumento.setText("");
        jtfDocumento.setText("");
        jtfTelefono.setText("");
        jepDireccion.setText("");
        jsEstatura.setValue(160);
        jsPeso.setValue(50);
        jsSGest.setValue(36);

        jbGuardar.setEnabled(enabled);
        jbCancelar.setEnabled(enabled);
        jbModificar.setEnabled(enabled);
        jbExcel.setEnabled(enabled);
        nuevaTabla();

        jtfNombre.setEnabled(enabled);
        jtfApellido.setEnabled(enabled);
        jtfDocumento.setEnabled(enabled);
        //jtfDocumento.setEnabled(enabled);
        jcFechaParto.setEnabled(enabled);
        jcFechaNac.setEnabled(enabled);
        jcFechaObtDatos.setEnabled(enabled);

        jtfTelefono.setEnabled(enabled);
        jepDireccion.setEnabled(enabled);
        jsSGest.setEnabled(enabled);
        jsPeso.setEnabled(enabled);
        jsEstatura.setEnabled(enabled);
        //        
        jcFechaNac.setDate(enviarFecha("1991-01-01"));
        jcFechaParto.setDate(enviarFecha("2012-06-01"));
        Date f = new Date();
        jcFechaObtDatos.setDate(f);


    }

    public Date enviarFecha(String fechaSQL) {
        Date fecha = new Date();

        try {
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");

            fecha = formatoDelTexto.parse(fechaSQL);
            return fecha;
//            jcFechaNac.setDate(fecha);
        } catch (Exception ex) {
        }
        return fecha;
    }

    public void enviarDatos() {
        Donante donante = new Donante();
        donante = opD.listarInfoDonante(jtDonantes.getValueAt(jtDonantes.getSelectedRow(), 0).toString());
        jtfDocumento.setText(donante.getDocumento());
        jtfNombre.setText(donante.getNombre());
        jtfApellido.setText(donante.getApellido());
//        Date fechN = enviarFecha(donante.getFechaNac());
        jcFechaNac.setDate(donante.getFechaNac());
//        Date fechP = enviarFecha(donante.getFechaParto());
        jcFechaParto.setDate(donante.getFechaParto());
//        Date fechOb = enviarFecha(donante.getFechaObtencion());
        jcFechaObtDatos.setDate(donante.getFechaObtencion());
        String est = donante.getEstatura();
        String pes = donante.getPeso();
        String smg = donante.getSemGest();

        jsSGest.setValue(Integer.parseInt(smg));
        jsPeso.setValue(Integer.parseInt(pes));
        jsEstatura.setValue(Integer.parseInt(est));
        jtfTelefono.setText(donante.getTel());
        jepDireccion.setText(donante.getDireccion());

        if ("Positivo".equals(donante.getVDRL())) {
            jrbVdrlPos.setSelected(true);
        }
        if ("Negativo".equals(donante.getVDRL())) {
            jrbVdrlNeg.setSelected(true);
        }
        if ("No disponible".equals(donante.getVDRL())) {
            jrbVdrlNoD.setSelected(true);
        }
        if ("Positivo".equals(donante.getHbsAg())) {
            jrbHbsagPos.setSelected(true);
        }
        if ("Negativo".equals(donante.getHbsAg())) {
            jrbHbsagNeg.setSelected(true);
        }
        if ("No disponible".equals(donante.getHbsAg())) {
            jrbHbsagNoD.setSelected(true);
        }
        if ("Positivo".equals(donante.getHIV())) {
            jrbHivPos.setSelected(true);
        }
        if ("Negativo".equals(donante.getHIV())) {
            jrbHivNeg.setSelected(true);
        }
        if ("No disponible".equals(donante.getHIV())) {
            jrbHivNoD.setSelected(true);
        }
        if ("Si".equals(donante.getTransSangui())) {
            jrbTransSangSI.setSelected(true);
        }
        if ("No".equals(donante.getTransSangui())) {
            jrbTransSangNO.setSelected(true);
        }
        if ("Si".equals(donante.getTabaquismo())) {
            jrbTabaqSI.setSelected(true);
        }
        if ("No".equals(donante.getTabaquismo())) {
            jrbTabaqNO.setSelected(true);
        }
        if ("Si".equals(donante.getEtilismo())) {
            jrbEtilSI.setSelected(true);
        }
        if ("No".equals(donante.getEtilismo())) {
            jrbEtilNO.setSelected(true);
        }
        if ("Si".equals(donante.getAptaDonar())) {
            jrbAptaSI.setSelected(true);
        }
        if ("No".equals(donante.getAptaDonar())) {
            jrbAptaNO.setSelected(true);
        }
        opD.listarDonanciones(jtDonaciones, donante.getDocumento());

    }

private void jbAbrirInfoDonanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbrirInfoDonanteActionPerformed
    if (jtDonantes.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar primero una donante", "Error.", JOptionPane.ERROR_MESSAGE);
    } else {
        limpiarHabilitarValores(true);
        jbGuardar.setEnabled(false);
        jbCancelar.setEnabled(false);
        enviarDatos();
        jbNuevaDonacion.setEnabled(true);
        jbAbrirDonacion.setEnabled(true);
        jbEliminarDonacion.setEnabled(true);
        jtfDocumento.setEditable(false);
        jbPrint.setEnabled(true);
    }
}//GEN-LAST:event_jbAbrirInfoDonanteActionPerformed

    public void asigancion() {
        nombre = jtfNombre.getText();
        apellido = jtfApellido.getText();
        documento = jtfDocumento.getText() + " (" + jcbTipoDocumento.getSelectedItem() + ")";
        telefono = jtfTelefono.getText();
        direccion = jepDireccion.getText();

        peso = jsPeso.getValue().toString();
        estatura = jsEstatura.getValue().toString();
        semGest = jsSGest.getValue().toString();

    }

    public void asigancion2() {
        nombre = jtfNombre.getText();
        apellido = jtfApellido.getText();
        documento = jtfDocumento.getText();
        telefono = jtfTelefono.getText();
        direccion = jepDireccion.getText();

        peso = jsPeso.getValue().toString();
        estatura = jsEstatura.getValue().toString();
        semGest = jsSGest.getValue().toString();

    }
private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jbCancelarActionPerformed

private void jtfTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfTelefonoFocusLost
    telefono = jtfTelefono.getText();
}//GEN-LAST:event_jtfTelefonoFocusLost

private void jsSGestStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsSGestStateChanged
    estatura = jsSGest.getValue().toString();
}//GEN-LAST:event_jsSGestStateChanged

private void jcFechaPartoDateChanged(org.freixas.jcalendar.DateEvent evt) {//GEN-FIRST:event_jcFechaPartoDateChanged
    fechaParto = jcFechaParto.getDate();
}//GEN-LAST:event_jcFechaPartoDateChanged

private void jsSGestMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jsSGestMouseWheelMoved
    jsSGest.setValue(new Integer(((Integer) jsSGest.getValue()).intValue() - evt.getWheelRotation()));
}//GEN-LAST:event_jsSGestMouseWheelMoved

private void jbEliminarDonacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarDonacionActionPerformed
    try {
        if (jtDonaciones.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar la donacion a eliminar");
        } else {
            int msj = JOptionPane.showConfirmDialog(rootPane, "¿En verdad desea eliminar la donacion?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (msj == 0) {
                if (opU.isAdmin()) {
                    String dc = jtfDocumento.getText();
                    opD.eliminarDonacion(dc, jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 0).toString());


                    usu = opU.usuarioUp();

                    String par = "Elm don fecha: " + jtDonaciones.getValueAt(jtDonaciones.getSelectedRow(), 0) + "dontCarnet: " + dc;
                    opU.setEstado(usu, par);
                    DefaultTableModel model = (DefaultTableModel) jtDonaciones.getModel();
                    model.removeRow(jtDonaciones.getSelectedRow());


                } else {
                    JOptionPane.showMessageDialog(null, "Lo siento, usted no esta autorizado para realizar esta acción\nsolo un administrador puede hacerlo", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Error Act: " + e.getMessage());
    }
}//GEN-LAST:event_jbEliminarDonacionActionPerformed

private void jbBuscarDonanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarDonanteActionPerformed
    if (jcbSeleccionarBusquedaDonante.getSelectedIndex() == 0) {
        opD.listarDonantes(jtDonantes);
        jtfABuscar.setText("");
    } else {
        opD.buscarDonante(jtDonantes, jcbSeleccionarBusquedaDonante.getSelectedItem().toString(), jtfABuscar.getText());
        jtfABuscar.setText("");
    }
}//GEN-LAST:event_jbBuscarDonanteActionPerformed

private void jtfTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefonoKeyTyped
    char caracter = evt.getKeyChar();
    if (!Character.isDigit(caracter)) {
        evt.consume();
    }
    if (jtfTelefono.getText().length() > 7) {
        evt.consume();
    }
}//GEN-LAST:event_jtfTelefonoKeyTyped

private void jtfABuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfABuscarKeyTyped
    int var = jcbSeleccionarBusquedaDonante.getSelectedIndex();
    char caracter = evt.getKeyChar();

    switch (var) {
        case 0:

            break;
        case 1:
            if ((Character.isDigit(caracter)) && (caracter != evt.VK_BACK_SPACE)) {
                evt.consume();
            }
            break;
        case 2:
            if ((Character.isDigit(caracter)) && (caracter != evt.VK_BACK_SPACE)) {
                evt.consume();
            }
            break;
    }
}//GEN-LAST:event_jtfABuscarKeyTyped

private void jbExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcelActionPerformed
    try {
        opX.crearExcel(opX.obtenerRutaExcel());
    } catch (IOException ex) {
        System.out.println("Error:" + ex);
        Logger.getLogger(RecoleccionLeche.class.getName()).log(Level.SEVERE, null, ex);
    } catch (WriteException ex) {
        System.out.println("Error:" + ex);
        Logger.getLogger(RecoleccionLeche.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_jbExcelActionPerformed

private void jtfNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNombreFocusLost
    // TODO add your handling code here:
}//GEN-LAST:event_jtfNombreFocusLost

private void jtfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyTyped
    // TODO add your handling code here:
}//GEN-LAST:event_jtfNombreKeyTyped

private void jtfApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfApellidoFocusLost
    // TODO add your handling code here:
}//GEN-LAST:event_jtfApellidoFocusLost

private void jtfApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoKeyTyped
    // TODO add your handling code here:
}//GEN-LAST:event_jtfApellidoKeyTyped

private void jtfDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfDocumentoFocusLost
    // TODO add your handling code here:
}//GEN-LAST:event_jtfDocumentoFocusLost

private void jcFechaNacDateChanged(org.freixas.jcalendar.DateEvent evt) {//GEN-FIRST:event_jcFechaNacDateChanged

    fechaNac = jcFechaNac.getDate();
}//GEN-LAST:event_jcFechaNacDateChanged

private void jcFechaObtDatosDateChanged(org.freixas.jcalendar.DateEvent evt) {//GEN-FIRST:event_jcFechaObtDatosDateChanged
    fechaObtDatos = jcFechaObtDatos.getDate();
}//GEN-LAST:event_jcFechaObtDatosDateChanged

private void jsEstaturaMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jsEstaturaMouseWheelMoved
    // TODO add your handling code here:
}//GEN-LAST:event_jsEstaturaMouseWheelMoved

private void jsEstaturaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsEstaturaStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jsEstaturaStateChanged

private void jsPesoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jsPesoMouseWheelMoved
    // TODO add your handling code here:
}//GEN-LAST:event_jsPesoMouseWheelMoved

private void jsPesoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsPesoStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_jsPesoStateChanged

private void jrbVdrlPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbVdrlPosActionPerformed
    vdrl = "Positivo";
}//GEN-LAST:event_jrbVdrlPosActionPerformed

private void jrbVdrlNegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbVdrlNegActionPerformed
    vdrl = "Negativo";
// TODO add your handling code here:
}//GEN-LAST:event_jrbVdrlNegActionPerformed

private void jrbVdrlNoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbVdrlNoDActionPerformed
    vdrl = "No disponible";
}//GEN-LAST:event_jrbVdrlNoDActionPerformed

private void jrbHbsagPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbHbsagPosActionPerformed
    hbsag = "Positivo";
}//GEN-LAST:event_jrbHbsagPosActionPerformed

private void jrbHbsagNegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbHbsagNegActionPerformed
    hbsag = "Negativo";
}//GEN-LAST:event_jrbHbsagNegActionPerformed

private void jrbHbsagNoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbHbsagNoDActionPerformed
    hbsag = "No disponible";
}//GEN-LAST:event_jrbHbsagNoDActionPerformed

private void jrbHivPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbHivPosActionPerformed
    hiv = "Positivo";
}//GEN-LAST:event_jrbHivPosActionPerformed

private void jrbHivNegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbHivNegActionPerformed
    hiv = "Negativo";
}//GEN-LAST:event_jrbHivNegActionPerformed

private void jrbHivNoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbHivNoDActionPerformed
    hiv = "No disponible";
}//GEN-LAST:event_jrbHivNoDActionPerformed

private void jrbTransSangSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTransSangSIActionPerformed
    transSang = "Si";
}//GEN-LAST:event_jrbTransSangSIActionPerformed

private void jrbTransSangNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTransSangNOActionPerformed
    transSang = "No";
}//GEN-LAST:event_jrbTransSangNOActionPerformed

private void jrbTabaqSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTabaqSIActionPerformed
    tabaq = "Si";
}//GEN-LAST:event_jrbTabaqSIActionPerformed

private void jrbTabaqNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTabaqNOActionPerformed
    tabaq = "No";
}//GEN-LAST:event_jrbTabaqNOActionPerformed

private void jrbEtilSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEtilSIActionPerformed
    etilis = "Si";
}//GEN-LAST:event_jrbEtilSIActionPerformed

private void jrbEtilNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEtilNOActionPerformed
    etilis = "No";
}//GEN-LAST:event_jrbEtilNOActionPerformed

private void jrbAptaSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAptaSIActionPerformed
    aptaDon = "Si";
}//GEN-LAST:event_jrbAptaSIActionPerformed

private void jrbAptaNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAptaNOActionPerformed
    aptaDon = "No";
}//GEN-LAST:event_jrbAptaNOActionPerformed

private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
    // TODO add your handling code here:
    if (jtfNombre.getText().equals("") || jtfApellido.getText().equals("") || jtfDocumento.getText().equals("") || jtfDocumento.getText().equals("") || jtfTelefono.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "¡Por favor, complete los datos de la donante!");
    } else {
        asigancion();
        Donante dte = new Donante(documento, nombre, apellido, fechaNac, direccion, peso, estatura, telefono, semGest, fechaParto, vdrl, hbsag, hiv, transSang, tabaq, etilis, aptaDon, fechaObtDatos);
        opD.almacenarInfoDonante(dte);
    }
    opD.listarDonantes(jtDonantes);
    limpiarHabilitarValores(false);
    jbPrint.setEnabled(false);
}//GEN-LAST:event_jbGuardarActionPerformed

private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
    // TODO add your handling code here:
    try {
        if (jtDonantes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar primero una donante", "Error.", JOptionPane.ERROR_MESSAGE);
        } else {
            asigancion2();
            Donante dte = new Donante(documento, nombre, apellido, fechaNac, direccion, peso, estatura, telefono, semGest, fechaParto, vdrl, hbsag, hiv, transSang, tabaq, etilis, aptaDon, fechaObtDatos);
            opD.modificarInfoDonante(dte);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Error al modificar!");
    }
}//GEN-LAST:event_jbModificarActionPerformed

private void jbPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPrintActionPerformed
// TODO add your handling code here:
        String archivo = System.getProperty("user.dir");
        archivo = archivo + "\\src\\reportes\\banner.png";
        String doc = jtfDocumento.getText();
        opr.runReporteDonantes("Donantes", archivo, doc);
}//GEN-LAST:event_jbPrintActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;


                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecoleccionLeche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecoleccionLeche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecoleccionLeche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecoleccionLeche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RecoleccionLeche().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup HIV;
    private javax.swing.ButtonGroup HbsAg;
    private javax.swing.ButtonGroup VDRL;
    private javax.swing.ButtonGroup aptaD;
    private javax.swing.ButtonGroup bgTipoDonacion;
    private javax.swing.ButtonGroup etilismo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton jbAbrirDonacion;
    private javax.swing.JButton jbAbrirInfoDonante;
    private javax.swing.JButton jbBuscarDonante;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminarDonacion;
    private javax.swing.JButton jbEliminarDonante;
    private javax.swing.JButton jbExcel;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevaDonacion;
    private javax.swing.JButton jbNuevaDonante;
    private javax.swing.JButton jbPrint;
    private org.freixas.jcalendar.JCalendarCombo jcFechaNac;
    private org.freixas.jcalendar.JCalendarCombo jcFechaObtDatos;
    private org.freixas.jcalendar.JCalendarCombo jcFechaParto;
    private javax.swing.JComboBox jcbSeleccionarBusquedaDonante;
    private javax.swing.JComboBox jcbTipoDocumento;
    private javax.swing.JEditorPane jepDireccion;
    private javax.swing.JRadioButton jrbAptaNO;
    private javax.swing.JRadioButton jrbAptaSI;
    private javax.swing.JRadioButton jrbEtilNO;
    private javax.swing.JRadioButton jrbEtilSI;
    private javax.swing.JRadioButton jrbHbsagNeg;
    private javax.swing.JRadioButton jrbHbsagNoD;
    private javax.swing.JRadioButton jrbHbsagPos;
    private javax.swing.JRadioButton jrbHivNeg;
    private javax.swing.JRadioButton jrbHivNoD;
    private javax.swing.JRadioButton jrbHivPos;
    private javax.swing.JRadioButton jrbTabaqNO;
    private javax.swing.JRadioButton jrbTabaqSI;
    private javax.swing.JRadioButton jrbTransSangNO;
    private javax.swing.JRadioButton jrbTransSangSI;
    private javax.swing.JRadioButton jrbVdrlNeg;
    private javax.swing.JRadioButton jrbVdrlNoD;
    private javax.swing.JRadioButton jrbVdrlPos;
    private javax.swing.JSpinner jsEstatura;
    private javax.swing.JSpinner jsPeso;
    private javax.swing.JSpinner jsSGest;
    public static javax.swing.JTable jtDonaciones;
    private javax.swing.JTable jtDonantes;
    private javax.swing.JTextField jtfABuscar;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfDocumento;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfTelefono;
    private javax.swing.JLabel label;
    private javax.swing.ButtonGroup tab;
    private javax.swing.ButtonGroup trans;
    // End of variables declaration//GEN-END:variables
}
