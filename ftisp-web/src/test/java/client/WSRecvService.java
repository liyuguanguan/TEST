
package client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSRecvService", targetNamespace = "http://api.csp.ygjt.com/", wsdlLocation = "http://114.215.221.67:8085/com.ygjt.csp.api.WSRecvService?wsdl")
public class WSRecvService
    extends Service
{

    private final static URL WSRECVSERVICE_WSDL_LOCATION;
    private final static WebServiceException WSRECVSERVICE_EXCEPTION;
    private final static QName WSRECVSERVICE_QNAME = new QName("http://api.csp.ygjt.com/", "WSRecvService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://114.215.221.67:8085/com.ygjt.csp.api.WSRecvService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSRECVSERVICE_WSDL_LOCATION = url;
        WSRECVSERVICE_EXCEPTION = e;
    }

    public WSRecvService() {
        super(__getWsdlLocation(), WSRECVSERVICE_QNAME);
    }

    public WSRecvService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSRECVSERVICE_QNAME, features);
    }

    public WSRecvService(URL wsdlLocation) {
        super(wsdlLocation, WSRECVSERVICE_QNAME);
    }

    public WSRecvService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSRECVSERVICE_QNAME, features);
    }

    public WSRecvService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSRecvService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSRecvServicePortType
     */
    @WebEndpoint(name = "WSRecvServicePort")
    public WSRecvServicePortType getWSRecvServicePort() {
        return super.getPort(new QName("http://api.csp.ygjt.com/", "WSRecvServicePort"), WSRecvServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSRecvServicePortType
     */
    @WebEndpoint(name = "WSRecvServicePort")
    public WSRecvServicePortType getWSRecvServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://api.csp.ygjt.com/", "WSRecvServicePort"), WSRecvServicePortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSRECVSERVICE_EXCEPTION!= null) {
            throw WSRECVSERVICE_EXCEPTION;
        }
        return WSRECVSERVICE_WSDL_LOCATION;
    }

}
