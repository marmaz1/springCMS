package pl.coderslab.springcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.springcms.domain.dao.ArticleDao;
import pl.coderslab.springcms.domain.model.Article;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomePageController {

    private final ArticleDao articleDao;

    @Autowired
    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/")
    public String lastArticles(Model model){
        List<Article> articles = articleDao.getLastCreatedArticles();
        model.addAttribute("articles",articles);

        return "home/home";

    }





}
