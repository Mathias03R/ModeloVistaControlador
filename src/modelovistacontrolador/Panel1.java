package modelovistacontrolador;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Panel1 extends JPanel{
    
    private Object[] info;
    
    private Panel2 panel2 = new Panel2();
    
    JLabel event = new JLabel("Event Description");
    JLabel email = new JLabel("Forward e-mail");
    JLabel date = new JLabel("Date");
    JLabel freq = new JLabel("Frequency");
        
    JTextField eventField = new JTextField(20);
    JTextField emailField = new JTextField(20);
    JTextField dateField = new JTextField(20);
        
    JRadioButton daily = new JRadioButton("Daily");
    JRadioButton weekly = new JRadioButton("Weekly");
    JRadioButton monthly = new JRadioButton("Monthly");
        
    ButtonGroup grupoCheckboxes = new ButtonGroup();
        
    JCheckBox alarm = new JCheckBox("Alarm");
        
    JButton save = new JButton("Save");
    JButton clean = new JButton("Clean");

    public Panel1() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        grupoCheckboxes.add(daily);
        grupoCheckboxes.add(weekly);
        grupoCheckboxes.add(monthly);
        
        gbc.anchor = GridBagConstraints.WEST;

        // Event Description
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(event, gbc);
        gbc.gridx++;
        add(eventField, gbc);

        // Forward e-mail
        gbc.gridx = 0;
        gbc.gridy++;
        add(email, gbc);
        gbc.gridx++;
        add(emailField, gbc);

        // Date
        gbc.gridx = 0;
        gbc.gridy++;
        add(date, gbc);
        gbc.gridx++;
        add(dateField, gbc);

        // Frequency
        gbc.gridx = 0;
        gbc.gridy++;
        add(freq, gbc);

        // Panel para los botones de frecuencia
        gbc.gridx++;
        JPanel frequencyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frequencyPanel.add(daily);
        frequencyPanel.add(weekly);
        frequencyPanel.add(monthly);
        add(frequencyPanel, gbc);

        // Alarm
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(alarm, gbc);
        gbc.gridwidth = 1;

        // Save and Clean buttons
        gbc.gridy++;
        gbc.gridx = 0;
        add(save, gbc);
        gbc.gridx++;
        add(clean, gbc);
        
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerDatos();
            }
        });
        
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanFields();
                cleanRadioButtons();
                cleanCheckBox();
            }
        });
    }
    
    public Object[] getInfo() {
        return info;
    }
    
    private void cleanFields(){
        eventField.setText("");
        emailField.setText("");
        dateField.setText("");
    }
    
    private void cleanRadioButtons(){
        grupoCheckboxes.clearSelection();
    }
    
    private void cleanCheckBox(){
        alarm.setSelected(false);
    }

    public Panel2 getPanel2() {
        return panel2;
    }
    
    private void obtenerDatos(){
        String eventName = eventField.getText();
        String eventEmail = emailField.getText();
        String eventDate = dateField.getText();
        String eventFrequency = "";
        if (daily.isSelected()) {
            eventFrequency = "Daily";
        } else if (weekly.isSelected()) {
            eventFrequency = "Weekly";
        } else if (monthly.isSelected()) {
            eventFrequency = "Monthly";
        }
        boolean eventAlarm = alarm.isSelected();

        info = new Object[]{eventName, eventEmail, eventDate, eventFrequency, eventAlarm};
        panel2.addEvent(info);
    }
}
