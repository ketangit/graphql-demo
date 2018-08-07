package com.mycompany.demo.java.tools.config;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.Scalars;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfig {

//    @Bean
//    public GraphQLSchema graphQLSchema() {
//        return SchemaParser.newParser()
//                .file("storeapi.graphqls").build().makeExecutableSchema();
//        return GraphQLSchema.newSchema()
//                .query(GraphQLObjectType.newObject()
//                        .name("query")
//                        .field(field -> field
//                                .name("test")
//                                .type(Scalars.GraphQLString)
//                                .dataFetcher(environment -> "response")
//                        )
//                        .build())
//                .build();
//    }
}
