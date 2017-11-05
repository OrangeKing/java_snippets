/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbean;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Norbert
 */
public class AddressBean extends JPanel 
{
    private String title = "JBean AddressBook";
    private Border border = BorderFactory.createTitledBorder(title);

    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton addContactButton;
    private javax.swing.JButton removeContactButton;
    private javax.swing.JScrollPane tableScroll;
    private javax.swing.JTable addressTable;


    private void initComponents()
    {
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        addContactButton = new javax.swing.JButton();
        removeContactButton = new javax.swing.JButton();
        tableScroll = new javax.swing.JScrollPane();
        addressTable = new javax.swing.JTable();
        
        this.setBorder(border);
        
        addressTable.setModel(new javax.swing.table.DefaultTableModel(
        /*table model definiton starts*/
            new Object [][] {
            },
            new String [] {
                "Username", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        /*table model definiton ends*/
        
        nameLabel.setText("Name:");
        emailLabel.setText("Email:");

        addContactButton.setText("Add Contact");
        addContactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        removeContactButton.setText("Remove Contact");
        removeContactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        tableScroll.setViewportView(addressTable);
        
        /* layout definition starts*/
        javax.swing.GroupLayout actionLayout = new javax.swing.GroupLayout(this);
        this.setLayout(actionLayout);
        actionLayout.setHorizontalGroup(
            actionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(actionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(actionLayout.createSequentialGroup()
                        .addGroup(actionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(actionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField)
                            .addComponent(emailField)))
                    .addGroup(actionLayout.createSequentialGroup()
                        .addComponent(addContactButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeContactButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(tableScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );
        actionLayout.setVerticalGroup(
            actionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(actionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(actionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(actionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addContactButton)
                    .addComponent(removeContactButton))
                .addGap(20, 20, 20)
                .addComponent(tableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
        );
        /* layout definition ends*/
    }
    
    /***************************** button logic *****************************/

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
    {                                         
        DefaultTableModel model = (DefaultTableModel) addressTable.getModel();
        model.addRow(new Object[] {"test", "test"});
        System.out.println("Added contact");

    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) 
    {                                         
        DefaultTableModel model = (DefaultTableModel) addressTable.getModel();
        int[] selection = addressTable.getSelectedRows();
        for (int select : selection)
        {
            model.removeRow(select);
        }
        System.out.println("Deleted contact");
    }    

    /***************************** getters & setters section *****************************/
    
    
    public Color getBackgroundColor() {return this.getBackground();}
    public void setBackgroundColor(Color value) {this.setBackground(value);}

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
        this.border = BorderFactory.createTitledBorder(title);
        this.setBorder(border);

    }
    
    public AddressBean()
    {
        initComponents();
    }
}
