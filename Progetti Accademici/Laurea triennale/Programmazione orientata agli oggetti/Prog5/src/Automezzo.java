import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Automezzo
{
    protected String marca;
    protected String modello;
    protected int cavalli;
    protected String targa;
    private String stato;
    private GregorianCalendar dataPrestito;

    public Automezzo(String marca, String modello, int cavalli, String targa, String stato, GregorianCalendar dataPrestito) {
        this.marca = marca;
        this.modello = modello;
        this.cavalli = cavalli;
        this.targa = targa;
        this.stato = stato;
        this.dataPrestito = dataPrestito;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getCavalli() {
        return cavalli;
    }

    public void setCavalli(int cavalli) {
        this.cavalli = cavalli;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public GregorianCalendar getDataPrestito() {
        return dataPrestito;
    }

    public void setDataPrestito(GregorianCalendar dataPrestito)
    {
        this.dataPrestito = new GregorianCalendar(
                dataPrestito.get(Calendar.YEAR),
                dataPrestito.get(Calendar.MONTH),
                dataPrestito.get(Calendar.DAY_OF_MONTH)
        );
    }

    public void prestito(GregorianCalendar d)
    {
        if(getStato().equalsIgnoreCase("disponibile"))
        {
            setDataPrestito(d);
            setStato("prestato");
        }
    }

    @Override
    public String toString()
    {
        return "Automezzo{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", cavalli=" + cavalli +
                ", targa='" + targa + '\'' +
                ", stato='" + stato + '\'' +
                ", dataPrestito=" + dataPrestito +
                '}';
    }

    public long conteggioGiorni()
    {
        GregorianCalendar g = new GregorianCalendar();
        long g1 = g.getTimeInMillis();
        long g2 = dataPrestito.getTimeInMillis();
        long diff = g2-g1;
        long giorni = (long)(diff/(365.25*24*60*60*1000));

        return giorni;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automezzo automezzo = (Automezzo) o;
        return cavalli == automezzo.cavalli &&
                marca.equals(automezzo.marca) &&
                modello.equals(automezzo.modello) &&
                targa.equals(automezzo.targa) &&
                stato.equals(automezzo.stato) &&
                dataPrestito.get(Calendar.YEAR) == automezzo.dataPrestito.get(Calendar.YEAR) &&
                dataPrestito.get(Calendar.MONTH) == automezzo.dataPrestito.get(Calendar.MONTH) &&
                dataPrestito.get(Calendar.DAY_OF_MONTH) == automezzo.dataPrestito.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modello, cavalli, targa, stato, dataPrestito);
    }

    public abstract double reso();
}
