
package Services;
import Entities.Chamado;
import Entities.Maquina;
import Views.TelaProcessos;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


public abstract class ButtonColumn extends AbstractCellEditor
implements TableCellRenderer, TableCellEditor, ActionListener{
    
    JTable table;
    JButton renderButton;
    JButton editButton;
    String text;
        Chamado cham = new Chamado();
        public ButtonColumn(JTable table, int column, Chamado chamado)
    {
        super();
        this.table = table;
        renderButton = new JButton();

        editButton = new JButton();
        editButton.setFocusPainted(true);
        editButton.addActionListener(this);
        editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cham = chamado;

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer( this );
        columnModel.getColumn(column).setCellEditor( this );
        
    }
    
        
        public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        if (hasFocus)
        {
            //renderButton.setForeground(table.getForeground());
            //renderButton.setBackground(UIManager.getColor("Button.background"));
            
           
        }
        else if (isSelected)
        {
             //renderButton.setForeground(table.getForeground());
             //renderButton.setBackground(table.getSelectionBackground());
            
        }
        else
        {
            //renderButton.setForeground(table.getForeground());
            //renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        renderButton.setText( (value == null) ? "Detalhes" : value.toString() );
        
        return renderButton;
    }
        
        public Component getTableCellEditorComponent(
        JTable table, Object value, boolean isSelected, int row, int column)
    {
        text = (value == null) ? "Detalhes" : value.toString();
        editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editButton.setText( text );
        return editButton;
    }
        
        public Object getCellEditorValue()
    {
        return text;
    }

    public void actionPerformed(ActionEvent e)
    {
        
        System.out.println(table.getValueAt(table.getSelectedRow(),1));
        System.out.println(cham.getMaquina().getNome());
        TelaProcessos tp = new TelaProcessos(cham);
        
        tp.setVisible(true);
        
    }

}
