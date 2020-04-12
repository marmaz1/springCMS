package pl.coderslab.springcms.domain.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.springcms.domain.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Author author){
        entityManager.persist(author);
    }

    public void update(Author author){
        entityManager.merge(author);
    }

    public void delete(Author author){
        entityManager.remove(entityManager.contains(author) ? author : entityManager.contains(author));
    }



}
