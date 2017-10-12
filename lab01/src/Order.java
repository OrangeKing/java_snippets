
import java.io.Serializable;
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
public class Order implements Serializable
{
  public String advertText;
  public Duration displayPeriod;
  public IClient client;

    public Order(String advertText, Duration displayPeriod, IClient client) 
    {
        this.advertText = advertText;
        this.displayPeriod = displayPeriod;
        this.client = client;
    }
}

