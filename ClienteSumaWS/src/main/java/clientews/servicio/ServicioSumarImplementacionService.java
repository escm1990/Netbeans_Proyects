
package clientews.servicio;

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
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServicioSumarImplementacionService", targetNamespace = "http://beans/", wsdlLocation = "http://localhost:8080/ServicioSumarImplementacionService/ServicioSumarImplementacion?wsdl")
public class ServicioSumarImplementacionService
    extends Service
{

    private final static URL SERVICIOSUMARIMPLEMENTACIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICIOSUMARIMPLEMENTACIONSERVICE_EXCEPTION;
    private final static QName SERVICIOSUMARIMPLEMENTACIONSERVICE_QNAME = new QName("http://beans/", "ServicioSumarImplementacionService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ServicioSumarImplementacionService/ServicioSumarImplementacion?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICIOSUMARIMPLEMENTACIONSERVICE_WSDL_LOCATION = url;
        SERVICIOSUMARIMPLEMENTACIONSERVICE_EXCEPTION = e;
    }

    public ServicioSumarImplementacionService() {
        super(__getWsdlLocation(), SERVICIOSUMARIMPLEMENTACIONSERVICE_QNAME);
    }

    public ServicioSumarImplementacionService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICIOSUMARIMPLEMENTACIONSERVICE_QNAME, features);
    }

    public ServicioSumarImplementacionService(URL wsdlLocation) {
        super(wsdlLocation, SERVICIOSUMARIMPLEMENTACIONSERVICE_QNAME);
    }

    public ServicioSumarImplementacionService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICIOSUMARIMPLEMENTACIONSERVICE_QNAME, features);
    }

    public ServicioSumarImplementacionService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioSumarImplementacionService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicioSumarWS
     */
    @WebEndpoint(name = "ServicioSumarImplementacionPort")
    public ServicioSumarWS getServicioSumarImplementacionPort() {
        return super.getPort(new QName("http://beans/", "ServicioSumarImplementacionPort"), ServicioSumarWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioSumarWS
     */
    @WebEndpoint(name = "ServicioSumarImplementacionPort")
    public ServicioSumarWS getServicioSumarImplementacionPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://beans/", "ServicioSumarImplementacionPort"), ServicioSumarWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICIOSUMARIMPLEMENTACIONSERVICE_EXCEPTION!= null) {
            throw SERVICIOSUMARIMPLEMENTACIONSERVICE_EXCEPTION;
        }
        return SERVICIOSUMARIMPLEMENTACIONSERVICE_WSDL_LOCATION;
    }

}
