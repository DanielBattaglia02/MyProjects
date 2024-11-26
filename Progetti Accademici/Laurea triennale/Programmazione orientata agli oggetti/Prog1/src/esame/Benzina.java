package esame;

public class Benzina extends Autovettura
{
    public Benzina(String nome, int numCavalli)
    {
        super(nome, numCavalli);
    }

    public double getTempoGiro(double km, int numeroCurve, int numeroRettilinei)
    {
        double result = 0.0;

        try
        {
            verificaStato(getStato());
            result = km*((double)(numeroCurve * 30 + numeroRettilinei * 30)/ getNumCavalli());
        }
        catch (AutoSpentaException exception)
        {
            System.out.println(exception);
            exception.printStackTrace();

            System.exit(1);
        }

        return result;
    }

}
