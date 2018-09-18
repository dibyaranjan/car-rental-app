package gcom.dr.carrental.converter;

import gcom.dr.carrental.controller.POJO;
import gcom.dr.carrental.model.JsonRequest;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Order(2)
public class PojoHttpRequestConverter extends AbstractHttpRequestConverter<Map<String, String>, JsonRequest> {
    @Override
    public JsonRequest convert(Map<String, String> requestKeyValue) {
        return new POJO(requestKeyValue.get("name"));
    }

    @Override
    public Class<?> getSupportingClass() {
        return POJO.class;
    }
}
