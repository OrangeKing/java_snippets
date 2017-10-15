
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
public interface IClient extends Remote  // host, port, nazwa
{
    public void setOrderId(int orderId, Order order) throws RemoteException;
}
