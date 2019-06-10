
package p.vitaly.geocamunda.utils;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author vitalyp
 * 
 * Represent geographic location
 */
@Data
public class Geo implements Serializable{

    private static final long serialVersionUID = 4818210346734336219L;
    
    private Double latitude;
    private Double longitude;

}
