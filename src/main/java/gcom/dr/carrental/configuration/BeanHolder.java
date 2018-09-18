package gcom.dr.carrental.configuration;

import gcom.dr.carrental.controller.validator.UserValidator;
import gcom.dr.carrental.controller.validator.UserValidatorImpl;
import gcom.dr.carrental.dao.UserDao;
import gcom.dr.carrental.dao.UserDetailsDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class BeanHolder {
    private String fileName;

    @Bean
    public UserValidator offlineUserValidator(UserDao userDao) throws IOException {
        UserValidatorImpl userValidator = new UserValidatorImpl();
        userValidator.setUserDao(userDao);
        return userValidator;
    }

    @Bean
    public UserDao userDao() {
        return new UserDetailsDao();
    }
}
