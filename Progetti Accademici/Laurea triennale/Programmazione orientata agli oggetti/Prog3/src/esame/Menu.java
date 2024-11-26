package esame;

import java.util.ArrayList;
import java.util.List;

public class Menu
{
    List<Pietanza> pietanze;

    public Menu()
    {
        pietanze = new ArrayList<>();
    }

    public void aggiungi(Pietanza p)
    {
        pietanze.add(p);
    }
}
