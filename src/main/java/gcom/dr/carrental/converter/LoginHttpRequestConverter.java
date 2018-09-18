package gcom.dr.carrental.converter;

import gcom.dr.carrental.controller.model.User;
import gcom.dr.carrental.model.JsonRequest;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Order(1)
public class LoginHttpRequestConverter extends AbstractHttpRequestConverter<Map<String, String>, JsonRequest> {
    @Override
    public JsonRequest convert(Map<String, String> requestKeyValue) {
        return User.createInstance(requestKeyValue.get("userName"), requestKeyValue.get("password"));
    }

    @Override
    public Class<?> getSupportingClass() {
        return User.class;
    }
}
