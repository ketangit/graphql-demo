package com.mycompany.demo.annotations.config;

import com.mycompany.demo.annotations.mutation.UserMutation;
import com.mycompany.demo.annotations.query.UserQuery;
import graphql.annotations.processor.GraphQLAnnotations;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static graphql.schema.GraphQLSchema.newSchema;

@Configuration
public class GraphqlConfig {

    @Bean
    public GraphQLSchema graphQLSchema() {
        GraphQLAnnotations graphqlAnnotations = new GraphQLAnnotations();

        return newSchema()
                .query(graphqlAnnotations.object(UserQuery.class))
                .mutation(graphqlAnnotations.object(UserMutation.class))
                .build();
    }
}
