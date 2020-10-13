/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * llamar.java
 *
 * Created on 11-nov-2010, 5:39:51
 */

/**
 *
 * @author P-RICO
 */

import java.net.URL;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
public class llamar extends javax.swing.JFrame {

    /** Este formulario es para reportes SIN PARAMETROS!!!!! */
    public llamar() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("LLamar reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(285, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton1)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
 *Este procedimeinto sirve para obtener la direccion fisica del reporte que quieren mostrar, les pongo esto
 * porque las direcciones cambian en linux con respecto a windows, es decir con este metodo podran mostrar
 * los reportes tanto el linux como en windows
 */
    public String direccionar()
    {
        String so=System.getProperty("os.name");
        URL dir=llamar.class.getProtectionDomain().getCodeSource().getLocation();//esta linea hace referencia a la clase misma
        String[] direc=dir.getPath().split("/");
        int h=0;
        String res="";
        if (so.equalsIgnoreCase("linux"))
        {
            res="/"+direc[0];
        }
        else
        {
            res=direc[0];
        }

        for(h=1;h<direc.length-1;h++)
        {
            res+=direc[h]+"/";
        }

        return res;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JasperReport report=null;
            try
            {

                report = JasperCompileManager.compileReport(this.direccionar().replaceAll("%20", " ") +"/src/alumnos.jrxml");
            }
            catch (Exception ex)
            {
            JOptionPane.showMessageDialog(this, "error al buscar "+ ex.getMessage());
            }
            Connection con;
            conexion c = new conexion();
            con = c.conectar();
            JasperPrint print=null;
        try {
            print = JasperFillManager.fillReport(report, null, con);
        } catch (JRException ex) {
           JOptionPane.showMessageDialog(this,"error al llenar "+ex.getMessage());
        }
            JasperViewer.viewReport(print);
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new llamar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

}
