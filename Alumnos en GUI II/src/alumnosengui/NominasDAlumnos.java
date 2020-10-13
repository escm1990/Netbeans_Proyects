/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NominasDAlumnos.java
 *
 * Created on May 17, 2010, 8:04:00 PM
 */
package alumnosengui;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**-------------------------------`
 * Desarrolladores:               `
 * Cruz Martinez, Erick Stanley   `
 * Moran Monzon, Luis Antonio     `
 * Rogel Grijalva, Gerson Edgardo `
--------------------------------**/
public class NominasDAlumnos extends javax.swing.JFrame {

    private Alumno nuevoAlumno;
    private NominaAlumnos alu;
    private DefaultTableModel modeloTabla;
    private int modificarNumero;

    /** Creates new form NominasDAlumnos */
//----------------------------
//    CONSTRUCTOR
//----------------------------
    public NominasDAlumnos() {
        initComponents();
        modificarNumero = -1;
        nuevoAlumno = new Alumno();
        modeloTabla = (DefaultTableModel) jtMostrarAlumnos.getModel();
        jtMostrarAlumnos.setModel(modeloTabla);
        alu = new NominaAlumnos();
        actualizarGUINuevoAlumno();
        jtMostrarAlumnos.getRowSorter().toggleSortOrder(1);
    }
//----------------------------
//    METODOS
//----------------------------
    private void actualizarGUINuevoAlumno() {
        nuevoAlumno = new Alumno();
        jftNumeroDeCarnet.setText(nuevoAlumno.getCarnet());
        jtfNombresAlumnos.setText(nuevoAlumno.getNombre());
        jtfApellidosAlumnos.setText(nuevoAlumno.getApellido());
        jftNotaDelPrimerParcial.setText(String.valueOf(nuevoAlumno.getParcial1()));
        jftNotaDelSegundoParcial.setText(String.valueOf(nuevoAlumno.getParcial2()));
        jftNotaDelTercerParcial.setText(String.valueOf(nuevoAlumno.getParcial3()));
        jftNotasDelCuartoParcial.setText(String.valueOf(nuevoAlumno.getParcial4()));
        jftNotaDelQuintoParcial.setText(String.valueOf(nuevoAlumno.getParcial5()));
        jlResultadoPromedio.setText(String.valueOf(0.00));
        jtfEstatusAprobadoReprobado.setText(null);

        if (jtBusqueda.getText().trim().isEmpty()) {
            mostrarTabla();
        } else {
            buscar();
        }
    }
//------------------------------------------------------------------------------
    private void actualizarIconoGuardar() {
        if (modificarNumero == -1) {
            jbGuardarInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar12.png")));
        } else {
            jbGuardarInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png")));
        }
    }
//------------------------------------------------------------------------------
    private void mostrarDatosModificar(int numero) {
        jftNumeroDeCarnet.setText(alu.obtener(numero).getCarnet());
        jtfNombresAlumnos.setText(alu.obtener(numero).getNombre());
        jtfApellidosAlumnos.setText(alu.obtener(numero).getApellido());
        jftNotaDelPrimerParcial.setText(String.valueOf(alu.obtener(numero).getParcial1()));
        jftNotaDelSegundoParcial.setText(String.valueOf(alu.obtener(numero).getParcial2()));
        jftNotaDelTercerParcial.setText(String.valueOf(alu.obtener(numero).getParcial3()));
        jftNotasDelCuartoParcial.setText(String.valueOf(alu.obtener(numero).getParcial4()));
        jftNotaDelQuintoParcial.setText(String.valueOf(alu.obtener(numero).getParcial5()));
        jlResultadoPromedio.setText(String.valueOf(alu.obtener(numero).CalcularPromedio()));
        jtfEstatusAprobadoReprobado.setText(alu.obtener(numero).EstatusDeAlumno());
        mostrarTabla();


    }
//------------------------------------------------------------------------------
    private boolean datosCompletosDeAlumno() {
        if (jftNumeroDeCarnet.getText().trim().length() == 7
                && jtfApellidosAlumnos.getText().trim().length() > 0
                && jtfNombresAlumnos.getText().trim().length() > 0) {
            return true;
        } else {
            return false;
        }
    }
//------------------------------------------------------------------------------
        public void mostrarTabla() {
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        for (int i = 0; i < alu.cantidadAlumnos(); i++) {
            Object fila[] = {i, alu.obtener(i).getCarnet(), alu.obtener(i).getNombre(), alu.obtener(i).getApellido(), alu.obtener(i).getParcial1(),
                alu.obtener(i).getParcial2(), alu.obtener(i).getParcial3(),
                alu.obtener(i).getParcial4(), alu.obtener(i).getParcial5(),
                String.format("%.2f", alu.obtener(i).CalcularPromedio()),
                alu.obtener(i).EstatusDeAlumno()};
            modeloTabla.addRow(fila);
        }
        jlApro.setText(String.valueOf(alu.obtenerAprobados()));
        jlRepro.setText(String.valueOf(alu.obtenerReprobados()));
    }
//------------------------------------------------------------------------------
    public void buscar() {
        int contadorAprobados = 0;
        int contadorReprobados = 0;
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        for (int i = 0; i < alu.cantidadAlumnos(); i++) {

            Object fila[] = {i, alu.obtener(i).getCarnet(), alu.obtener(i).getNombre(), alu.obtener(i).getApellido(), alu.obtener(i).getParcial1(),
                alu.obtener(i).getParcial2(), alu.obtener(i).getParcial3(),
                alu.obtener(i).getParcial4(), alu.obtener(i).getParcial5(),
                String.format("%.2f", alu.obtener(i).CalcularPromedio()),
                alu.obtener(i).EstatusDeAlumno()};
            int criterio = jcbCriterios.getSelectedIndex();
            boolean resultado = false;
            switch (criterio) {
                case 0:
                    resultado = alu.obtener(i).getCarnet().toLowerCase().contains(jtBusqueda.getText().toLowerCase());
                    break;
                case 1:
                    resultado = alu.obtener(i).getNombre().toLowerCase().startsWith(jtBusqueda.getText().toLowerCase());
                    break;
                case 2:
                    resultado = alu.obtener(i).getNombre().toLowerCase().endsWith(jtBusqueda.getText().toLowerCase());
                    break;
                case 3:
                    resultado = alu.obtener(i).getNombre().toLowerCase().contains(jtBusqueda.getText().toLowerCase());
                    break;
                case 4:
                    resultado = alu.obtener(i).getApellido().toLowerCase().contains(jtBusqueda.getText().toLowerCase());
                    break;
                case 5:
                    resultado = alu.obtener(i).EstatusDeAlumno().toLowerCase().contains(jtBusqueda.getText().toLowerCase());
                    break;
            }
            if (resultado == true) {
                modeloTabla.addRow(fila);
                if (alu.obtener(i).CalcularPromedio() >= 6) {
                    contadorAprobados++;
                } else {
                    contadorReprobados++;
                }
            }
        }
        jlApro.setText(String.valueOf(contadorAprobados));
        jlRepro.setText(String.valueOf(contadorReprobados));
    }
//------------------------------------------------------------------------------
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrinicipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlCarnet = new javax.swing.JLabel();
        jlNombres = new javax.swing.JLabel();
        jftNumeroDeCarnet = new javax.swing.JFormattedTextField();
        jtfNombresAlumnos = new javax.swing.JTextField();
        jtfApellidosAlumnos = new javax.swing.JTextField();
        jlApellidos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlRepro = new javax.swing.JLabel();
        jlApro = new javax.swing.JLabel();
        jlNotas = new javax.swing.JLabel();
        jftNotaDelPrimerParcial = new javax.swing.JFormattedTextField();
        jlPrimerParcial = new javax.swing.JLabel();
        jlSegundoParcial = new javax.swing.JLabel();
        jftNotaDelSegundoParcial = new javax.swing.JFormattedTextField();
        jftNotaDelTercerParcial = new javax.swing.JFormattedTextField();
        jlTercerParcial = new javax.swing.JLabel();
        jlCuartoParcial1 = new javax.swing.JLabel();
        jlQuintoParcial2 = new javax.swing.JLabel();
        jftNotasDelCuartoParcial = new javax.swing.JFormattedTextField();
        jftNotaDelQuintoParcial = new javax.swing.JFormattedTextField();
        jtfEstatusAprobadoReprobado = new javax.swing.JTextField();
        jbGuardarInformacion = new javax.swing.JButton();
        jbPromedioNotasAlumnos = new javax.swing.JButton();
        jlResultadoPromedio = new javax.swing.JLabel();
        jlPromedio = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMostrarAlumnos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jtBusqueda = new javax.swing.JTextField();
        jcbCriterios = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmArchivo = new javax.swing.JMenu();
        jmiExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nominet");
        setMinimumSize(new java.awt.Dimension(1170, 542));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jpPrinicipal.setBackground(new java.awt.Color(191, 230, 235));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("Datos Personales");

        jlCarnet.setText("Carnet:");

        jlNombres.setText("Nombres:");

        try {
            jftNumeroDeCarnet.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftNumeroDeCarnet.setToolTipText("Ingrese el codigo de carnet");
        jftNumeroDeCarnet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jftNumeroDeCarnetMouseClicked(evt);
            }
        });

        jtfNombresAlumnos.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jtfNombresAlumnos.setToolTipText("Ingrese los nombres del alumno");
        jtfNombresAlumnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombresAlumnosKeyTyped(evt);
            }
        });

        jtfApellidosAlumnos.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jtfApellidosAlumnos.setToolTipText("Ingrese los apellidos del alumno");
        jtfApellidosAlumnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfApellidosAlumnosKeyTyped(evt);
            }
        });

        jlApellidos.setText("Apellidos:");

        jLabel2.setText("Alumnos Aprobados");

        jLabel4.setText("Alumnos Reprobados");

        jlRepro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlRepro.setForeground(new java.awt.Color(204, 0, 0));
        jlRepro.setText("0");

        jlApro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlApro.setForeground(new java.awt.Color(0, 204, 51));
        jlApro.setText("0");

        jlNotas.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jlNotas.setText("Notas:");

        jftNotaDelPrimerParcial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jftNotaDelPrimerParcial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jftNotaDelPrimerParcialMouseClicked(evt);
            }
        });
        jftNotaDelPrimerParcial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftNotaDelPrimerParcialFocusLost(evt);
            }
        });
        jftNotaDelPrimerParcial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jftNotaDelPrimerParcialKeyTyped(evt);
            }
        });

        jlPrimerParcial.setText("Parcial # 1:");

        jlSegundoParcial.setText("Parcial # 2:");

        jftNotaDelSegundoParcial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jftNotaDelSegundoParcial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jftNotaDelSegundoParcialMouseClicked(evt);
            }
        });
        jftNotaDelSegundoParcial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftNotaDelSegundoParcialFocusLost(evt);
            }
        });
        jftNotaDelSegundoParcial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jftNotaDelSegundoParcialKeyTyped(evt);
            }
        });

        jftNotaDelTercerParcial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jftNotaDelTercerParcial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jftNotaDelTercerParcialMouseClicked(evt);
            }
        });
        jftNotaDelTercerParcial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftNotaDelTercerParcialFocusLost(evt);
            }
        });
        jftNotaDelTercerParcial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jftNotaDelTercerParcialKeyTyped(evt);
            }
        });

        jlTercerParcial.setText("Parcial # 3:");

        jlCuartoParcial1.setText("Parcial # 4:");

        jlQuintoParcial2.setText("Parcial # 5:");

        jftNotasDelCuartoParcial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jftNotasDelCuartoParcial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jftNotasDelCuartoParcialMouseClicked(evt);
            }
        });
        jftNotasDelCuartoParcial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftNotasDelCuartoParcialFocusLost(evt);
            }
        });
        jftNotasDelCuartoParcial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jftNotasDelCuartoParcialKeyTyped(evt);
            }
        });

        jftNotaDelQuintoParcial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jftNotaDelQuintoParcial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jftNotaDelQuintoParcialMouseClicked(evt);
            }
        });
        jftNotaDelQuintoParcial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftNotaDelQuintoParcialFocusLost(evt);
            }
        });
        jftNotaDelQuintoParcial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jftNotaDelQuintoParcialKeyTyped(evt);
            }
        });

        jtfEstatusAprobadoReprobado.setEditable(false);
        jtfEstatusAprobadoReprobado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEstatusAprobadoReprobadoActionPerformed(evt);
            }
        });

        jbGuardarInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar12.png"))); // NOI18N
        jbGuardarInformacion.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jbGuardarInformacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbGuardarInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarInformacionActionPerformed(evt);
            }
        });

        jbPromedioNotasAlumnos.setText("Promediar");
        jbPromedioNotasAlumnos.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jbPromedioNotasAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbPromedioNotasAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPromedioNotasAlumnosActionPerformed(evt);
            }
        });

        jlResultadoPromedio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlResultadoPromedio.setForeground(new java.awt.Color(0, 153, 255));
        jlResultadoPromedio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlResultadoPromedio.setText("0.00");

        jlPromedio.setText("Promedio:");

        jtMostrarAlumnos.setAutoCreateRowSorter(true);
        jtMostrarAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Carnet", "Nombre", "Apellido", "Parcial 1", "Parcial 2", "Parcial 3", "Parcial 4", "Parcial 5", "Promedio", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtMostrarAlumnos);

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaKeyReleased(evt);
            }
        });

        jcbCriterios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Carnet", "Nombre Inicie con...", "Nombre Termine con...", "Nombre Contenga...", "Apellidos", "Estatus" }));
        jcbCriterios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCriteriosActionPerformed(evt);
            }
        });

        jLabel3.setText("Estatus:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar.png"))); // NOI18N
        jLabel5.setText("Buscar:");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Datos.png"))); // NOI18N

        javax.swing.GroupLayout jpPrinicipalLayout = new javax.swing.GroupLayout(jpPrinicipal);
        jpPrinicipal.setLayout(jpPrinicipalLayout);
        jpPrinicipalLayout.setHorizontalGroup(
            jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrinicipalLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbPromedioNotasAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                        .addComponent(jlPrimerParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jftNotaDelPrimerParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                        .addComponent(jlSegundoParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jftNotaDelSegundoParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                        .addComponent(jlTercerParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jftNotaDelTercerParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                        .addComponent(jlCuartoParcial1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jftNotasDelCuartoParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                        .addComponent(jlQuintoParcial2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jftNotaDelQuintoParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                        .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrinicipalLayout.createSequentialGroup()
                                .addComponent(jlCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrinicipalLayout.createSequentialGroup()
                                .addComponent(jlNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jpPrinicipalLayout.createSequentialGroup()
                                .addComponent(jlApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNombresAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jftNumeroDeCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpPrinicipalLayout.createSequentialGroup()
                                .addComponent(jlNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addComponent(jLabel1)
                            .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfApellidosAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbGuardarInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                        .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jlResultadoPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfEstatusAprobadoReprobado, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlApro)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlRepro)
                        .addContainerGap(413, Short.MAX_VALUE))
                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                        .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                            .addGroup(jpPrinicipalLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbCriterios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45))))
        );
        jpPrinicipalLayout.setVerticalGroup(
            jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrinicipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jcbCriterios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                        .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jftNumeroDeCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNombresAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfApellidosAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrinicipalLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jlNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlPrimerParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jftNotaDelPrimerParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlSegundoParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jftNotaDelSegundoParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlTercerParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jftNotaDelTercerParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlCuartoParcial1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jftNotasDelCuartoParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlQuintoParcial2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jftNotaDelQuintoParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(48, 48, 48)
                                .addComponent(jbPromedioNotasAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlResultadoPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpPrinicipalLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbGuardarInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addGap(110, 110, 110)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfEstatusAprobadoReprobado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrinicipalLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jlRepro)
                            .addComponent(jlApro))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jpPrinicipal);
        jpPrinicipal.setBounds(0, 0, 1170, 560);

        jmArchivo.setText("Archivo");

        jmiExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jmiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Desarrolladores_1.png"))); // NOI18N
        jmiExit.setText("Creditos");
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmArchivo.add(jmiExit);

        jMenuBar1.add(jmArchivo);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
       NominetBan Obj= new NominetBan();
       Obj.setLocationRelativeTo(null);
       Obj.setVisible(true);
    }//GEN-LAST:event_jmiExitActionPerformed

    private void jtfNombresAlumnosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombresAlumnosKeyTyped
        if (!Character.isLetter(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        }
        nuevoAlumno.getNombre();
}//GEN-LAST:event_jtfNombresAlumnosKeyTyped

    private void jtfApellidosAlumnosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidosAlumnosKeyTyped
        if (!Character.isLetter(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        }
        nuevoAlumno.getApellido();
}//GEN-LAST:event_jtfApellidosAlumnosKeyTyped

    private void jftNotaDelQuintoParcialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftNotaDelQuintoParcialKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        nuevoAlumno.getParcial5();
}//GEN-LAST:event_jftNotaDelQuintoParcialKeyTyped

    private void jftNotaDelQuintoParcialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftNotaDelQuintoParcialFocusLost
        if (jftNotaDelQuintoParcial.getText().trim().length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No se puede proseguir con la aplicacion" + " \n "
                    + " porque no ha ingresado ninguna nota", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            nuevoAlumno.setParcial5(Double.valueOf(jftNotaDelQuintoParcial.getText()));
            jftNotaDelQuintoParcial.setText(String.valueOf(nuevoAlumno.getParcial5()));
        }
}//GEN-LAST:event_jftNotaDelQuintoParcialFocusLost

    private void jftNotaDelQuintoParcialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jftNotaDelQuintoParcialMouseClicked
        jftNotaDelQuintoParcial.setText("");
}//GEN-LAST:event_jftNotaDelQuintoParcialMouseClicked

    private void jftNotaDelPrimerParcialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftNotaDelPrimerParcialKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        nuevoAlumno.getParcial1();
}//GEN-LAST:event_jftNotaDelPrimerParcialKeyTyped

    private void jftNotaDelPrimerParcialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftNotaDelPrimerParcialFocusLost
        if (jftNotaDelPrimerParcial.getText().trim().length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No se puede proseguir con la aplicacion" + " \n "
                    + " porque no ha ingresado ninguna nota", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            nuevoAlumno.setParcial1(Double.valueOf(jftNotaDelPrimerParcial.getText()));
            jftNotaDelPrimerParcial.setText(String.valueOf(nuevoAlumno.getParcial1()));
        }
}//GEN-LAST:event_jftNotaDelPrimerParcialFocusLost

    private void jftNotaDelPrimerParcialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jftNotaDelPrimerParcialMouseClicked
        jftNotaDelPrimerParcial.setText("");
}//GEN-LAST:event_jftNotaDelPrimerParcialMouseClicked

    private void jftNotaDelTercerParcialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftNotaDelTercerParcialKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        nuevoAlumno.getParcial3();
}//GEN-LAST:event_jftNotaDelTercerParcialKeyTyped

    private void jftNotaDelTercerParcialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftNotaDelTercerParcialFocusLost
        if (jftNotaDelTercerParcial.getText().trim().length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No se puede proseguir con la aplicacion" + " \n "
                    + " porque no ha ingresado ninguna nota", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            nuevoAlumno.setParcial3(Double.valueOf(jftNotaDelTercerParcial.getText()));
            jftNotaDelTercerParcial.setText(String.valueOf(nuevoAlumno.getParcial3()));
        }
}//GEN-LAST:event_jftNotaDelTercerParcialFocusLost

    private void jftNotaDelTercerParcialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jftNotaDelTercerParcialMouseClicked
        jftNotaDelTercerParcial.setText("");
}//GEN-LAST:event_jftNotaDelTercerParcialMouseClicked

    private void jftNotaDelSegundoParcialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftNotaDelSegundoParcialKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        nuevoAlumno.getParcial2();
}//GEN-LAST:event_jftNotaDelSegundoParcialKeyTyped

    private void jftNotaDelSegundoParcialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftNotaDelSegundoParcialFocusLost
        if (jftNotaDelSegundoParcial.getText().trim().length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No se puede proseguir con la aplicacion" + " \n "
                    + " porque no ha ingresado ninguna nota", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            nuevoAlumno.setParcial2(Double.valueOf(jftNotaDelSegundoParcial.getText()));
            jftNotaDelSegundoParcial.setText(String.valueOf(nuevoAlumno.getParcial2()));
        }
}//GEN-LAST:event_jftNotaDelSegundoParcialFocusLost

    private void jftNotaDelSegundoParcialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jftNotaDelSegundoParcialMouseClicked
        jftNotaDelSegundoParcial.setText("");
}//GEN-LAST:event_jftNotaDelSegundoParcialMouseClicked

    private void jbGuardarInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarInformacionActionPerformed
        if (datosCompletosDeAlumno()) {
            if (modificarNumero == -1) {
                alu.agregar(jftNumeroDeCarnet.getText(),
                        jtfNombresAlumnos.getText(),
                        jtfApellidosAlumnos.getText(),
                        Double.parseDouble(jftNotaDelPrimerParcial.getText()),
                        Double.parseDouble(jftNotaDelSegundoParcial.getText()),
                        Double.parseDouble(jftNotaDelTercerParcial.getText()),
                        Double.parseDouble(jftNotasDelCuartoParcial.getText()),
                        Double.parseDouble(jftNotaDelQuintoParcial.getText()));
                JOptionPane.showMessageDialog(this, "Alumno agregado correctamente", "INFO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                alu.modificar(modificarNumero, jftNumeroDeCarnet.getText(),
                        jtfNombresAlumnos.getText(),
                        jtfApellidosAlumnos.getText(),
                        Double.parseDouble(jftNotaDelPrimerParcial.getText()),
                        Double.parseDouble(jftNotaDelSegundoParcial.getText()),
                        Double.parseDouble(jftNotaDelTercerParcial.getText()),
                        Double.parseDouble(jftNotasDelCuartoParcial.getText()),
                        Double.parseDouble(jftNotaDelQuintoParcial.getText()));
                modificarNumero = -1;
                JOptionPane.showMessageDialog(this, "Alumno modificado correctamente", "INFO", JOptionPane.INFORMATION_MESSAGE);

            }
            actualizarGUINuevoAlumno();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this,
                    "No se pudo agregar el alumno, por que no han sido llenados algunos datos" + "\n" + "Favor llenarlos",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        actualizarIconoGuardar();
    }//GEN-LAST:event_jbGuardarInformacionActionPerformed

    private void jbPromedioNotasAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPromedioNotasAlumnosActionPerformed
        jlResultadoPromedio.setText(String.valueOf((Math.rint(nuevoAlumno.CalcularPromedio() * Math.pow(10, 2))) / 100));
        jtfEstatusAprobadoReprobado.setText(nuevoAlumno.EstatusDeAlumno());
}//GEN-LAST:event_jbPromedioNotasAlumnosActionPerformed

    private void jftNotasDelCuartoParcialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftNotasDelCuartoParcialKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        nuevoAlumno.getParcial4();
}//GEN-LAST:event_jftNotasDelCuartoParcialKeyTyped

    private void jftNotasDelCuartoParcialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftNotasDelCuartoParcialFocusLost
        if (jftNotasDelCuartoParcial.getText().trim().length() == 0) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No se puede proseguir con la aplicacion" + " \n "
                    + " porque no ha ingresado ninguna nota", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            nuevoAlumno.setParcial4(Double.valueOf(jftNotasDelCuartoParcial.getText()));
            jftNotasDelCuartoParcial.setText(String.valueOf(nuevoAlumno.getParcial4()));
        }
}//GEN-LAST:event_jftNotasDelCuartoParcialFocusLost

    private void jftNotasDelCuartoParcialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jftNotasDelCuartoParcialMouseClicked
        jftNotasDelCuartoParcial.setText("");
}//GEN-LAST:event_jftNotasDelCuartoParcialMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int numero = (Integer) jtMostrarAlumnos.getValueAt(jtMostrarAlumnos.getSelectedRow(), 0);
            alu.eliminar(numero);
            actualizarGUINuevoAlumno();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno a eliminar");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int numero = (Integer) jtMostrarAlumnos.getValueAt(jtMostrarAlumnos.getSelectedRow(), 0);
            mostrarDatosModificar(numero);
            modificarNumero = numero;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno a modificar");
        }
        actualizarIconoGuardar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jcbCriteriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCriteriosActionPerformed
        buscar();
    }//GEN-LAST:event_jcbCriteriosActionPerformed

    private void jtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaKeyReleased
        buscar();
    }//GEN-LAST:event_jtBusquedaKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       int a=JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea salir?", "Salir",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (a==JOptionPane.YES_OPTION)System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jftNumeroDeCarnetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jftNumeroDeCarnetMouseClicked
    jftNumeroDeCarnet.setText(null);
    }//GEN-LAST:event_jftNumeroDeCarnetMouseClicked

    private void jtfEstatusAprobadoReprobadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEstatusAprobadoReprobadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEstatusAprobadoReprobadoActionPerformed

    /**
     * @param args the command line arguments
     */
//------------------------------------------------------------------------------
//         CLASE MAIN
//------------------------------------------------------------------------------
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                NominasDAlumnos Obj = new NominasDAlumnos();
                Obj.setLocationRelativeTo(null);
                Obj.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbGuardarInformacion;
    private javax.swing.JButton jbPromedioNotasAlumnos;
    private javax.swing.JComboBox jcbCriterios;
    private javax.swing.JFormattedTextField jftNotaDelPrimerParcial;
    private javax.swing.JFormattedTextField jftNotaDelQuintoParcial;
    private javax.swing.JFormattedTextField jftNotaDelSegundoParcial;
    private javax.swing.JFormattedTextField jftNotaDelTercerParcial;
    private javax.swing.JFormattedTextField jftNotasDelCuartoParcial;
    private javax.swing.JFormattedTextField jftNumeroDeCarnet;
    private javax.swing.JLabel jlApellidos;
    private javax.swing.JLabel jlApro;
    private javax.swing.JLabel jlCarnet;
    private javax.swing.JLabel jlCuartoParcial1;
    private javax.swing.JLabel jlNombres;
    private javax.swing.JLabel jlNotas;
    private javax.swing.JLabel jlPrimerParcial;
    private javax.swing.JLabel jlPromedio;
    private javax.swing.JLabel jlQuintoParcial2;
    private javax.swing.JLabel jlRepro;
    private javax.swing.JLabel jlResultadoPromedio;
    private javax.swing.JLabel jlSegundoParcial;
    private javax.swing.JLabel jlTercerParcial;
    private javax.swing.JMenu jmArchivo;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JPanel jpPrinicipal;
    private javax.swing.JTextField jtBusqueda;
    private javax.swing.JTable jtMostrarAlumnos;
    private javax.swing.JTextField jtfApellidosAlumnos;
    private javax.swing.JTextField jtfEstatusAprobadoReprobado;
    private javax.swing.JTextField jtfNombresAlumnos;
    // End of variables declaration//GEN-END:variables
}
