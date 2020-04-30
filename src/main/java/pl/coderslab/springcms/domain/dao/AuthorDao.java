package pl.coderslab.springcms.domain.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.springcms.domain.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Author author){
        entityManager.persist(author);
    }

    public Author finById(Long id){
        return entityManager.find(Author.class, id);
    }

    public List<Author> findAll(){
        TypedQuery query=entityManager.createQuery("SELECT a FROM Author  a", Author.class);
        List<Author> authors=query.getResultList();
        return authors;
    }

    public void update(Author author){
        entityManager.merge(author);
    }

    public void delete(Author author){
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }



}
