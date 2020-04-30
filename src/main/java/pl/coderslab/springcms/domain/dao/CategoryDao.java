package pl.coderslab.springcms.domain.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.springcms.domain.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Category category){
        entityManager.persist(category);
    }

    public Category findById(Long id){
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll(){
        TypedQuery query=entityManager.createQuery("SELECT c FROM Category c",Category.class);
        List<Category> categories=query.getResultList();
        return categories;
    }

    public void update(Category category){
        entityManager.merge(category);
    }

    public void delete(Category category){
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }





}
