/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adbean;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import javax.swing.JOptionPane;

/**
 *
 * @author Norbert
 */
public class adForm extends JPanel implements Serializable
{
    //simple property
    private String title;
    public Color getColor() {return getBackground();} 
    public void setColor(Color color) {setBackground(color);} 

    
    //bound property
    private int recordCount;
    private final PropertyChangeSupport pcs;
    private final VetoableChangeSupport vcs;
    
    //constrained property
    private String email;
    private String name;

    private javax.swing.JButton addRecordButton;
    private javax.swing.JToggleButton removeRecordButton;

    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel emailLabel;

    private javax.swing.JLabel countLabel;

    private javax.swing.JTextField nameField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField recordCountField;

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable recordTable;

    
    public adForm()
    {
        this.title = "AddressBean";
        this.recordCount = 0;
        pcs = new PropertyChangeSupport(this);
        vcs = new VetoableChangeSupport(this);

        initComponents();
    }
    
    private void initComponents()
    {
        
        jScrollPane1 = new javax.swing.JScrollPane();
        recordTable = new javax.swing.JTable();
        
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        
        addRecordButton = new javax.swing.JButton();
        removeRecordButton = new javax.swing.JToggleButton();
        
        countLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        recordCountField = new javax.swing.JTextField();

        this.setBorder(javax.swing.BorderFactory.createTitledBorder(this.title));

        recordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        jScrollPane1.setViewportView(recordTable);
        nameLabel.setText("name");
        emailLabel.setText("email");
        
        addRecordButton.setText("add Record");
        addRecordButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            addRecordButtonActionPerformed(evt);
        });

        removeRecordButton.setText("remove Record");
        removeRecordButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            removeRecordButtonActionPerformed(evt);
        });

        countLabel.setText("record count:");

        recordCountField.setEditable(false);
        recordCountField.setText(String.valueOf(this.recordCount));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nameLabel)
                            .addGap(18, 18, 18)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(countLabel)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(emailLabel)
                            .addGap(18, 18, 18)
                            .addComponent(emailField)))
                    .addComponent(addRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recordCountField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(addRecordButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeRecordButton)
                        .addGap(18, 18, 18)
                        .addComponent(countLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recordCountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }
    
    private void addRecordButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        DefaultTableModel model = (DefaultTableModel) recordTable.getModel();
        if(nameField.getText().equals("") && emailField.getText().equals("") )
        {
            Object[] options = { "OK", "CANCEL" };
            JOptionPane.showOptionDialog(null, "No proper address data given", "Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
        }
        else
        {
            model.addRow(new Object[] {emailField.getText(), nameField.getText()});
            this.setRecordCount(this.recordCount+1);
            recordCountField.setText(String.valueOf(this.recordCount));
            System.out.println("Record added");

        }
    }

    private void removeRecordButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                                   
        DefaultTableModel model = (DefaultTableModel) recordTable.getModel();
        int[] selection = recordTable.getSelectedRows();
        for (int select : selection)
        {
            model.removeRow(select);
            this.setRecordCount(this.recordCount-1);
            recordCountField.setText(String.valueOf(this.recordCount));
            System.out.println("Record removed");
        }

    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }
    
    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) throws PropertyVetoException
    {
        String old = this.email;
        this.vcs.fireVetoableChange( "email", old, email );
        this.email = email;
        this.pcs.firePropertyChange( "email", old, email );
    }

    @Override
    public String getName() 
    {
        return name;
    }

    @Override
    public void setName(String name) 
    {
        this.name = name;
    }

    public int getRecordCount() 
    {
        return recordCount;
    }

    public void setRecordCount(int recordCount) 
    {
        int old = this.recordCount;
        this.recordCount = recordCount;
        this.pcs.firePropertyChange( "recordCount", old, recordCount);
    }
    
    @Override
    public void addPropertyChangeListener( PropertyChangeListener listener )
    {
        this.pcs.addPropertyChangeListener( listener );
    }

    @Override
    public void removePropertyChangeListener( PropertyChangeListener listener )
    {
        this.pcs.removePropertyChangeListener( listener );
    }
    
    @Override
    public void addVetoableChangeListener( VetoableChangeListener listener )
    {
        this.vcs.addVetoableChangeListener( listener );
    }

    @Override
    public void removeVetoableChangeListener( VetoableChangeListener listener )
    {
        this.vcs.addVetoableChangeListener( listener );
    }

}