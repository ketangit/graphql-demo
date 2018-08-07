package com.mycompany.demo.java.tools.scalar;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

import java.time.LocalDateTime;

public class GraphQLLocalDateTime extends GraphQLScalarType {
    private static final String DEFAULT_NAME = "LocalDateTime";

    public GraphQLLocalDateTime() {
        this(DEFAULT_NAME);
    }

    public GraphQLLocalDateTime(final String name) {
        super(name, "Local Date Time type", new Coercing<LocalDateTime, String>() {
            private LocalDateTime convertImpl(Object input) {
                if (input instanceof String) {
                    return DateTimeHelper.parseDate((String) input);
                }
                return null;
            }

            @Override
            public String serialize(Object input) {
                if (input instanceof LocalDateTime) {
                    return DateTimeHelper.toISOString((LocalDateTime) input);
                } else {
                    LocalDateTime result = convertImpl(input);
                    if (result == null) {
                        throw new CoercingSerializeException("Invalid value '" + input + "' for LocalDateTime");
                    }
                    return DateTimeHelper.toISOString(result);
                }
            }

            @Override
            public LocalDateTime parseValue(Object input) {
                LocalDateTime result = convertImpl(input);
                if (result == null) {
                    throw new CoercingParseValueException("Invalid value '" + input + "' for LocalDateTime");
                }
                return result;
            }

            @Override
            public LocalDateTime parseLiteral(Object input) {
                if (!(input instanceof StringValue)) return null;
                String value = ((StringValue) input).getValue();
                return convertImpl(value);
            }
        });
    }
}
