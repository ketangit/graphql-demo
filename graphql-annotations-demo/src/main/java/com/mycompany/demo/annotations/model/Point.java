package com.mycompany.demo.annotations.model;

import com.mycompany.demo.annotations.utils.SchemaUtils;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.List;

@GraphQLName(SchemaUtils.POINT)
public class Point {
    @GraphQLField
    private String type;
    @GraphQLField
    private List<Float> coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Float> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Float> coordinates) {
        this.coordinates = coordinates;
    }
}
