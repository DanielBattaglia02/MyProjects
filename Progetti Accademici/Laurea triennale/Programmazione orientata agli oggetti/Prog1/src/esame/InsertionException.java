package esame;

public class InsertionException extends RuntimeException    //eccezione non controllata
{
    public InsertionException()
    {
        System.out.println("Errore: è già stata inserita questa autovettura");
    }
}
