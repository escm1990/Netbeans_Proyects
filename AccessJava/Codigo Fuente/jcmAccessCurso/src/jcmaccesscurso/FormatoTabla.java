package jcmaccesscurso;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class FormatoTabla extends DefaultTableCellRenderer{

     @Override 
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ) 
    {
        setBackground(Color.cyan);//color de fondo
        //table.setFont(normal);//tipo de fuente
        table.setForeground(Color.black);//color de texto
        setHorizontalAlignment(2);//derecha
        
         //si la celda contiene números
        if(isNumber(String.valueOf(table.getValueAt(row,column)))){
            if(Float.valueOf(table.getValueAt(row,column).toString())>=51){
                setBackground(Color.YELLOW);             
            }
            if(Float.valueOf(table.getValueAt(row,column).toString())<51){
                setBackground(Color.red);             
            }
            if(Float.valueOf(table.getValueAt(row,column).toString())>=71){
                setBackground(Color.GREEN);             
            }
            setHorizontalAlignment(4);//izquierda
        }    
         
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);         
        return this;
     }
 
     //
 private boolean isNumber(String cadena){
         try {
             Double.parseDouble(cadena.replace(",", ""));
         } catch (NumberFormatException nfe){
             String newCadena = cadena.replace(".", "").replace(',', '.');
             try{
                 Double.parseDouble(newCadena);
             } catch (NumberFormatException nfe2){
                 return false;
             }
        }
         return true;
    }

}
