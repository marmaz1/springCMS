package pl.coderslab.springcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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




}
