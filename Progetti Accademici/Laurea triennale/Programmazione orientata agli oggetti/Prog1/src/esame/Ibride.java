package esame;

public class Ibride extends Autovettura
{
    public Ibride(String nome, int numCavalli)
    {
        super(nome, numCavalli);
    }

    public double getTempoGiro(double km, int numeroCurve, int numeroRettilinei)
    {
        double result = 0;

        try
        {
            verificaStato(getStato());
            result = km*((double)(numeroCurve * 20 + numeroRettilinei * 40)/ getNumCavalli());
        }
        catch (AutoSpentaException exception)
        {
            System.out.println(exception);
            exception.printStackTrace();
        }

        return result;
    }
}
