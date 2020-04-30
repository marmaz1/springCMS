package pl.coderslab.springcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springcms.domain.dao.AuthorDao;
import pl.coderslab.springcms.domain.model.Author;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;
    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping
    public String showAllAuthors(Model model){
        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors",authors);

        return "authors/list";
    }



}
