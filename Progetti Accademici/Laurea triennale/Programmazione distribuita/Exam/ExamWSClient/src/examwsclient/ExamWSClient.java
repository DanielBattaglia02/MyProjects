package examwsclient;

public class ExamWSClient {

    public static void main(String[] args) {
        // Chiamata al servizio web per diverse ID
        System.out.println(examForecast(1L));
        System.out.println(examForecast(2L));
        System.out.println(examForecast(3L));  
    }

    // Metodo che invoca l'operazione exam_forecast del servizio
    private static String examForecast(java.lang.Long id) {
        // Creazione del servizio e del port per la comunicazione con il servizio web
        examwsclient.ExamForecast_Service service = new examwsclient.ExamForecast_Service();
        examwsclient.ExamForecast port = service.getExamForecastPort();
        
        return port.examForecast(id);
    }
}
