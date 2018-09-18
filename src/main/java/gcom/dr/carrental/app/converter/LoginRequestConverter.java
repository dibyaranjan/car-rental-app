package gcom.dr.carrental.app.converter;

import gcom.dr.carrental.controller.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LoginRequestConverter implements Converter<String, User> {
    @Override
    public User convert(String o) {

        return User.createInstance(null, null);
    }
}
