package pl.coderslab.springcms.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String showAllAuthors(Model model) {
        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors", authors);

        return "authors/list";
    }

    @GetMapping("/add")
    public String addAuthorForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);

        return "authors/add";

    }

    @PostMapping("/add")
    public String processAddAuthorForm(Author author){
        authorDao.create(author);
        return "redirect:/authors";
    }





}
