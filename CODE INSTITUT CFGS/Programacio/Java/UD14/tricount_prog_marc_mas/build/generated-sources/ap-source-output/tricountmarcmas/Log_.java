package tricountmarcmas;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-05-09T10:48:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Log.class)
public class Log_ { 

    public static volatile SingularAttribute<Log, Date> datetime;
    public static volatile SingularAttribute<Log, String> newrow;
    public static volatile SingularAttribute<Log, String> oldrow;
    public static volatile SingularAttribute<Log, Integer> id;

}