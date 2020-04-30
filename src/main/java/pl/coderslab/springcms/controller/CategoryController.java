package pl.coderslab.springcms.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.springcms.domain.dao.CategoryDao;
import pl.coderslab.springcms.domain.model.Category;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryDao categoryDao;
    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping
    public String showAllCategories(Model model){
        List<Category> categories = categoryDao.findAll();
        model.addAttribute("categories", categories);
        return "categories/list";

    }

    @GetMapping("/add")
    public String addCategoryForm(Model model){
        Category category=new Category();
        model.addAttribute("category", category);
        return "categories/add";
    }

    @PostMapping("/add")
    public String processAddCategoryForm(Category category){
        categoryDao.create(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit")
    public String editCategoryForm(@RequestParam Long id, Model model){
        Category category=categoryDao.findById(id);

        if(category == null ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        model.addAttribute("category", category);
        return "categories/edit";
    }

    @PostMapping("/edit")
    public String processEditCategoryForm(Category category){
        categoryDao.update(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete")
    public String deleteCategory(@RequestParam Long id) {
        Category category=categoryDao.findById(id);
        categoryDao.delete(category);
        return "redirect:/categories";
    }


}
