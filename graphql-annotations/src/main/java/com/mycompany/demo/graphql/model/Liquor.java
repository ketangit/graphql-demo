package com.mycompany.demo.graphql.model;

import com.mycompany.demo.graphql.utils.SchemaUtils;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Date;

@GraphQLName(SchemaUtils.LIQUOR)
public class Liquor {
    @GraphQLField
    private Date brand_label_expiration_date;
    @GraphQLField
    private String brand_label_name;
    @GraphQLField
    private String brand_label_serial_number;
    @GraphQLField
    private String domestic_d_or_imported_i;
    @GraphQLField
    private String license_class_code;
    @GraphQLField
    private String license_class_description;
    @GraphQLField
    private String license_type_code;
    @GraphQLField
    private String product_description;
    @GraphQLField
    private String wholesaler_license_serial_number;
    @GraphQLField
    private String wholesaler_name;

    public Date getBrand_label_expiration_date() {
        return brand_label_expiration_date;
    }

    public void setBrand_label_expiration_date(Date brand_label_expiration_date) {
        this.brand_label_expiration_date = brand_label_expiration_date;
    }

    public String getBrand_label_name() {
        return brand_label_name;
    }

    public void setBrand_label_name(String brand_label_name) {
        this.brand_label_name = brand_label_name;
    }

    public String getBrand_label_serial_number() {
        return brand_label_serial_number;
    }

    public void setBrand_label_serial_number(String brand_label_serial_number) {
        this.brand_label_serial_number = brand_label_serial_number;
    }

    public String getDomestic_d_or_imported_i() {
        return domestic_d_or_imported_i;
    }

    public void setDomestic_d_or_imported_i(String domestic_d_or_imported_i) {
        this.domestic_d_or_imported_i = domestic_d_or_imported_i;
    }

    public String getLicense_class_code() {
        return license_class_code;
    }

    public void setLicense_class_code(String license_class_code) {
        this.license_class_code = license_class_code;
    }

    public String getLicense_class_description() {
        return license_class_description;
    }

    public void setLicense_class_description(String license_class_description) {
        this.license_class_description = license_class_description;
    }

    public String getLicense_type_code() {
        return license_type_code;
    }

    public void setLicense_type_code(String license_type_code) {
        this.license_type_code = license_type_code;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getWholesaler_license_serial_number() {
        return wholesaler_license_serial_number;
    }

    public void setWholesaler_license_serial_number(String wholesaler_license_serial_number) {
        this.wholesaler_license_serial_number = wholesaler_license_serial_number;
    }

    public String getWholesaler_name() {
        return wholesaler_name;
    }

    public void setWholesaler_name(String wholesaler_name) {
        this.wholesaler_name = wholesaler_name;
    }
}
