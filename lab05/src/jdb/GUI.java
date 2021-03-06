/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdb;

import com.sun.org.apache.bcel.internal.generic.ObjectType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Norbert
 */
public class GUI extends javax.swing.JFrame 
{
    private JDB database = new JDB();

    /**
     * Creates new form GUI
     */
    public GUI() 
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dbPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        carListTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerListTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderLogTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        actionPanel = new javax.swing.JPanel();
        newUserButton = new javax.swing.JButton();
        removeUserButton = new javax.swing.JButton();
        placeOrderButton = new javax.swing.JButton();
        userOrderTable = new javax.swing.JButton();
        withdrawOrderButton = new javax.swing.JButton();
        completeOrderButton = new javax.swing.JButton();
        loadDataButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Car rental service");

        dbPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Database"));

        carListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Manufacturer", "Model"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(carListTable);

        customerListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(customerListTable);

        orderLogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Car", "Customer", "Started", "End", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(orderLogTable);

        jLabel1.setText("CARS");

        jLabel2.setText("CUSTOMERS");

        jLabel3.setText("ORDERS");

        javax.swing.GroupLayout dbPanelLayout = new javax.swing.GroupLayout(dbPanel);
        dbPanel.setLayout(dbPanelLayout);
        dbPanelLayout.setHorizontalGroup(
            dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dbPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(dbPanelLayout.createSequentialGroup()
                        .addGroup(dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        dbPanelLayout.setVerticalGroup(
            dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dbPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        actionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        newUserButton.setText("new user");
        newUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserButtonActionPerformed(evt);
            }
        });

        removeUserButton.setText("remove user");
        removeUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeUserButtonActionPerformed(evt);
            }
        });

        placeOrderButton.setText("place Order");
        placeOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeOrderButtonActionPerformed(evt);
            }
        });

        userOrderTable.setText("users orders");
        userOrderTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userOrderTableActionPerformed(evt);
            }
        });

        withdrawOrderButton.setText("withdraw Order");
        withdrawOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawOrderButtonActionPerformed(evt);
            }
        });

        completeOrderButton.setBackground(new java.awt.Color(153, 153, 255));
        completeOrderButton.setText("COMPLETE ORDER");
        completeOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeOrderButtonActionPerformed(evt);
            }
        });

        loadDataButton.setText("load Data");
        loadDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDataButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(completeOrderButton)
                    .addComponent(withdrawOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(actionPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(loadDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(userOrderTable, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(removeUserButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(newUserButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(loadDataButton)
                .addGap(18, 18, 18)
                .addComponent(newUserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeUserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userOrderTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(placeOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(withdrawOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(completeOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dbPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDataButtonActionPerformed
        // TODO add your handling code here:
        
        loadCustomers(); 
        loadCars();     
        loadOrders();     
    }//GEN-LAST:event_loadDataButtonActionPerformed

    private void newUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Enter  name: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter your lastname: ");
        String lastname = scanner.nextLine();
        database.addCustomer(username, lastname);
    }//GEN-LAST:event_newUserButtonActionPerformed

    private void removeUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeUserButtonActionPerformed
        // TODO add your handling code here:
        int id = customerListTable.getSelectedRow();
        database.deleteCustomer(id);
    }//GEN-LAST:event_removeUserButtonActionPerformed

    private void userOrderTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userOrderTableActionPerformed
        // TODO add your handling code here:
        int id = customerListTable.getSelectedRow();
        loadFilteredOrders(id);
    }//GEN-LAST:event_userOrderTableActionPerformed

    private void placeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeOrderButtonActionPerformed
        // TODO add your handling code here:
        int row = customerListTable.getSelectedRow();
        int column = customerListTable.getSelectedColumn();
        Object customer = orderLogTable.getModel().getValueAt(row, column);
        int customerId = Integer.valueOf(customer.toString());
        
        row = carListTable.getSelectedRow();
        column = carListTable.getSelectedColumn();
        Object car = carListTable.getModel().getValueAt(row, column);
        int carId = Integer.valueOf(car.toString());

        
        System.out.println("Enter  price: ");
        Scanner scanner = new Scanner(System.in);
        double price = Double.valueOf(scanner.nextLine());

        database.placeOrder(carId, customerId, price);
    }//GEN-LAST:event_placeOrderButtonActionPerformed

    private void withdrawOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawOrderButtonActionPerformed
        int id = orderLogTable.getSelectedRow();
        database.withdrawOrder(id);

    }//GEN-LAST:event_withdrawOrderButtonActionPerformed

    private void completeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeOrderButtonActionPerformed
        // TODO add your handling code here:
        int id = orderLogTable.getSelectedRow();
        database.completeOrder(id);
    }//GEN-LAST:event_completeOrderButtonActionPerformed

    private void loadCustomers()
    {
        DefaultTableModel model = (DefaultTableModel) customerListTable.getModel();
        model.setRowCount(0);
        ArrayList<String> result = database.selectCustomers();
        Object rowData[] = result.toArray();
        
        for(int i=0; i<rowData.length; i=i+3)
        {
            model.addRow(Arrays.copyOfRange(rowData, i, i+3));
        }      
    }
    
    private void loadCars()
    {
        DefaultTableModel model = (DefaultTableModel) carListTable.getModel();
        model.setRowCount(0);
        ArrayList<String> result = database.selectCars();
        Object rowData[] = result.toArray();
        
        for(int i=0; i<rowData.length; i=i+3)
        {
            model.addRow(Arrays.copyOfRange(rowData, i, i+3));
        }      
    }
    
    private void loadOrders()
    {
        DefaultTableModel model = (DefaultTableModel) orderLogTable.getModel();
        model.setRowCount(0);
        ArrayList<String> result = database.selectOrders();
        Object rowData[] = result.toArray();
        
        for(int i=0; i<rowData.length; i=i+6)
        {
            model.addRow(Arrays.copyOfRange(rowData, i, i+6));
        }      
    }
    
    private void loadFilteredOrders(int id)
    {
        DefaultTableModel model = (DefaultTableModel) orderLogTable.getModel();
        model.setRowCount(0);
        ArrayList<String> result = database.selectUserOrder(id);
        Object rowData[] = result.toArray();
        
        for(int i=0; i<rowData.length; i=i+6)
        {
            model.addRow(Arrays.copyOfRange(rowData, i, i+6));
        }      
    }
    
    public static void main(String args[]) throws SQLException
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JTable carListTable;
    private javax.swing.JButton completeOrderButton;
    private javax.swing.JTable customerListTable;
    private javax.swing.JPanel dbPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton loadDataButton;
    private javax.swing.JButton newUserButton;
    private javax.swing.JTable orderLogTable;
    private javax.swing.JButton placeOrderButton;
    private javax.swing.JButton removeUserButton;
    private javax.swing.JButton userOrderTable;
    private javax.swing.JButton withdrawOrderButton;
    // End of variables declaration//GEN-END:variables
}
