package com.mycompany.demo.graphql.repository;

import com.mycompany.demo.graphql.model.Farmer;
import com.mycompany.demo.graphql.model.Liquor;
import com.mycompany.demo.graphql.model.Subway;
import com.mycompany.demo.graphql.model.Tree;
import com.mycompany.demo.graphql.utils.Loggable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

public class SodaRestApiService implements Loggable {

    public List<Farmer> listFarmers() {
        String sodaUrl = "https://data.ct.gov/resource/y6p2-px98.json";
        List<String> selectClause = Arrays.asList("farmer_id", "website", "suite", "category", "business", "item", "location_1", "location_1_city", "location_1_location", "location_1_state", "zipcode");
        String whereClause = null;
        int limit = 20;
        return Arrays.asList(getSodaData(sodaUrl, Farmer[].class, selectClause, whereClause, limit).getBody());
    }

    public List<Farmer> getFarmer(long farmer_id) {
        String sodaUrl = "https://data.ct.gov/resource/y6p2-px98.json";
        List<String> selectClause = Arrays.asList("farmer_id", "website", "suite", "category", "business", "item", "location_1", "location_1_city", "location_1_location", "location_1_state", "zipcode");
        String whereClause = "farmer_id=" + farmer_id;
        int limit = 20;
        return Arrays.asList(getSodaData(sodaUrl, Farmer[].class, selectClause, whereClause, limit).getBody());
    }

    public List<Tree> listTrees() {
        //https://dev.socrata.com/foundry/data.sfgov.org/2zah-tuvt
        String sodaUrl = "https://data.sfgov.org/resource/2zah-tuvt.json";
        List<String> selectClause = Arrays.asList("treeid", "plantdate", "qaddress", "qlegalstatus", "qsiteinfo", "qspecies", "planttype", "siteorder");
        String whereClause = null;
        int limit = 20;
        return Arrays.asList(getSodaData(sodaUrl, Tree[].class, selectClause, whereClause, limit).getBody());
    }

    public List<Subway> listSubways() {
        //https://dev.socrata.com/foundry/data.ny.gov/hvwh-qtfg
        String sodaUrl = "https://data.ny.gov/resource/hvwh-qtfg.json";
        List<String> selectClause = Arrays.asList("entrance_type", "entry", "free_crossover", "line", "north_south_street", "route1", "staffing", "station_name", "station_location", "entrance_location", "division", "vending");
        String whereClause = null;
        int limit = 20;
        return Arrays.asList(getSodaData(sodaUrl, Subway[].class, selectClause, whereClause, limit).getBody());
    }

    public List<Liquor> listLiquorData() {
        //https://dev.socrata.com/foundry/data.ny.gov/j7kd-fzm7
        String sodaUrl = "https://data.ny.gov/resource/j7kd-fzm7.json";
        List<String> selectClause = Arrays.asList("brand_label_expiration_date", "brand_label_name", "brand_label_serial_number", "domestic_d_or_imported_i", "license_class_code", "license_class_description", "license_type_code", "product_description", "wholesaler_license_serial_number", "wholesaler_name");
        String whereClause = null;
        int limit = 20;
        return Arrays.asList(getSodaData(sodaUrl, Liquor[].class, selectClause, whereClause, limit).getBody());
    }

    private <T> ResponseEntity<T> getSodaData(String url, Class<T> responseType, List<String> selectClause, String whereClause, Integer limit) {
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

        logger().debug(builder.build().toUri().toString());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(builder.build().toUri(), responseType);
    }
}
