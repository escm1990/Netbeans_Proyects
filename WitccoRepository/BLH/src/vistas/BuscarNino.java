package vistas;

import Instancia.InstanceOf;
import Instancia.InstanceOfConsult;
import accesoDatos.OperacionesConsulta;
import accesoDatos.OperacionesDonantNinos;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscarNino extends javax.swing.JFrame {

    OperacionesConsulta op = new OperacionesConsulta();
    OperacionesDonantNinos opDN = new OperacionesDonantNinos();
    String nombre = "";
    String apellido = "";
    String sexo = "";
    String carnet = "";
    String fecha = "";
    Date fechade = null;
    Date fechaHasta = null;        
    DefaultTableModel model = new DefaultTableModel();

    public BuscarNino() {
        initComponents();
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

        elegirSexo = new javax.swing.ButtonGroup();
        elegirNCarnet = new javax.swing.ButtonGroup();
        elegirFechaNac = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jtfApellidos = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jrbSexoTodos = new javax.swing.JRadioButton();
        jrbSexoFemenino = new javax.swing.JRadioButton();
        jrbSexoMasculino = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jrbTodosCarnet = new javax.swing.JRadioButton();
        jrbIgualA = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jtfNCarnetBuscar = new javax.swing.JTextField();
        jbAceptar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jrbTodosFNac = new javax.swing.JRadioButton();
        jrbSeleccionar = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jccHasta = new org.freixas.jcalendar.JCalendarCombo();
        jccDe = new org.freixas.jcalendar.JCalendarCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Niño - Banco de Leche Humana");
        setIconImage(getIconImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        net.java.dev.koalalayout.KoalaLayout koalaLayout1 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout1.setGridwidth(20);
        koalaLayout1.setGridheight(20);
        jPanel1.setLayout(koalaLayout1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout2 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout2.setGridheight(10);
        koalaLayout2.setGridwidth(18);
        jPanel2.setLayout(koalaLayout2);

        jLabel3.setText("Apellido:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        jPanel2.add(jLabel3, gridBagConstraints);

        jLabel7.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        jPanel2.add(jLabel7, gridBagConstraints);

        jtfNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNombreFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        jPanel2.add(jtfNombre, gridBagConstraints);

        jtfApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfApellidosFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        jPanel2.add(jtfApellidos, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 7;
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout3 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout3.setGridheight(10);
        koalaLayout3.setGridwidth(30);
        jPanel3.setLayout(koalaLayout3);

        elegirSexo.add(jrbSexoTodos);
        jrbSexoTodos.setText("Todos");
        jrbSexoTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSexoTodosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        jPanel3.add(jrbSexoTodos, gridBagConstraints);

        elegirSexo.add(jrbSexoFemenino);
        jrbSexoFemenino.setText("Femenino");
        jrbSexoFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSexoFemeninoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 4;
        jPanel3.add(jrbSexoFemenino, gridBagConstraints);

        elegirSexo.add(jrbSexoMasculino);
        jrbSexoMasculino.setText("Masculino");
        jrbSexoMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSexoMasculinoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 4;
        jPanel3.add(jrbSexoMasculino, gridBagConstraints);

        jLabel5.setText("Sexo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        jPanel3.add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 5;
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout4 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout4.setGridheight(22);
        koalaLayout4.setGridwidth(30);
        jPanel4.setLayout(koalaLayout4);

        elegirNCarnet.add(jrbTodosCarnet);
        jrbTodosCarnet.setText("Todos");
        jrbTodosCarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodosCarnetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 8;
        jPanel4.add(jrbTodosCarnet, gridBagConstraints);

        elegirNCarnet.add(jrbIgualA);
        jrbIgualA.setText("Igual a");
        jrbIgualA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbIgualAActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 7;
        jPanel4.add(jrbIgualA, gridBagConstraints);

        jLabel4.setText("Nº Carnet:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 6;
        jPanel4.add(jLabel4, gridBagConstraints);

        jtfNCarnetBuscar.setEnabled(false);
        jtfNCarnetBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNCarnetBuscarFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.gridheight = 9;
        jPanel4.add(jtfNCarnetBuscar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 6;
        jPanel1.add(jPanel4, gridBagConstraints);

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 31;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel1.add(jbAceptar, gridBagConstraints);

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 31;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel1.add(jbSalir, gridBagConstraints);

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 31;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel1.add(jbLimpiar, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout5 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout5.setGridheight(13);
        koalaLayout5.setGridwidth(30);
        jPanel5.setLayout(koalaLayout5);

        elegirFechaNac.add(jrbTodosFNac);
        jrbTodosFNac.setText("Todos");
        jrbTodosFNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodosFNacActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        jPanel5.add(jrbTodosFNac, gridBagConstraints);

        elegirFechaNac.add(jrbSeleccionar);
        jrbSeleccionar.setText("Seleccionar");
        jrbSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSeleccionarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 4;
        jPanel5.add(jrbSeleccionar, gridBagConstraints);

        jLabel6.setText("Fecha de nacimiento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jLabel6, gridBagConstraints);

        jLabel2.setText("Hasta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jLabel2, gridBagConstraints);

        jLabel8.setText("De:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jLabel8, gridBagConstraints);

        jccHasta.setEnabled(false);
        jccHasta.addDateListener(new org.freixas.jcalendar.DateListener() {
            public void dateChanged(org.freixas.jcalendar.DateEvent evt) {
                jccHastaDateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 5;
        jPanel5.add(jccHasta, gridBagConstraints);

        jccDe.setEnabled(false);
        jccDe.addDateListener(new org.freixas.jcalendar.DateListener() {
            public void dateChanged(org.freixas.jcalendar.DateEvent evt) {
                jccDeDateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 5;
        jPanel5.add(jccDe, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 9;
        jPanel1.add(jPanel5, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-515)/2, (screenSize.height-530)/2, 515, 530);
    }// </editor-fold>//GEN-END:initComponents

private void jrbIgualAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbIgualAActionPerformed
    // TODO add your handling code here:
    jtfNCarnetBuscar.setEnabled(true);
    elegirFechaNac.clearSelection();
    elegirSexo.clearSelection();
}//GEN-LAST:event_jrbIgualAActionPerformed

private void jrbSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSeleccionarActionPerformed
    // TODO add your handling code here:
    jccDe.setEnabled(true);
    jccHasta.setEnabled(true);
    elegirNCarnet.clearSelection();
    elegirSexo.clearSelection();
    jtfNCarnetBuscar.setEnabled(false);
    this.fecha = "Seleccionado";
}//GEN-LAST:event_jrbSeleccionarActionPerformed

private void jrbTodosCarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodosCarnetActionPerformed
    // TODO add your handling code here:
    jtfNCarnetBuscar.setEnabled(false);
    jtfNCarnetBuscar.setText("");
    this.carnet = "Todos";
    elegirFechaNac.clearSelection();
    elegirSexo.clearSelection();
}//GEN-LAST:event_jrbTodosCarnetActionPerformed

private void jrbTodosFNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodosFNacActionPerformed
    // TODO add your handling code here:
    jccDe.setEnabled(false);
    jccHasta.setEnabled(false);
    elegirNCarnet.clearSelection();
    elegirSexo.clearSelection();
    jtfNCarnetBuscar.setEnabled(false);
    this.fecha = "Todos";
}//GEN-LAST:event_jrbTodosFNacActionPerformed

private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
    // TODO add your handling code here:
    new ControlPaciente().setVisible(true);
    this.setVisible(false);
}//GEN-LAST:event_jbSalirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new ControlPaciente().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void jtfNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNombreFocusLost
        // TODO add your handling code here:
        this.nombre = jtfNombre.getText();
    }//GEN-LAST:event_jtfNombreFocusLost

    private void jtfApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfApellidosFocusLost
        // TODO add your handling code here:
        this.apellido = jtfApellidos.getText();
    }//GEN-LAST:event_jtfApellidosFocusLost

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        // TODO add your handling code here:       
        if (!jtfNombre.getText().equals("") && !jtfApellidos.getText().equals("")) {
            model = op.buscarNombres(nombre, apellido);
            new ControlPaciente().setVisible(true);
            ControlPaciente.jtPacientes.setModel(model);
            this.setVisible(false);
        } else if (jtfApellidos.getText().equals("") && !jtfNombre.getText().equals("")) {
            model = op.buscarNombre("Nombres", nombre);
            new ControlPaciente().setVisible(true);
            ControlPaciente.jtPacientes.setModel(model);
            this.setVisible(false);
        } else if (jtfNombre.getText().equals("") && !jtfApellidos.getText().equals("")) {
            model = op.buscarNombre("Apellidos", apellido);
            new ControlPaciente().setVisible(true);
            ControlPaciente.jtPacientes.setModel(model);
            this.setVisible(false);
        } else if (jtfNombre.getText().equals("") && jtfApellidos.getText().equals("")) {
            if (sexo.equals("Todos")) {
                new ControlPaciente().setVisible(true);
                opDN.listarNinos(ControlPaciente.jtPacientes);
                this.setVisible(false);
            } else if (sexo.equals("Femenino")) {
                model = op.buscarNombre("Sexo", sexo);
                new ControlPaciente().setVisible(true);
                ControlPaciente.jtPacientes.setModel(model);
                this.setVisible(false);
            } else if (sexo.equals("Masculino")) {
                model = op.buscarNombre("Sexo", sexo);
                new ControlPaciente().setVisible(true);
                ControlPaciente.jtPacientes.setModel(model);
                this.setVisible(false);
            }else if(carnet.equals("Todos")){
                new ControlPaciente().setVisible(true);
                opDN.listarNinos(ControlPaciente.jtPacientes);
                this.setVisible(false);
            }else if(!carnet.equals("")){
                model = op.buscarNombre("Carnet", carnet);
                new ControlPaciente().setVisible(true);
                ControlPaciente.jtPacientes.setModel(model);
                this.setVisible(false);
            }else if(fecha.equals("Todos")){
                new ControlPaciente().setVisible(true);
                opDN.listarNinos(ControlPaciente.jtPacientes);
                this.setVisible(false);
            }else if(fecha.equals("Seleccionado")){
                model = op.buscarFecha(fechade,fechaHasta);
                new ControlPaciente().setVisible(true);
                ControlPaciente.jtPacientes.setModel(model);
                this.setVisible(false);
            }

        }


    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jrbSexoTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSexoTodosActionPerformed
        // TODO add your handling code here:
        this.sexo = "Todos";
        elegirNCarnet.clearSelection();
        elegirFechaNac.clearSelection();
        jtfNCarnetBuscar.setEnabled(false);

    }//GEN-LAST:event_jrbSexoTodosActionPerformed

    private void jrbSexoFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSexoFemeninoActionPerformed
        // TODO add your handling code here:
        this.sexo = "Femenino";
        elegirNCarnet.clearSelection();
        elegirFechaNac.clearSelection();
        jtfNCarnetBuscar.setEnabled(false);
    }//GEN-LAST:event_jrbSexoFemeninoActionPerformed

    private void jrbSexoMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSexoMasculinoActionPerformed
        // TODO add your handling code here:
        this.sexo = "Masculino";
        elegirNCarnet.clearSelection();
        elegirFechaNac.clearSelection();
        jtfNCarnetBuscar.setEnabled(false);
    }//GEN-LAST:event_jrbSexoMasculinoActionPerformed

    private void jtfNCarnetBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNCarnetBuscarFocusLost
        // TODO add your handling code here:
        this.carnet = jtfNCarnetBuscar.getText();
    }//GEN-LAST:event_jtfNCarnetBuscarFocusLost

    private void jccDeDateChanged(org.freixas.jcalendar.DateEvent evt) {//GEN-FIRST:event_jccDeDateChanged
        // TODO add your handling code here:
        fechade = new Date(jccDe.getDate().getTime());
    }//GEN-LAST:event_jccDeDateChanged

    private void jccHastaDateChanged(org.freixas.jcalendar.DateEvent evt) {//GEN-FIRST:event_jccHastaDateChanged
        // TODO add your handling code here:
        fechaHasta = new Date(jccHasta.getDate().getTime());
    }//GEN-LAST:event_jccHastaDateChanged

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        // TODO add your handling code here:
        elegirFechaNac.clearSelection();
        elegirNCarnet.clearSelection();
        elegirSexo.clearSelection();
        jtfApellidos.setText("");
        jtfNCarnetBuscar.setText("");
        jtfNombre.setText("");
    }//GEN-LAST:event_jbLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarNino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarNino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarNino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarNino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BuscarNino().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup elegirFechaNac;
    private javax.swing.ButtonGroup elegirNCarnet;
    private javax.swing.ButtonGroup elegirSexo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbSalir;
    private org.freixas.jcalendar.JCalendarCombo jccDe;
    private org.freixas.jcalendar.JCalendarCombo jccHasta;
    private javax.swing.JRadioButton jrbIgualA;
    private javax.swing.JRadioButton jrbSeleccionar;
    private javax.swing.JRadioButton jrbSexoFemenino;
    private javax.swing.JRadioButton jrbSexoMasculino;
    private javax.swing.JRadioButton jrbSexoTodos;
    private javax.swing.JRadioButton jrbTodosCarnet;
    private javax.swing.JRadioButton jrbTodosFNac;
    private javax.swing.JTextField jtfApellidos;
    private javax.swing.JTextField jtfNCarnetBuscar;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
