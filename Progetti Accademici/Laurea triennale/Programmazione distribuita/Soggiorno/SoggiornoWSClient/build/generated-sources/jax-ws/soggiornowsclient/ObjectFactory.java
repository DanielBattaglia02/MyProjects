
package soggiornowsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soggiornowsclient package. 
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

    private final static QName _GetDataPartenza_QNAME = new QName("http://soggiorno/", "getDataPartenza");
    private final static QName _GetDataPartenzaResponse_QNAME = new QName("http://soggiorno/", "getDataPartenzaResponse");
    private final static QName _GetDestinazione_QNAME = new QName("http://soggiorno/", "getDestinazione");
    private final static QName _GetDestinazioneResponse_QNAME = new QName("http://soggiorno/", "getDestinazioneResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soggiornowsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDataPartenza }
     * 
     */
    public GetDataPartenza createGetDataPartenza() {
        return new GetDataPartenza();
    }

    /**
     * Create an instance of {@link GetDataPartenzaResponse }
     * 
     */
    public GetDataPartenzaResponse createGetDataPartenzaResponse() {
        return new GetDataPartenzaResponse();
    }

    /**
     * Create an instance of {@link GetDestinazione }
     * 
     */
    public GetDestinazione createGetDestinazione() {
        return new GetDestinazione();
    }

    /**
     * Create an instance of {@link GetDestinazioneResponse }
     * 
     */
    public GetDestinazioneResponse createGetDestinazioneResponse() {
        return new GetDestinazioneResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataPartenza }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDataPartenza }{@code >}
     */
    @XmlElementDecl(namespace = "http://soggiorno/", name = "getDataPartenza")
    public JAXBElement<GetDataPartenza> createGetDataPartenza(GetDataPartenza value) {
        return new JAXBElement<GetDataPartenza>(_GetDataPartenza_QNAME, GetDataPartenza.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataPartenzaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDataPartenzaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soggiorno/", name = "getDataPartenzaResponse")
    public JAXBElement<GetDataPartenzaResponse> createGetDataPartenzaResponse(GetDataPartenzaResponse value) {
        return new JAXBElement<GetDataPartenzaResponse>(_GetDataPartenzaResponse_QNAME, GetDataPartenzaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDestinazione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDestinazione }{@code >}
     */
    @XmlElementDecl(namespace = "http://soggiorno/", name = "getDestinazione")
    public JAXBElement<GetDestinazione> createGetDestinazione(GetDestinazione value) {
        return new JAXBElement<GetDestinazione>(_GetDestinazione_QNAME, GetDestinazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDestinazioneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDestinazioneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soggiorno/", name = "getDestinazioneResponse")
    public JAXBElement<GetDestinazioneResponse> createGetDestinazioneResponse(GetDestinazioneResponse value) {
        return new JAXBElement<GetDestinazioneResponse>(_GetDestinazioneResponse_QNAME, GetDestinazioneResponse.class, null, value);
    }

}
