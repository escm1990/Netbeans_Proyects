/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Lienzo.java
 *
 * Created on 14/05/2009, 02:11:36 PM
 */

package com.blogspot.rolandopalermo.sockets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Rolando
 */
public class Lienzo extends javax.swing.JPanel {

    private Image imagen;
    /** Creates new form Lienzo */
    public Lienzo() {
        initComponents();
    }

    public void setImage(Image imagen) {
        this.imagen = imagen;
        repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint( Graphics g ) {
        super.paint( g );
        if( imagen != null ) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            g.setColor(Color.BLACK);
            g.drawString("http://rolandopalermo.blogspot.com", 10, 20);
        } else {
            ImageIcon banner = new ImageIcon(getClass().getResource("/com/blogspot/rolandopalermo/sockets/splash.jpg"));
            g.drawImage(banner.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
