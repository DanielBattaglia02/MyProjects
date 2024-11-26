package esame;
public class AutoSpentaException extends Exception  //eccezione controllata
{
    public AutoSpentaException()
    {
        System.out.println("Errore: un'auto è spenta");
    }
}