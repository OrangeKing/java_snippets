
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Norbert
 */
public interface IManager extends Remote // port, nazwa, GUI
{
    public int bindBillboard(IBillboard billboard) throws RemoteException; 
    public boolean unbindBillboard(int billboardId) throws RemoteException; 
    public boolean placeOrder(Order order) throws RemoteException; 
    public boolean withdrawOrder(int orderId) throws RemoteException;
}

