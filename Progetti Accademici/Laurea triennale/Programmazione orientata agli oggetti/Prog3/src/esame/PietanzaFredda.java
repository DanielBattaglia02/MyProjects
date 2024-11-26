package esame;

import java.util.List;
import java.util.Objects;

public class PietanzaFredda extends Pietanza
{
    private String tipo;    //antipasto o dolce
    public PietanzaFredda(String nome, List<String> ingredienti, double calorie, String tipo)
    {
        super(nome, ingredienti, calorie);
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PietanzaFredda that = (PietanzaFredda) o;
        return Objects.equals(tipo, that.tipo);
    }

    @Override
    public double dammiCosto()
    {
        double result;

        if(tipo.equals("antipasto"))
        {
            result = 8;
        }
        else
        {
             result = 6;
        }

        return result;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString()
    {
        return super.toString() + " PietanzaFredda{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
