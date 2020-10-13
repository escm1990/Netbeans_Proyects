package vista;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class principal extends javax.swing.JFrame {

    /** Creates new form principal */
    public principal() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        cmdIdentificacion = new j2Button.j2Button();
        cmdExit = new j2Button.j2Button();
        cmdProgramar = new j2Button.j2Button();
        cmdImprimir = new j2Button.j2Button();
        cmdAcercade = new j2Button.j2Button();
        jCDesktopPane1 = new JCDesktopPane.JCDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        cmdIdentificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/pc.png"))); // NOI18N
        cmdIdentificacion.setColor1(new java.awt.Color(0, 0, 0));
        cmdIdentificacion.setColor2(new java.awt.Color(153, 153, 153));
        cmdIdentificacion.setFocusable(false);
        cmdIdentificacion.setFont(new java.awt.Font("Arial Black", 1, 12));
        cmdIdentificacion.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        cmdIdentificacion.setFuente2(new java.awt.Font("Arial", 1, 10));
        cmdIdentificacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdIdentificacion.setTexto1("IDENTIFICATE");
        cmdIdentificacion.setTexto2("Iniciar Sesión");
        cmdIdentificacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(cmdIdentificacion);

        cmdExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/out.png"))); // NOI18N
        cmdExit.setColor1(new java.awt.Color(0, 0, 0));
        cmdExit.setColor2(new java.awt.Color(153, 153, 153));
        cmdExit.setEnabled(false);
        cmdExit.setFocusable(false);
        cmdExit.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        cmdExit.setFuente2(new java.awt.Font("Arial", 1, 10));
        cmdExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdExit.setTexto1("SALIR");
        cmdExit.setTexto2("Cerrar Sesión");
        cmdExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(cmdExit);

        cmdProgramar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/ppg.png"))); // NOI18N
        cmdProgramar.setColor1(new java.awt.Color(0, 0, 0));
        cmdProgramar.setColor2(new java.awt.Color(153, 153, 153));
        cmdProgramar.setEnabled(false);
        cmdProgramar.setFocusable(false);
        cmdProgramar.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        cmdProgramar.setFuente2(new java.awt.Font("Arial", 1, 10));
        cmdProgramar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdProgramar.setTexto1("PROGRAMAR");
        cmdProgramar.setTexto2("Registrar Asignaturas");
        cmdProgramar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(cmdProgramar);

        cmdImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/print64.png"))); // NOI18N
        cmdImprimir.setColor1(new java.awt.Color(0, 0, 0));
        cmdImprimir.setColor2(new java.awt.Color(153, 153, 153));
        cmdImprimir.setEnabled(false);
        cmdImprimir.setFocusable(false);
        cmdImprimir.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        cmdImprimir.setFuente2(new java.awt.Font("Arial", 1, 10));
        cmdImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdImprimir.setTexto1("IMPRIMIR");
        cmdImprimir.setTexto2("Imprimir Kardex");
        cmdImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(cmdImprimir);

        cmdAcercade.setFocusable(false);
        cmdAcercade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdAcercade.setTexto1("Acerca de...");
        cmdAcercade.setTexto2("jc Mouse");
        cmdAcercade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(cmdAcercade);

        jCDesktopPane1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
            .addComponent(jCDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public j2Button.j2Button cmdAcercade;
    public j2Button.j2Button cmdExit;
    public j2Button.j2Button cmdIdentificacion;
    public j2Button.j2Button cmdImprimir;
    public j2Button.j2Button cmdProgramar;
    public JCDesktopPane.JCDesktopPane jCDesktopPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
