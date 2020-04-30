package pl.coderslab.springcms.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.springcms.domain.dao.AuthorDao;
import pl.coderslab.springcms.domain.model.Author;

public class AuthorConverter implements Converter<String, Author> {

    private AuthorDao authorDao;

    @Autowired
    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author convert(String s) {
        Author author=authorDao.finById(Long.parseLong(s));

        if( author == null ){
            throw new IllegalStateException("nieistniejacy autor");
        }
        return author;
    }
}
