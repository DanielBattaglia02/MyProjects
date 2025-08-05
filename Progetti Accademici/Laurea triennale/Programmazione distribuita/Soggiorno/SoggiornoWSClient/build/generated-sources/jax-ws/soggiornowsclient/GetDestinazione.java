
package soggiornowsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per getDestinazione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="getDestinazione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="forecast_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDestinazione", propOrder = {
    "forecastId"
})
public class GetDestinazione {

    @XmlElement(name = "forecast_id")
    protected Long forecastId;

    /**
     * Recupera il valore della proprietà forecastId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getForecastId() {
        return forecastId;
    }

    /**
     * Imposta il valore della proprietà forecastId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setForecastId(Long value) {
        this.forecastId = value;
    }

}
