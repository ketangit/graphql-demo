package com.mycompany.demo.java.tools.config;

import com.mycompany.demo.java.tools.domain.Item;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan(basePackageClasses = {Item.class, Jsr310JpaConverters.class})
@EnableTransactionManagement
@Configuration
public class DomainConfiguration {
}
