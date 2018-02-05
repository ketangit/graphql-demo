package com.mycompany.demo.graphql.mutation;

import com.mycompany.demo.graphql.model.User;
import com.mycompany.demo.graphql.repository.UserRepository;
import com.mycompany.demo.graphql.utils.SchemaUtils;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.schema.DataFetchingEnvironment;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@GraphQLName(SchemaUtils.MUTATION)
public class UserMutation {
    @GraphQLField
    public static User createUser(final DataFetchingEnvironment env, @NotNull @GraphQLName(SchemaUtils.NAME) final String name, @NotNull @GraphQLName(SchemaUtils.EMAIL) final String email, @NotNull @GraphQLName(SchemaUtils.AGE) final int age) {
        List<User> users = UserRepository.getUsers();
        final User user = new User();
        user.setId(UserRepository.getNextId());
        user.setAge(age);
        user.setEmail(email);
        user.setName(name);
        users.add(user);
        return user;
    }

    @GraphQLField
    public static User updateUser(final DataFetchingEnvironment env, @NotNull @GraphQLName(SchemaUtils.ID) final String id, @NotNull @GraphQLName(SchemaUtils.NAME) final String name, @NotNull @GraphQLName(SchemaUtils.EMAIL) final String email, @NotNull @GraphQLName(SchemaUtils.AGE) final String age) {
        final Optional<User> user = UserRepository.getUsers().stream()
                .filter(c -> c.getId() == Long.parseLong(id))
                .findFirst();
        if (!user.isPresent()) {
            return null;
        }
        user.get()
                .setName(name);
        user.get()
                .setEmail(email);
        user.get()
                .setAge(Integer.valueOf(age));
        return user.get();
    }

    @GraphQLField
    public static User deleteUser(final DataFetchingEnvironment env, @NotNull @GraphQLName(SchemaUtils.ID) final String id) {
        final List<User> users = UserRepository.getUsers();
        final Optional<User> user = users.stream()
                .filter(c -> c.getId() == Long.parseLong(id))
                .findFirst();
        if (!user.isPresent()) {
            return null;
        }
        users.removeIf(c -> c.getId() == Long.parseLong(id));
        return user.get();
    }
}
