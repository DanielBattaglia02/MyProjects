package esame;

import java.util.ArrayList;
import java.util.List;

public class Ristorante
{
    private Menu menu;
    private List<Ordinazione> ordinazioni;

    public Ristorante(Menu menu)
    {
        this.menu = menu;
        this.ordinazioni = new ArrayList<>();
    }

    public Menu getMenu() {
        return menu;
    }

    public List<Ordinazione> getOrdinazioni()
    {
        return ordinazioni;
    }

    public void aggiungi(Ordinazione ordinazione)
    {
        this.ordinazioni.add(ordinazione);
    }

    public void modifica(Ordinazione ordinazione, Ordinazione ordinazioneNuova)
    {
        for(int i=0; i<ordinazioni.size(); i++)
        {
            if(ordinazioni.get(i).equals(ordinazione))
            {
                ordinazioni.set(i, ordinazioneNuova);
            }
        }

    }
/*
    public void remove(Ordinazione ordinazione)
    {
        for(int i=0; i<ordinazioni.size(); i++)
        {
            for(int i=0; i<ordinazioni.size(); i++)
            {
                if(ordinazioni.get(i).equals(ordinazione))
                {
                    ordinazioni.remove(i);
                }
            }
        }
    }
    */


}
