
package p.vitaly.geocamunda.service;

import p.vitaly.geocamunda.utils.Geo;

/**
 *
 * @author vitalyp
 * Interface for fetching address geo-location from provider.
 */
public interface AddressGeoService {
    
    Geo getAddressGeo(String address);

}
