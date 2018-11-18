package com.mycompany.demo.json.test.gson;

import com.google.gson.GsonBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class GsonRestTemplate {
    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
            configure(restTemplate);
        }
        return restTemplate;
    }

    private void configure(RestTemplate restTemplate) {
        getGsonConverter(restTemplate) //
                .orElse(new GsonHttpMessageConverter()) //
                .setGson(new GsonBuilder().create());
        if (restTemplate.getRequestFactory() instanceof SimpleClientHttpRequestFactory) {
            SimpleClientHttpRequestFactory requestFactory = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
            requestFactory.setReadTimeout(20 * 1000); // 20 seconds
            requestFactory.setConnectTimeout(20 * 1000); // 20 seconds
        } else if (restTemplate.getRequestFactory() instanceof HttpComponentsClientHttpRequestFactory) {
            HttpComponentsClientHttpRequestFactory requestFactory = (HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory();
            requestFactory.setReadTimeout(20 * 1000); // 20 seconds
            requestFactory.setConnectTimeout(20 * 1000); // 20 seconds
        }
    }

    private Optional<GsonHttpMessageConverter> getGsonConverter(RestTemplate restTemplate) {
        for (HttpMessageConverter<?> converter : restTemplate.getMessageConverters()) {
            if (GsonHttpMessageConverter.class.isAssignableFrom(converter.getClass())) {
                return Optional.of((GsonHttpMessageConverter) converter);
            }
        }
        return Optional.empty();
    }
}
