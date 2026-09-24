package Usuaris;

import Usuaris.Usuari;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tricountmarcmas.Despesa;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-05-09T10:48:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pagador.class)
public class Pagador_ { 

    public static volatile SingularAttribute<Pagador, Usuari> idusuari;
    public static volatile SingularAttribute<Pagador, Despesa> iddespesa;
    public static volatile SingularAttribute<Pagador, Double> contribucio;
    public static volatile SingularAttribute<Pagador, Boolean> hapagat;
    public static volatile SingularAttribute<Pagador, Integer> id;

}