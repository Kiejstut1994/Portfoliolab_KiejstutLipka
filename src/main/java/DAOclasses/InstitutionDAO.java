package DAOclasses;

import Classes.Donation;
import Classes.Institution;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class InstitutionDAO {
    @PersistenceContext
    EntityManager entityManager;
    public List<Institution> findallinstitution(){
        Query query = entityManager.createQuery("SELECT i FROM Institution i");
        return query.getResultList();
    }

}
