package pl.coderslab.springcms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.springcms.converters.AuthorConverter;
import pl.coderslab.springcms.converters.CategoryConverter;
import pl.coderslab.springcms.domain.model.Category;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public AuthorConverter authorConverter(){
        return new AuthorConverter();
    }

    @Bean
    public CategoryConverter categoryConverter(){
        return new CategoryConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(authorConverter());
        registry.addConverter(categoryConverter());
    }
}
