package gcom.dr.carrental.converter;

import gcom.dr.carrental.model.JsonRequest;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;

public abstract class AbstractHttpRequestConverter<S, T> implements Converter<S, T> {
    public abstract Class<?> getSupportingClass();
}
