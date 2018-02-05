package com.mycompany.demo.graphql.model;

import com.mycompany.demo.graphql.utils.SchemaUtils;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

@GraphQLName(SchemaUtils.SUBWAY)
public class Subway {
    @GraphQLField
    private String entrance_type;
    @GraphQLField
    private String entry;
    @GraphQLField
    private String free_crossover;
    @GraphQLField
    private String line;
    @GraphQLField
    private String north_south_street;
    @GraphQLField
    private String route1;
    @GraphQLField
    private String staffing;
    @GraphQLField
    private String station_name;
    @GraphQLField
    private Point station_location;
    @GraphQLField
    private Point entrance_location;
    @GraphQLField
    private String division;
    @GraphQLField
    private String vending;

    public String getEntrance_type() {
        return entrance_type;
    }

    public void setEntrance_type(String entrance_type) {
        this.entrance_type = entrance_type;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getFree_crossover() {
        return free_crossover;
    }

    public void setFree_crossover(String free_crossover) {
        this.free_crossover = free_crossover;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getNorth_south_street() {
        return north_south_street;
    }

    public void setNorth_south_street(String north_south_street) {
        this.north_south_street = north_south_street;
    }

    public String getRoute1() {
        return route1;
    }

    public void setRoute1(String route1) {
        this.route1 = route1;
    }

    public String getStaffing() {
        return staffing;
    }

    public void setStaffing(String staffing) {
        this.staffing = staffing;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public Point getStation_location() {
        return station_location;
    }

    public void setStation_location(Point station_location) {
        this.station_location = station_location;
    }

    public Point getEntrance_location() {
        return entrance_location;
    }

    public void setEntrance_location(Point entrance_location) {
        this.entrance_location = entrance_location;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getVending() {
        return vending;
    }

    public void setVending(String vending) {
        this.vending = vending;
    }
}
