package pl.coderslab.springcms.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.springcms.domain.dao.CategoryDao;
import pl.coderslab.springcms.domain.model.Category;

public class CategoryConverter implements Converter<String, Category> {

    private CategoryDao categoryDao;

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public Category convert(String s) {
        Category category=categoryDao.findById(Long.parseLong(s));

        if ( category == null ){
            throw new IllegalStateException("brak takiej kategorii");
        }

        return category;
    }
}
