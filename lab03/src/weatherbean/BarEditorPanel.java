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
class BarEditorPanel extends JPanel {

    private JLabel infoLabel = new JLabel("Bar: ");
    private JTextField barText = new JTextField();
    private JButton button = new JButton("Confirm");
    
    public BarEditorPanel(PropertyEditorSupport ed) 
    {
      editor = ed;
      setLayout(new FlowLayout());
      add(infoLabel);
      add(barText);
      
      ActionListener buttonListener = new ActionListener()
         {  
            public void actionPerformed(ActionEvent event)
            {  
               editor.setValue(Double.parseDouble(barText.getText()));
               editor.firePropertyChange();
            }
         };
      button.addActionListener(buttonListener);
   }
   private PropertyEditorSupport editor;
}
