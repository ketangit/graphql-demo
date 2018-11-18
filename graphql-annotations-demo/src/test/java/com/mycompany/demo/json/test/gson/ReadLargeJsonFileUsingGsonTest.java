package com.mycompany.demo.json.test.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.mycompany.demo.annotations.model.Subway;
import com.mycompany.demo.json.test.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class ReadLargeJsonFileUsingGsonTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testReadJsonFile() {
        try {
            // https://sites.google.com/site/gson/streaming
            Resource resource = new ClassPathResource("data.json", this.getClass().getClassLoader());
            JsonReader reader = new JsonReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));

            Gson gson = new GsonBuilder().create();
            reader.beginArray();
            while (reader.hasNext()) {
                Person person = gson.fromJson(reader, Person.class);
                System.out.println("Stream mode: " + person);
            }
            reader.close();
        } catch (UnsupportedEncodingException ex) {
            logger.error("Error reading person data", ex);
        } catch (IOException ex) {
            logger.error("Error reading person data", ex);
        }
    }

    @Test
    public void testGetJson() {
        //https://dev.socrata.com/foundry/data.ny.gov/hvwh-qtfg
        String sodaUrl = "https://data.ny.gov/resource/hvwh-qtfg.json";
        List<String> selectClause = Arrays.asList("entrance_type", "entry", "free_crossover", "line", "north_south_street", "route1", "staffing", "station_name", "station_location", "entrance_location", "division", "vending");
        String whereClause = null;
        int limit = 20;
        URI uri = getSodaDataUri(sodaUrl, selectClause, whereClause, limit);

        GsonRestTemplate gsonRestTemplate = new GsonRestTemplate();
        RestTemplate restTemplate = gsonRestTemplate.getRestTemplate();
        ResponseEntity<Subway[]> subways = restTemplate.getForEntity(uri, Subway[].class);
        logger.debug(String.valueOf(subways.getStatusCode()));
    }

    private URI getSodaDataUri(String url, List<String> selectClause, String whereClause, Integer limit) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        if (selectClause != null) {
            builder.queryParam("$select", String.join(",", selectClause));
        } else {
            builder.queryParam("$select", "*");
        }

        if (!StringUtils.isEmpty(whereClause)) {
            builder.queryParam("$where", whereClause);
        }

        if (limit != null) {
            builder.queryParam("$limit", limit);
        }

        return builder.build().toUri();
    }
}
