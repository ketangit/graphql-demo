package com.mycompany.demo.annotations.model;

import com.mycompany.demo.annotations.utils.SchemaUtils;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;


@GraphQLName(SchemaUtils.FARMER)
public class Farmer {
    @GraphQLField
    private Long farmer_id;
    @GraphQLField
    private String website;
    @GraphQLField
    private String suite;
    @GraphQLField
    private String category;
    @GraphQLField
    private String business;
    @GraphQLField
    private String item;
    @GraphQLField
    private Point location_1;
    @GraphQLField
    private String location_1_city;
    @GraphQLField
    private String location_1_location;
    @GraphQLField
    private String location_1_state;
    @GraphQLField
    private String zipcode;

    public Long getFarmer_id() {
        return farmer_id;
    }

    public void setFarmer_id(Long farmer_id) {
        this.farmer_id = farmer_id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Point getLocation_1() {
        return location_1;
    }

    public void setLocation_1(Point location_1) {
        this.location_1 = location_1;
    }

    public String getLocation_1_city() {
        return location_1_city;
    }

    public void setLocation_1_city(String location_1_city) {
        this.location_1_city = location_1_city;
    }

    public String getLocation_1_location() {
        return location_1_location;
    }

    public void setLocation_1_location(String location_1_location) {
        this.location_1_location = location_1_location;
    }

    public String getLocation_1_state() {
        return location_1_state;
    }

    public void setLocation_1_state(String location_1_state) {
        this.location_1_state = location_1_state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
