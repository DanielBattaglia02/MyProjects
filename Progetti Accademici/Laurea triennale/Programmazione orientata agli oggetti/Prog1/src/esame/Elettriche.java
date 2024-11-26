package esame;

public class Elettriche extends Autovettura
{
    public Elettriche(String nome, int numCavalli)
    {
        super(nome, numCavalli);
    }

    public double getTempoGiro(double km, int numeroCurve, int numeroRettilinei)
    {
        double result = 0;

        try
        {
            verificaStato(getStato());
            result = km*((double)(numeroCurve * 15 + numeroRettilinei * 45)/ getNumCavalli());
        }
        catch (AutoSpentaException exception)
        {
            System.out.println(exception);
            exception.printStackTrace();
        }

        return result;
    }
}
