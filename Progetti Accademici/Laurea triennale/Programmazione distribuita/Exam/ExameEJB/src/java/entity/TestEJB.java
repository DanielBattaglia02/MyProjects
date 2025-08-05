package entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@NamedQueries({
    @NamedQuery(name="CERCA_TUTTI", query="SELECT e FROM TestEJB e"),
    @NamedQuery(name="CERCA_PER_COGNOME", query="SELECT e FROM TestEJB e WHERE e.cognome=:cognome")
})

public class TestEJB implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cognome;
    private LocalDate data;
    private String voto;

    public TestEJB() {
    }

    public TestEJB(String nome, String cognome, LocalDate data, String voto) {
        this.nome = nome;
        this.cognome = cognome;
        this.data = data;
        this.voto = voto;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    @Override
    public String toString() {
        return "TestEJB{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", data=" + data + ", voto=" + voto + '}';
    }
}
