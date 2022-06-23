package DAOclasses;

import Classes.Category;
import Classes.Donation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDAO {
    @PersistenceContext
    EntityManager entityManager;
    public List<Category> findallcategory(){
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }
}
