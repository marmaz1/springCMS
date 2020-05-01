package pl.coderslab.springcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.springcms.domain.dao.ArticleDao;
import pl.coderslab.springcms.domain.dao.AuthorDao;
import pl.coderslab.springcms.domain.dao.CategoryDao;
import pl.coderslab.springcms.domain.model.Article;
import pl.coderslab.springcms.domain.model.Author;
import pl.coderslab.springcms.domain.model.Category;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    @Autowired
    public ArticleController(ArticleDao articleDao,AuthorDao authorDao,CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao=authorDao;
        this.categoryDao=categoryDao;

    }

    @ModelAttribute("authors")
    public List<Author> authors(){
        List<Author> authors = authorDao.findAll();
        return authors;
    }
    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryDao.findAll();
    }

    @GetMapping
    public String showAllArticles(Model model){
        List<Article> articles = articleDao.findAll();
        model.addAttribute("articles",articles);
        return "articles/list";
    }

    @GetMapping("/add")
    public String addArticleForm(Model model){
        Article article = new Article();
        model.addAttribute("article",article);
        return "articles/add";
    }

    @PostMapping("/add")
    public String processAddArticleForm(Article article){
        articleDao.create(article);
        return "redirect:/articles";
    }

    @GetMapping("/edit")
    public String editArticleForm(@RequestParam Long id, Model model){
        Article article=articleDao.findById(id);

        if( article == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("article",article);
        return "articles/edit";
    }

    @PostMapping("/edit")
    public String processEditArticleForm(Article article){
        Article originalArticle=articleDao.findById(article.getId());
        originalArticle.setTitle(article.getTitle());
        originalArticle.setContent(article.getContent());
        originalArticle.setAuthor(article.getAuthor());
        originalArticle.setCategories(article.getCategories());
        
        articleDao.update(originalArticle);

        return "redirect:/articles";
    }

    @GetMapping("/delete")
    public String deleteArticle(@RequestParam Long id){
        Article article=articleDao.findById(id);
        articleDao.delete(article);
        return "redirect:/articles";
    }



}
