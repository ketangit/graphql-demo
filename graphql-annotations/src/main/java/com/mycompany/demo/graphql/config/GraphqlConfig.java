package com.mycompany.demo.graphql.config;

import com.mycompany.demo.graphql.mutation.UserMutation;
import com.mycompany.demo.graphql.query.UserQuery;
import graphql.annotations.processor.GraphQLAnnotations;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static graphql.schema.GraphQLSchema.newSchema;

@Configuration
public class GraphqlConfig {

    @Bean
    public GraphQLSchema graphQLSchema() {
        return newSchema()
                .query(GraphQLAnnotations.object(UserQuery.class))
                .mutation(GraphQLAnnotations.object(UserMutation.class))
                .build();
    }
}
