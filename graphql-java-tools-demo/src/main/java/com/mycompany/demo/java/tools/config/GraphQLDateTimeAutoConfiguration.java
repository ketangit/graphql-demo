package com.mycompany.demo.java.tools.config;

import com.mycompany.demo.java.tools.scalar.GraphQLLocalDateTime;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLDateTimeAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public GraphQLLocalDateTime graphQLLocalDateTime() {
        return new GraphQLLocalDateTime();
    }

}
