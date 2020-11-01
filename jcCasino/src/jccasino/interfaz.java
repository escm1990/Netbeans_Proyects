package jccasino;

import javax.swing.JOptionPane;
/**
*  @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class interfaz extends javax.swing.JFrame {
    //se crean los objetos JLabel
    juego IMAGEN1 = new juego();
    juego IMAGEN2 = new juego();
    juego IMAGEN3 = new juego();
    
    /** Creates new form interfaz */
    public interfaz() {
        initComponents();
        this.setTitle("Juego Casino by Mouse");
        //formulario al centro de la pantalla
        this.setLocationRelativeTo(null);
        //se añaden a los cuadros
        CUADRO1.add(IMAGEN1);
        CUADRO2.add(IMAGEN2);
        CUADRO3.add(IMAGEN3);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CUADRO1 = new javax.swing.JPanel();
        CUADRO2 = new javax.swing.JPanel();
        CUADRO3 = new javax.swing.JPanel();
        play = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CUADRO1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CUADRO1.setPreferredSize(new java.awt.Dimension(129, 129));

        javax.swing.GroupLayout CUADRO1Layout = new javax.swing.GroupLayout(CUADRO1);
        CUADRO1.setLayout(CUADRO1Layout);
        CUADRO1Layout.setHorizontalGroup(
            CUADRO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );
        CUADRO1Layout.setVerticalGroup(
            CUADRO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        CUADRO2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CUADRO2.setPreferredSize(new java.awt.Dimension(129, 129));

        javax.swing.GroupLayout CUADRO2Layout = new javax.swing.GroupLayout(CUADRO2);
        CUADRO2.setLayout(CUADRO2Layout);
        CUADRO2Layout.setHorizontalGroup(
            CUADRO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );
        CUADRO2Layout.setVerticalGroup(
            CUADRO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        CUADRO3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CUADRO3.setPreferredSize(new java.awt.Dimension(129, 129));

        javax.swing.GroupLayout CUADRO3Layout = new javax.swing.GroupLayout(CUADRO3);
        CUADRO3.setLayout(CUADRO3Layout);
        CUADRO3Layout.setHorizontalGroup(
            CUADRO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );
        CUADRO3Layout.setVerticalGroup(
            CUADRO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CUADRO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CUADRO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CUADRO3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CUADRO3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CUADRO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CUADRO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        play.setText("Jugar");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/banner.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                            .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(play, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //hace lo que dice su nombre XD
    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
       if(play.getText().equals("Jugar"))    {
            IMAGEN1.startAnimation();
            IMAGEN2.startAnimation();
            IMAGEN3.startAnimation();   
            play.setText("Parar");
       }else{
           play.setText("Jugar");
          IMAGEN1.stopAnimation();
          IMAGEN2.stopAnimation();
          IMAGEN3.stopAnimation();
           if((IMAGEN1.getIcon().toString().equals(IMAGEN2.getIcon().toString())) && 
              (IMAGEN1.getIcon().toString().equals(IMAGEN3.getIcon().toString())))
          {
            JOptionPane.showMessageDialog(this,"Los tres son iguales GANASTE!!!!!!!!!!");
          } else{
            JOptionPane.showMessageDialog(this,"No son iguales, LOSER!!!!!!!!!!!!!!!!");
         }
       }     
}//GEN-LAST:event_playActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CUADRO1;
    private javax.swing.JPanel CUADRO2;
    private javax.swing.JPanel CUADRO3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton play;
    // End of variables declaration//GEN-END:variables
    
}