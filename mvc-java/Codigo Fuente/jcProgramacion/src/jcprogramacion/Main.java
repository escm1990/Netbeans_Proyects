package jcprogramacion;
//
import controlador.controlador;
import modelo.modelo;
import vista.principal;
//para el skin
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class Main {

    public static void main(String[] args) {
        //se crean los objetos MODELO Y VISTA
        modelo modelo = new modelo();
        principal vista = new principal();
       //Para colocar un skin propio de java
       try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vista);
            new controlador(vista, modelo).go();
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}
    }

}
