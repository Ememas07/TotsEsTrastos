package Usuaris;

import Usuaris.Grup;
import Usuaris.Pagador;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tricountmarcmas.Despesa;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-05-09T10:48:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Usuari.class)
public class Usuari_ { 

    public static volatile ListAttribute<Usuari, Grup> grupList;
    public static volatile SingularAttribute<Usuari, String> llinatge2;
    public static volatile SingularAttribute<Usuari, String> llinatge1;
    public static volatile SingularAttribute<Usuari, String> iban;
    public static volatile SingularAttribute<Usuari, String> alias;
    public static volatile ListAttribute<Usuari, Pagador> pagadorList;
    public static volatile SingularAttribute<Usuari, String> correu;
    public static volatile SingularAttribute<Usuari, String> nom;
    public static volatile ListAttribute<Usuari, Despesa> despesaList;

}