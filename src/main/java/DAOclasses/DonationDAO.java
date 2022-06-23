package DAOclasses;

import Classes.Donation;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class DonationDAO {
    @PersistenceContext
    EntityManager entityManager;
    public List<Donation> findalldonation(){
        Query query = entityManager.createQuery("SELECT d FROM Donation d");
        return query.getResultList();
    }
    public int numberofquantity(){
        Query query = entityManager.createQuery("SELECT sum(d.quantity) FROM Donation d");
        List<Integer> sum=query.getResultList();
        return sum.get(0);
    }
    public int numberodonation(){
        Query query = entityManager.createQuery("SELECT count (d.id) FROM Donation d");
        List<Integer> sum=query.getResultList();
        return sum.get(0);
    }
}
