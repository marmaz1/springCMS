package pl.coderslab.springcms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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

    @GetMapping("/edit")
    public String editDraftForm(@RequestParam Long id, Model model){
        Article draft=articleDao.findById(id);

        if(draft == null){
          throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("draft",draft);
        return "drafts/edit";
    }

    @PostMapping("/edit")
    public String processEditDraftForm( @Validated(DraftValidationGroup.class) @ModelAttribute("draft") Article article, BindingResult result){

        if(result.hasErrors()){
            log.warn("bledne dane edycji szkicu");
            return "drafts/add";
        }

        Article originalDraft=articleDao.findById(article.getId());
        originalDraft.setTitle(article.getTitle());
        originalDraft.setContent(article.getContent());
        articleDao.update(originalDraft);

        return "redirect:/drafts";

    }

    @GetMapping("/delete")
    public String deleteDraft(@RequestParam Long id){
        Article draft=articleDao.findById(id);
        articleDao.delete(draft);
        return "redirect:/drafts";
    }


}
