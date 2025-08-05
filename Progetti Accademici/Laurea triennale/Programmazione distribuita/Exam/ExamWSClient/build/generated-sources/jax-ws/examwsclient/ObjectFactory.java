
package examwsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the examwsclient package. 
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

    private final static QName _ExamForecast_QNAME = new QName("http://exam/", "exam_forecast");
    private final static QName _ExamForecastResponse_QNAME = new QName("http://exam/", "exam_forecastResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: examwsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExamForecast_Type }
     * 
     */
    public ExamForecast_Type createExamForecast_Type() {
        return new ExamForecast_Type();
    }

    /**
     * Create an instance of {@link ExamForecastResponse }
     * 
     */
    public ExamForecastResponse createExamForecastResponse() {
        return new ExamForecastResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExamForecast_Type }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExamForecast_Type }{@code >}
     */
    @XmlElementDecl(namespace = "http://exam/", name = "exam_forecast")
    public JAXBElement<ExamForecast_Type> createExamForecast(ExamForecast_Type value) {
        return new JAXBElement<ExamForecast_Type>(_ExamForecast_QNAME, ExamForecast_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExamForecastResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExamForecastResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://exam/", name = "exam_forecastResponse")
    public JAXBElement<ExamForecastResponse> createExamForecastResponse(ExamForecastResponse value) {
        return new JAXBElement<ExamForecastResponse>(_ExamForecastResponse_QNAME, ExamForecastResponse.class, null, value);
    }

}
