/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherbean;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyEditorSupport;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Norbert
 */
class TemperatureEditorPanel extends JPanel 
{
    private JLabel infoLabel = new JLabel("Temperature: ");
    private JTextField temperatureText = new JTextField("0000");
    private JButton button = new JButton("Confirm");
    
    public TemperatureEditorPanel(PropertyEditorSupport ed) 
    {
      editor = ed;
      setLayout(new FlowLayout());
      add(infoLabel);
      add(temperatureText);
      add(button);
      ActionListener buttonListener = new ActionListener()
         {  
            public void actionPerformed(ActionEvent event)
            {  
               editor.setValue(Double.parseDouble(temperatureText.getText()));
               editor.firePropertyChange();
            }
         };
      button.addActionListener(buttonListener);
   }
   private PropertyEditorSupport editor;
}
