
package p.vitaly.geocamunda.delegate;

import p.vitaly.geocamunda.service.AddressGeoService;
import p.vitaly.geocamunda.service.DaDataProxyAddressGeoService;

/**
 *
 * @author vitalyp
 * 
 * Abstract Camunda Service Task handler extension which uses
 * DaDataProxy as AddressGeoService.
 */
public final class DaDataProxyAddressGeoDelegate extends AddressGeoDelegate{
    
    private final DaDataProxyAddressGeoService service = new DaDataProxyAddressGeoService();

    @Override
    final AddressGeoService getAddressGeoService() {
        return service;
    }

}
