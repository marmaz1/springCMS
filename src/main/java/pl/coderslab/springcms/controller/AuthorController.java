package pl.coderslab.springcms.controller;

import org.dom4j.rule.Mode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.springcms.domain.dao.AuthorDao;
import pl.coderslab.springcms.domain.model.Author;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private static final Logger log= LoggerFactory.getLogger(AuthorController.class);

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
    public String processAddAuthorForm(@Valid Author author, BindingResult result) {

        if(result.hasErrors()){
            log.warn("bledne dane dodawania autora");
            return "authors/add";
        }

        authorDao.create(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit")
    public String editAuthorForm(@RequestParam Long id, Model model) {
        Author author = authorDao.finById(id);
        if ( author == null ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("author",author);
        return "authors/edit";
    }

    @PostMapping("/edit")
    public String processEditAuthorForm(@Valid Author author, BindingResult result){

        if(result.hasErrors()){
            log.warn("bledne dane edycji autora");
            return "authors/edit";
        }

        Author originalAuthor=authorDao.finById(author.getId());
        originalAuthor.setFirstName(author.getFirstName());
        originalAuthor.setLastName(author.getLastName());


        authorDao.update(originalAuthor);
        return "redirect:/authors";
    }

    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam Long id){
        Author author=authorDao.finById(id);
        authorDao.delete(author);
        return "redirect:/authors";
    }

}
