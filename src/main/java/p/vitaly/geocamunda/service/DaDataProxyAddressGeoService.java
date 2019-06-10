
package p.vitaly.geocamunda.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.ClientBuilder;
import p.vitaly.geocamunda.utils.Geo;

/**
 *
 * @author vitalyp
 * AddressGeoService implementation which uses DaDataProxy as provider.
 */
public class DaDataProxyAddressGeoService implements AddressGeoService{
    
    private String url = "";

    public DaDataProxyAddressGeoService() {
        try(InputStream is = DaDataProxyAddressGeoService.class.getClassLoader().getResourceAsStream("dadataproxy.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            
            String host = properties.getProperty("dadataproxy.host");
            String port = properties.getProperty("dadataproxy.port");
            String endpoint = properties.getProperty("dadataproxy.endpoint");
            
            StringBuilder sb = new StringBuilder();
            if (!host.toLowerCase().startsWith("http://")) {
                sb.append("http://");
            }
            sb.append(host);
            if (!"".equals(port)) {
                sb.append(':').append(port);
            }
            if (!endpoint.startsWith("/")) {
                sb.append('/');
            }
            sb.append(endpoint.replace(" ", "%20"));
            
            url = sb.toString();
        } catch (IOException ex) {
            Logger.getLogger(DaDataProxyAddressGeoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Send GET-request to DaDataProxy and return address geo-location.
     * @param address - address simple name.
     * @return p.vitaly.geocamunda.utils.Geo - address geo-location.
     */
    @Override
    public Geo getAddressGeo(String address) {
        return ClientBuilder
                .newClient()
                .target(url)
                .queryParam("addr", address.replace(" ", "%20"))
                .request()
                .get()
                .readEntity(Geo.class);
    }
}
