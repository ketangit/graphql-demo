package com.mycompany.demo.graphql.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class GraphqlController {
    private GraphQL graphQLExecutor;
    private final ObjectMapper objectMapper;

    public GraphqlController(final GraphQLSchema graphQLSchema, final ObjectMapper objectMapper) {
        this.graphQLExecutor = new GraphQL(graphQLSchema);
        this.objectMapper = objectMapper;
    }

    @PostMapping(path = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ExecutionResult graphQl(@RequestBody final GraphQLInputQuery query) throws IOException {
        if (StringUtils.isEmpty(query.getVariables())) {
            return graphQLExecutor.execute(query.getQuery(), null);
        }
        Map<String, Object> variables = objectMapper.readValue(query.getVariables(), new TypeReference<Map<String, Object>>() {
        });
        ExecutionResult executionResult = graphQLExecutor.execute(query.getQuery(), variables);
        if (!executionResult.getErrors().isEmpty()) {
            // LOGGER.warning("Errors: " + executionResult.getErrors());
        }
        return executionResult;
    }

    static final class GraphQLInputQuery {
        private String query;
        private String variables;

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public String getVariables() {
            return variables;
        }

        public void setVariables(String variables) {
            this.variables = variables;
        }
    }
}
