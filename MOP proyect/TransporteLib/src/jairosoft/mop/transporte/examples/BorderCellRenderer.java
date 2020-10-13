/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jairosoft.mop.transporte.examples;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author edwin
 */
public class BorderCellRenderer extends JLabel implements TableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        TableCellRenderer defaultRenderer = table.getDefaultRenderer(TableCellRenderer.class);
        JLabel comp = (JLabel)defaultRenderer;
        
        setHorizontalAlignment(CENTER);
        setText(value!=null?value.toString():"");
        if(isSelected)
            setForeground(Color.CYAN);
        return this;
    }
}
