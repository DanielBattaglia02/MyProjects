package esame;

import java.util.List;
import java.util.Objects;

public class PietanzaCalda extends Pietanza
{
    private int tempoC;  //tempo cottura minuti
    private double peso;
    public PietanzaCalda(String nome, List<String> ingredienti, double calorie, double peso, int tempoC)
    {
        super(nome, ingredienti, calorie);
        this.peso = peso;   //in grammi
        this.tempoC = tempoC;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PietanzaCalda that = (PietanzaCalda) o;
        return super.equals(o) && Double.compare(tempoC, that.tempoC) == 0 && Double.compare(peso, that.peso) == 0;
    }

    @Override
    public double dammiCosto()      /*40euro al Kg*/
    {
        double result = 40*(peso/1000);

        return result;
    }

    public int getTempoC() {
        return tempoC;
    }

    public double getPeso() {
        return peso;
    }

    public void setTempoC(int tempoC) {
        this.tempoC = tempoC;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return super.toString() + " PietanzaCalda{" +
                "tempoC=" + tempoC +
                ", peso=" + peso +
                '}';
    }
}
