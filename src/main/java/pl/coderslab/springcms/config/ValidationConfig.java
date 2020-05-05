package pl.coderslab.springcms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@Configuration
public class ValidationConfig {

    @Bean
    public Validator validator(){
        LocalValidatorFactoryBean localValidatorFactoryBean=new LocalValidatorFactoryBean();
        return localValidatorFactoryBean;
    }

}
