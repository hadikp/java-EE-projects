package canban.squad;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.PersistenceContext;

@Singleton
public class SquadService {

    @PersistenceContext
    private EntityManager em;
}
