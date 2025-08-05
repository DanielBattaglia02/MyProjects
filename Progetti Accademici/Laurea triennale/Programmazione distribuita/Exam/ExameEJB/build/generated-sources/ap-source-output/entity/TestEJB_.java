package entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-15T02:19:13", comments="EclipseLink-4.0.5.v20241223-ra96b873527f305f932543045c8679bb1de8d3a43")
@StaticMetamodel(TestEJB.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class TestEJB_ { 

    public static volatile SingularAttribute<TestEJB, String> voto;
    public static volatile SingularAttribute<TestEJB, LocalDate> data;
    public static volatile SingularAttribute<TestEJB, String> cognome;
    public static volatile SingularAttribute<TestEJB, String> nome;
    public static volatile SingularAttribute<TestEJB, Long> id;

}