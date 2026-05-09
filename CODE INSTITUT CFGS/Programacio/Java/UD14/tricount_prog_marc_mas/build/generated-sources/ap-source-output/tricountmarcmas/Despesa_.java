package tricountmarcmas;

import Usuaris.Grup;
import Usuaris.Pagador;
import Usuaris.Usuari;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-05-09T10:48:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Despesa.class)
public class Despesa_ { 

    public static volatile SingularAttribute<Despesa, Double> importpagat;
    public static volatile SingularAttribute<Despesa, Date> datadespesa;
    public static volatile SingularAttribute<Despesa, Usuari> pagadororiginal;
    public static volatile SingularAttribute<Despesa, String> descripcio;
    public static volatile SingularAttribute<Despesa, String> categoria;
    public static volatile ListAttribute<Despesa, Pagador> pagadorList;
    public static volatile SingularAttribute<Despesa, Integer> id;
    public static volatile SingularAttribute<Despesa, Double> importtotal;
    public static volatile SingularAttribute<Despesa, Grup> idgrup;

}