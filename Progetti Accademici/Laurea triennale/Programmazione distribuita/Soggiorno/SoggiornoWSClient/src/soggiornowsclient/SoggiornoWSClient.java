//http://localhost:8080/SoggiornoForecast/SoggiornoForecast?tester
//http://localhost:8080/SoggiornoForecast/SoggiornoForecast?WSDL

package soggiornowsclient;

public class SoggiornoWSClient {

    public static void main(String[] args) 
    {
        Long id = 1L;
        System.out.println("Destinazione: " + getDestinazione(id));
        System.out.println("Data Partenza: " + getDataPartenza(id));

        id = 2L;
        System.out.println("Destinazione: " + getDestinazione(id));
        System.out.println("Data Partenza: " + getDataPartenza(id));

        id = 3L;
        System.out.println("Destinazione: " + getDestinazione(id));
        System.out.println("Data Partenza: " + getDataPartenza(id));
    }

    // Metodo per ottenere solo la Destinazione
    private static String getDestinazione(java.lang.Long id) 
    {
        soggiornowsclient.SoggiornoForecast_Service service = new soggiornowsclient.SoggiornoForecast_Service();
        soggiornowsclient.SoggiornoForecast port = service.getSoggiornoForecastPort();
        
        return port.getDestinazione(id);
    }

    // Metodo per ottenere solo la Data di Partenza
    private static String getDataPartenza(java.lang.Long id) 
    {
        soggiornowsclient.SoggiornoForecast_Service service = new soggiornowsclient.SoggiornoForecast_Service();
        soggiornowsclient.SoggiornoForecast port = service.getSoggiornoForecastPort();
        
        return port.getDataPartenza(id);
    }
}