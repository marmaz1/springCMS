package pl.coderslab.springcms.domain.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.springcms.domain.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Category category){
        entityManager.persist(category);
    }

    public void update(Category category){
        entityManager.merge(category);
    }

    public void delete(Category category){
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }


    


}
