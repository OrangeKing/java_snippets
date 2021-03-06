
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Norbert
 */
public class Manager extends JFrame implements IManager
{
    // Variables declaration - do not modify  
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration    

    private final static ArrayList<Billboard> billboards = new ArrayList<Billboard>();
    private final static ArrayList<Order> orders = new ArrayList<Order>();

    public Manager() 
    {
        initComponents();
    }

    /* JFrame begin */
    @SuppressWarnings("checked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Manager's Window"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Working Billboards"));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Billboard", "Advert Text", "Duration Left", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (RemoteException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton2ActionPerformed(evt);
                } catch (RemoteException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        
                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException 
    {                  
        Billboard newBillboard = new Billboard();
        billboards.add(newBillboard);
  
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Object rowData[] = new Object [4];
        rowData[0] = newBillboard;
        model.addRow(rowData);
        
        bindBillboard(newBillboard);
    }                            

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException 
    {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int[] rows = jTable2.getSelectedRows();
        
        String billboardId = "Billboard" + rows[0];
        unbindBillboard(billboardId);

        if (jTable2.getSelectedRows().length != 0) 
        {
              for(int i=0;i<rows.length;i++)
              {
                  model.removeRow(rows[i]-i);
                  billboards.remove(rows[i]-i);
              }         
        }
        
    }
    /* JFrame end */
    
    
// element get on button to be passed into bind arg
//                    Billboard component = billboards.get(0);
    @Override
    public int bindBillboard(IBillboard billboard) throws RemoteException 
    {
        IBillboard stub_billboard = (IBillboard) UnicastRemoteObject.exportObject(billboard, 0);
        String billboardID = "Billboard" + billboards.indexOf(billboard);
        Registry registry = LocateRegistry.getRegistry(1099);
        registry.rebind(billboardID, stub_billboard); 
        System.err.println("Billboard bound succesfully as " + billboardID);
        return 0;
    }

    @Override
    public boolean unbindBillboard(String billboardId) throws RemoteException, AccessException 
    {
        // Bind the remote object's stub in the registry
        Registry registry = LocateRegistry.getRegistry(1099);
        try 
        {
            registry.unbind(billboardId);
        } 
        catch (NotBoundException ex) 
        {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.err.println(billboardId + " unbound successfully");
        return true;
    }

    @Override
    public boolean placeOrder(Order order) throws RemoteException 
    {
        orders.add(order);
        return true;
    }

    @Override
    public boolean withdrawOrder(int orderId) throws RemoteException 
    {
        orders.remove(orderId);
        return true; 
    }

    /* Main method below */
    public static void main(String[] args)
    {
        try 
        {
            Manager server = new Manager();            
            IManager stub_manager = (IManager) UnicastRemoteObject.exportObject(server, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Manager", stub_manager);
            System.err.println("Server ready");
        } 
        catch (Exception e) 
        {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Manager().setVisible(true);
            }
        });
    }
}
