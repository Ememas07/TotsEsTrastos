package Usuaris;

import Usuaris.Usuari;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tricountmarcmas.Despesa;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-05-09T10:48:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Grup.class)
public class Grup_ { 

    public static volatile SingularAttribute<Grup, String> descripcio;
    public static volatile ListAttribute<Grup, Usuari> usuariList;
    public static volatile SingularAttribute<Grup, Date> datacreacio;
    public static volatile SingularAttribute<Grup, Integer> id;
    public static volatile ListAttribute<Grup, Despesa> despesaList;

}