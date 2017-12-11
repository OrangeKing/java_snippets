package offers;
import javax.xml.bind.annotation.XmlRegistry;


/**
 *
 * @author Norbert
 */
@XmlRegistry
public class OfferRegistry 
{
    public OfferRegistry(){}

    
    public Offer createOffer() 
    {
        return new Offer();
    }
}
