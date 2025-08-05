package soggiorno;

import entity.Soggiorno;
import jakarta.ejb.EJB;
import jakarta.jws.*;
import jakarta.ejb.Stateless;

@WebService(serviceName = "SoggiornoForecast")
@Stateless()
public class SoggiornoForecast {

    @EJB
    private SoggiornoBean sb;

    /*Metodo per restituire solo la Destinazione*/
    @WebMethod(operationName = "getDestinazione")
    public String getDestinazione(@WebParam(name = "forecast_id") Long id) {
        Soggiorno soggiorno = sb.cercaPerId(id);
        if (soggiorno != null) {
            return soggiorno.getDestinazione();
        }
        return null;
    }

    /*Metodo per restituire solo la Data di Partenza*/
    @WebMethod(operationName = "getDataPartenza")
    public String getDataPartenza(@WebParam(name = "forecast_id") Long id) {
        Soggiorno soggiorno = sb.cercaPerId(id);
        if (soggiorno != null) {
            return soggiorno.getDataPartenza().toString();
        }
        return null;
    }
}
