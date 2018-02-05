package com.mycompany.demo.graphql.repository;

import com.mycompany.demo.graphql.model.User;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserRepository {
    private static List<User> users = new ArrayList<>();
    private static Random random = new Random();

    public static List<User> getUsers() {
        if (CollectionUtils.isEmpty(users)) {
            User user = new User();
            user.setId(getNextId());
            user.setAge(39);
            user.setEmail("test@email.com");
            user.setName("Test User");
            users.add(user);
        }
        return users;
    }

    public static long getNextId() {
        return random.nextLong() + 3;
    }
}
