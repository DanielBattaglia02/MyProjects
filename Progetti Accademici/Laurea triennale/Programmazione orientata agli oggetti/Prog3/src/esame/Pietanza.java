package esame;

import java.util.List;
import java.util.Objects;

public abstract class Pietanza
{
    private String nome;
    private List<String> ingredienti;
    private double calorie;

    public Pietanza(String nome, List<String> ingredienti, double calorie)
    {
        this.nome = nome;
        this.ingredienti = ingredienti;
        this.calorie = calorie;
    }

    public String dammiNome()
    {
        return nome;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pietanza pietanza = (Pietanza) o;
        return Double.compare(calorie, pietanza.calorie) == 0 && Objects.equals(nome, pietanza.nome) && Objects.equals(ingredienti, pietanza.ingredienti);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIngredienti(List<String> ingredienti) {
        this.ingredienti = ingredienti;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    @Override
    public String toString() {
        return "Pietanza{" +
                "nome='" + nome + '\'' +
                ", ingredienti=" + ingredienti +
                ", calorie=" + calorie +
                '}';
    }

    public abstract double dammiCosto();
}
