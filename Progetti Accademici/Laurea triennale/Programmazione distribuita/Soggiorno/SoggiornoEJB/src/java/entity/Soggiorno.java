package entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@NamedQueries({
    @NamedQuery(name="CERCA_PER_DESTINAZIONE", query="SELECT s FROM Soggiorno s WHERE s.destinazione=:destinazione"),
    @NamedQuery(name="CERCA_PAGATI", query="SELECT s FROM Soggiorno s WHERE s.stato='PAGATO'"),
    @NamedQuery(name="CERCA_PER_ID", query="SELECT s FROM Soggiorno s WHERE s.id=:id"),
    @NamedQuery(name="RIMUOVI_SOGGIORNO", query="DELETE FROM Soggiorno s WHERE s.destinazione=:destinazione"),
    @NamedQuery(name="MODIFICA_SOGGIORNO", query="UPDATE Soggiorno s SET s.stato=:stato WHERE s.id=:id")
})
public class Soggiorno implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nomeClient;
    private String destinazione;
    private LocalDate dataPartenza;
    private LocalDate dataArrivo;
    private int durata;
    private String stato;

    public Soggiorno() {
    }

    public Soggiorno(String nomeClient, String destinazione, LocalDate dataPartenza, LocalDate dataArrivo, String stato) {
        this.nomeClient = nomeClient;
        this.destinazione = destinazione;
        this.dataPartenza = dataPartenza;
        this.dataArrivo = dataArrivo;
        this.stato = stato;
        this.durata = calcolaDurata(); // Calcolo automatico della durata
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeClient() {
        return nomeClient;
    }

    public void setNomeClient(String nomeClient) {
        this.nomeClient = nomeClient;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getDataPartenza() {
        return dataPartenza;
    }

    public void setDataPartenza(LocalDate dataPartenza) {
        this.dataPartenza = dataPartenza;
        aggiornaDurata();
    }

    public LocalDate getDataArrivo() {
        return dataArrivo;
    }

    public void setDataArrivo(LocalDate dataArrivo) {
        this.dataArrivo = dataArrivo;
        aggiornaDurata();
    }

    public int getDurata() {
        return durata;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    private int calcolaDurata() {
        if (dataPartenza != null && dataArrivo != null) {
            return (int) ChronoUnit.DAYS.between(dataPartenza, dataArrivo);
        }
        return 0;
    }

    private void aggiornaDurata() {
        this.durata = calcolaDurata();
    }

    @Override
    public String toString() {
        return "Soggiorno{" + "id=" + id + ", nomeClient=" + nomeClient + ", destinazione=" + destinazione + 
               ", dataPartenza=" + dataPartenza + ", dataArrivo=" + dataArrivo + ", durata=" + durata + 
               ", stato=" + stato + '}';
    }
}
