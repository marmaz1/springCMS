package pl.coderslab.springcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springcms.domain.dao.ArticleDao;
import pl.coderslab.springcms.domain.model.Article;

import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleDao articleDao;
    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping
    public String showAllArticles(Model model){
        List<Article> articles = articleDao.findAll();
        model.addAttribute("articles",articles);
        return "articles/list";
    }





}
