package modelovistacontrolador;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class ModeloVistaControlador extends JFrame{
    JTabbedPane tabbedPane = new JTabbedPane();
    
    Panel1 panel1 = new Panel1();
    
    public ModeloVistaControlador() {
        setTitle("Tarea");
        setSize(500, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane.add("New Event", panel1);
        tabbedPane.add("Events", panel1.getPanel2());
        
        add(tabbedPane);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ModeloVistaControlador();
            }
        });;
    }
    
    
    
    
}
