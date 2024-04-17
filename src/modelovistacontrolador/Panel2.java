package modelovistacontrolador;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Panel2 extends JPanel{
    private DefaultTableModel modelo = new DefaultTableModel();
    private JTable tabla;

    public Panel2() {
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripción");
        modelo.addColumn("Frecuencia");
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Alarma");
        
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setColumnHeaderView(tabla.getTableHeader());
        add(scrollPane);
    }
    
    public void addEvent(Object[] nuevaFila){
        modelo.addRow(nuevaFila);
    } 
}
