package exam;

import entity.TestEJB;
import jakarta.ejb.EJB;
import jakarta.jws.*;
import jakarta.ejb.Stateless;

@WebService(serviceName = "ExamForecast")
@Stateless()
public class ExamForecast 
{
    @EJB
    private ExamBean examBean;
    
    @WebMethod(operationName = "exam_forecast")
    public String forecast(@WebParam(name = "forecast_id") Long id) 
    {
        return examBean.cercaPerId(id).toString();
    }
}
