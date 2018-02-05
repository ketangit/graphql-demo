package com.mycompany.demo.graphql.query;

import com.mycompany.demo.graphql.model.Farmer;
import com.mycompany.demo.graphql.model.User;
import com.mycompany.demo.graphql.repository.SodaRestApiService;
import com.mycompany.demo.graphql.repository.UserRepository;
import com.mycompany.demo.graphql.utils.SchemaUtils;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.schema.DataFetchingEnvironment;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@GraphQLName(SchemaUtils.QUERY)
public class UserQuery {
    @GraphQLField
    public static User retrieveUser(final DataFetchingEnvironment env, @NotNull @GraphQLName(SchemaUtils.ID) final String id) {
        final Optional<User> any = UserRepository.getUsers().stream()
                .filter(c -> c.getId() == Long.parseLong(id))
                .findFirst();
        return any.orElse(null);
    }

    @GraphQLField
    public static List<User> searchName(final DataFetchingEnvironment env, @NotNull @GraphQLName(SchemaUtils.NAME) final String name) {
        return UserRepository.getUsers().stream()
                .filter(c -> c.getName()
                        .contains(name))
                .collect(Collectors.toList());
    }

    @GraphQLField
    public static List<User> listUsers(final DataFetchingEnvironment env) {
        return UserRepository.getUsers();
    }

    @GraphQLField
    public static List<Farmer> listFarmers(final DataFetchingEnvironment env) {
        SodaRestApiService sodaRestApiService = new SodaRestApiService();
        return sodaRestApiService.listFarmers();
    }

    @GraphQLField
    public static List<Farmer> findFarmer(final DataFetchingEnvironment env, @GraphQLName(SchemaUtils.ID) long farmer_id) {
        SodaRestApiService sodaRestApiService = new SodaRestApiService();
        return sodaRestApiService.getFarmer(farmer_id);
    }
}