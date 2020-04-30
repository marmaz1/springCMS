package pl.coderslab.springcms.domain.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.springcms.domain.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Article article){
        entityManager.persist(article);
    }

    public void update(Article article){
        entityManager.merge(article);
    }

    public Article findById(Long id){
       return entityManager.find(Article.class,id);
    }

    public List<Article> findAll(){
        TypedQuery <Article> query=entityManager.createQuery("SELECT a FROM Article a LEFT JOIN FETCH a.categories",Article.class);
        List<Article> articles=query.getResultList();

        return articles;
    }

    public List<Article> getLastCreatedArticles(){
        TypedQuery <Article> query=entityManager.createQuery("Select a FROM Article a left join fetch a.categories order by a.created DESC ",Article.class);
        List<Article> articles = query.setMaxResults(5).getResultList();

        return articles;
    }



    public void delete(Article article){
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }





}
