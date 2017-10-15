
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
    private boolean isActive = false;
    private int capacity = 1;
    private Duration displayInterval;

    private String advertText ="";
    private Duration displayPeriod = Duration.ofSeconds(10);
    public int orderId = 0;

    @Override
    public boolean addAdvertisement(String advertText, Duration displayPeriod, int orderId) throws RemoteException 
    {
        this.advertText = advertText;
        this.displayPeriod = displayPeriod;
        this.orderId = orderId;
        return true;
    }

    @Override
    public boolean removeAdvertisement(int orderId) throws RemoteException 
    {
        if (this.advertText != null && this.displayPeriod != null)
        {
            this.advertText = null;
            this.displayInterval = null;
            this.orderId = 0;
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int[] getCapacity() throws RemoteException 
    {
        int[] capacity = new int[2];
        capacity[0] = this.capacity;
        if(this.isActive == true)
        {
            capacity[1] = this.capacity - 1;
        }
        else
        {
            capacity[1] = this.capacity;
        }
        
        return capacity;
    }

    @Override
    public void setDisplayInterval(Duration displayInterval) throws RemoteException 
    {
        this.displayInterval = displayInterval;
    }

    @Override
    public boolean start() throws RemoteException 
    {
        this.isActive = true;
        return true;
    }

    @Override
    public boolean stop() throws RemoteException 
    {
        this.isActive = false;
        return true;
    }
    
}
