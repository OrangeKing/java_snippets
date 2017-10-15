
import java.rmi.RemoteException;
import java.time.Duration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Norbert
 */
public class Billboard implements IBillboard
{
    @Override
    public boolean addAdvertisement(String advertText, Duration displayPeriod, int orderId) throws RemoteException 
    {
        return true;
    }

    @Override
    public boolean removeAdvertisement(int orderId) throws RemoteException 
    {
        return true;
    }

    @Override
    public int[] getCapacity() throws RemoteException 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setDisplayInterval(Duration displayInterval) throws RemoteException 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean start() throws RemoteException 
    {
        return true;
    }

    @Override
    public boolean stop() throws RemoteException 
    {
        return true;
    }
    
}
