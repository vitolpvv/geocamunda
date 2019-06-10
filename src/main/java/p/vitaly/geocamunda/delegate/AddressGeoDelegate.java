
package p.vitaly.geocamunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import p.vitaly.geocamunda.service.AddressGeoService;
import p.vitaly.geocamunda.utils.Geo;

/**
 *
 * @author vitalyp
 * 
 * Abstract Camunda Service Task handler. Executed when user submits address
 * simple name. Fetch Geo from AddressGeoService. Set 'latitude' and 'longitude'
 * variables which shows up on result form.
 */
abstract class AddressGeoDelegate implements JavaDelegate{

    @Override
    public void execute(DelegateExecution de) throws Exception {
        Geo geo = getAddressGeoService().getAddressGeo((String) de.getVariable("address"));
        de.setVariable("latitude", geo.getLatitude() == null ? "" : geo.getLatitude());
        de.setVariable("longitude", geo.getLongitude() == null ? "" : geo.getLongitude());
    }
    
    abstract AddressGeoService getAddressGeoService();

}
