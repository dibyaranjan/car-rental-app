package gcom.dr.carrental.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import gcom.dr.carrental.controller.POJO;
import gcom.dr.carrental.model.JsonRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarRentalServiceHttpMessageConverter extends AbstractHttpMessageConverter<JsonRequest> {
    private ObjectMapper mapper;
    private Map<Class<?>, Converter<Map<String, String>, JsonRequest>> converters;

    public CarRentalServiceHttpMessageConverter(ObjectMapper mapper,
                                                Map<Class<?>, Converter<Map<String, String>, JsonRequest>> converters) {
        this.converters = converters;
        this.mapper = mapper;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        List<MediaType> supportedMediaTypes = new ArrayList<>(super.getSupportedMediaTypes());
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        return Collections.unmodifiableList(supportedMediaTypes);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return converters.keySet().contains(clazz);
    }

    @Override
    protected JsonRequest readInternal(Class<? extends JsonRequest> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        MediaType contentType = inputMessage.getHeaders().getContentType();
        Charset charset = (contentType != null && contentType.getCharset() != null ?
                contentType.getCharset() : StandardCharsets.UTF_8);
        String body = StreamUtils.copyToString(inputMessage.getBody(), charset);
        LinkedHashMap<String, String> urlParameters = mapper.readValue(body, LinkedHashMap.class);
        Converter<Map<String, String>, JsonRequest> jsonRequestConverter = converters.get(clazz);
        return jsonRequestConverter.convert(urlParameters);
    }

    @Override
    protected void writeInternal(JsonRequest t, HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {
    }


//    private static final FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
//    private static final ObjectMapper mapper = new ObjectMapper();
//
//    @Override
//    protected boolean supports(Class<?> clazz) {
//        return (POJO.class == clazz);
//    }
//
//    @Override
//    public List<MediaType> getSupportedMediaTypes() {
//        List<MediaType> supportedMediaTypes = new ArrayList<>(super.getSupportedMediaTypes());
//        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        return supportedMediaTypes;
//    }
//
//    @Override
//    protected POJO readInternal(Class<? extends POJO> clazz, HttpInputMessage inputMessage) throws IOException,
//            HttpMessageNotReadableException {
//        //        Map<String, String> vals = formHttpMessageConverter.read(null, inputMessage).toSingleValueMap();
//
//        MediaType contentType = inputMessage.getHeaders().getContentType();
//        Charset charset = (contentType != null && contentType.getCharset() != null ?
//                contentType.getCharset() : StandardCharsets.UTF_8);
//        String body = StreamUtils.copyToString(inputMessage.getBody(), charset);
//        LinkedHashMap<String, String> urlParameters = mapper.readValue(body, LinkedHashMap.class);
//        POJO p = new POJO(urlParameters.get("name"));
//
//        return p;
//    }

}
