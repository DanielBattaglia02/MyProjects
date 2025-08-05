package entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-20T09:49:12", comments="EclipseLink-4.0.5.v20241223-ra96b873527f305f932543045c8679bb1de8d3a43")
@StaticMetamodel(Soggiorno.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Soggiorno_ { 

    public static volatile SingularAttribute<Soggiorno, String> stato;
    public static volatile SingularAttribute<Soggiorno, LocalDate> dataArrivo;
    public static volatile SingularAttribute<Soggiorno, Integer> durata;
    public static volatile SingularAttribute<Soggiorno, Long> id;
    public static volatile SingularAttribute<Soggiorno, String> destinazione;
    public static volatile SingularAttribute<Soggiorno, LocalDate> dataPartenza;
    public static volatile SingularAttribute<Soggiorno, String> nomeClient;

}