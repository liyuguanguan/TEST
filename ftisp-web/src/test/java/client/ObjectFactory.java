
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReceivebyDecryption_QNAME = new QName("http://api.csp.ygjt.com/", "receivebyDecryption");
    private final static QName _ReceivebyDecryptionResponse_QNAME = new QName("http://api.csp.ygjt.com/", "receivebyDecryptionResponse");
    private final static QName _ReceiveOrderResponse_QNAME = new QName("http://api.csp.ygjt.com/", "receiveOrderResponse");
    private final static QName _ReceiveResponse_QNAME = new QName("http://api.csp.ygjt.com/", "receiveResponse");
    private final static QName _Receive_QNAME = new QName("http://api.csp.ygjt.com/", "receive");
    private final static QName _ReceiveOrder_QNAME = new QName("http://api.csp.ygjt.com/", "receiveOrder");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReceiveResponse }
     * 
     */
    public ReceiveResponse createReceiveResponse() {
        return new ReceiveResponse();
    }

    /**
     * Create an instance of {@link ReceiveOrderResponse }
     * 
     */
    public ReceiveOrderResponse createReceiveOrderResponse() {
        return new ReceiveOrderResponse();
    }

    /**
     * Create an instance of {@link ReceivebyDecryptionResponse }
     * 
     */
    public ReceivebyDecryptionResponse createReceivebyDecryptionResponse() {
        return new ReceivebyDecryptionResponse();
    }

    /**
     * Create an instance of {@link ReceivebyDecryption }
     * 
     */
    public ReceivebyDecryption createReceivebyDecryption() {
        return new ReceivebyDecryption();
    }

    /**
     * Create an instance of {@link ReceiveOrder }
     * 
     */
    public ReceiveOrder createReceiveOrder() {
        return new ReceiveOrder();
    }

    /**
     * Create an instance of {@link Receive }
     * 
     */
    public Receive createReceive() {
        return new Receive();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceivebyDecryption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.csp.ygjt.com/", name = "receivebyDecryption")
    public JAXBElement<ReceivebyDecryption> createReceivebyDecryption(ReceivebyDecryption value) {
        return new JAXBElement<ReceivebyDecryption>(_ReceivebyDecryption_QNAME, ReceivebyDecryption.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceivebyDecryptionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.csp.ygjt.com/", name = "receivebyDecryptionResponse")
    public JAXBElement<ReceivebyDecryptionResponse> createReceivebyDecryptionResponse(ReceivebyDecryptionResponse value) {
        return new JAXBElement<ReceivebyDecryptionResponse>(_ReceivebyDecryptionResponse_QNAME, ReceivebyDecryptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceiveOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.csp.ygjt.com/", name = "receiveOrderResponse")
    public JAXBElement<ReceiveOrderResponse> createReceiveOrderResponse(ReceiveOrderResponse value) {
        return new JAXBElement<ReceiveOrderResponse>(_ReceiveOrderResponse_QNAME, ReceiveOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceiveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.csp.ygjt.com/", name = "receiveResponse")
    public JAXBElement<ReceiveResponse> createReceiveResponse(ReceiveResponse value) {
        return new JAXBElement<ReceiveResponse>(_ReceiveResponse_QNAME, ReceiveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Receive }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.csp.ygjt.com/", name = "receive")
    public JAXBElement<Receive> createReceive(Receive value) {
        return new JAXBElement<Receive>(_Receive_QNAME, Receive.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceiveOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.csp.ygjt.com/", name = "receiveOrder")
    public JAXBElement<ReceiveOrder> createReceiveOrder(ReceiveOrder value) {
        return new JAXBElement<ReceiveOrder>(_ReceiveOrder_QNAME, ReceiveOrder.class, null, value);
    }

}
