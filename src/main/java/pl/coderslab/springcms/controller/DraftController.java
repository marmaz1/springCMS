package pl.coderslab.springcms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springcms.domain.dao.ArticleDao;
import pl.coderslab.springcms.domain.model.Article;
import pl.coderslab.springcms.validations.groups.DraftValidationGroup;

import java.util.List;

@Controller
@RequestMapping("/drafts")
public class DraftController {

    private static final Logger log= LoggerFactory.getLogger(DraftController.class);

    private final ArticleDao articleDao;

    @Autowired
    public DraftController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping
    public String showDrafts(Model model){
        List<Article> drafts = articleDao.findAll();

        model.addAttribute("drafts",drafts);
        return "drafts/list";
    }

    @GetMapping("/add")
    public String addDraftForm(Model model){
        Article draft=new Article();
        model.addAttribute("draft",draft);
        return "drafts/add";
    }

    @PostMapping("/add")
    public String processAddDraftForm(@Validated(DraftValidationGroup.class) @ModelAttribute("draft") Article article, BindingResult result){

        if(result.hasErrors()){
            log.warn("bledne dane dodawania szkicu");
            return "drafts/add";
        }

        articleDao.create(article);
        return "redirect:/drafts";
    }



}
