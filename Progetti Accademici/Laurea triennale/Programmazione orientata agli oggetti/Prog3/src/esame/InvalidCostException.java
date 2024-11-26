package esame;

public class InvalidCostException extends Exception
{
    public InvalidCostException()
    {
        System.out.println("ERRORE: ci sono ancora ordinazioni non servite");
    }
}
