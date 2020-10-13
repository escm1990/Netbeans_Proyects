/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jairosoft.mop.transporte.examples;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author edwin
 */
public class RowHeaderCellRenderer extends JLabel implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JTableHeader header = table.getTableHeader();
        setOpaque(true);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setHorizontalAlignment(CENTER);
        setForeground(header.getForeground());
        setBackground(header.getBackground());
        setFont(header.getFont());
        setText(value!=null?value.toString():"");
        
        return this;
    }


    
}
