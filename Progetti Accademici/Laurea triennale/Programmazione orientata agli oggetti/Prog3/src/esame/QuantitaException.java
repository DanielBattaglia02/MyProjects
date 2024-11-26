package esame;

public class QuantitaException extends RuntimeException
{
    public QuantitaException()
    {
        System.out.println("ERRORE:Quantità negativa");
    }
}
