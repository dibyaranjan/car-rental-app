package gcom.dr.carrental.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import gcom.dr.carrental.converter.AbstractHttpRequestConverter;
import gcom.dr.carrental.model.JsonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class JacksonConverters {

    @Autowired
    private List<AbstractHttpRequestConverter<Map<String, String>, JsonRequest>> requestConverters;

    @Bean
    public WebMvcConfigurer testing() {
        //WebMvcConfigurer
        return new WebMvcConfigurerAdapter() {
            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                Map<Class<?>, Converter<Map<String, String>, JsonRequest>> converterMap = new LinkedHashMap<>();
                requestConverters.forEach(converter -> {
                    converterMap.put(converter.getSupportingClass(), converter);
                });

                CarRentalServiceHttpMessageConverter slackSlashCommandConverter =
                        new CarRentalServiceHttpMessageConverter(new ObjectMapper(), converterMap);
                MediaType mediaType = new MediaType("application","x-www-form-urlencoded", Charset.forName("UTF-8"));
                slackSlashCommandConverter.setSupportedMediaTypes(Arrays.asList(mediaType));
                converters.set(1, slackSlashCommandConverter);
            }
        };
    }
}
