package com.chaika.files.config;

import com.chaika.files.config.datasource.ExternalDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Objects;

/**
 * Created by echaika on 06.11.2018
 */
@Configuration
public class PropertyConfig {

    @Value("${mysql.datasource.username}")
    private String username;
    @Value("${mysql.datasource.password}")
    private String password;
    @Value("${mysql.datasource.url}")
    private String url;

    @Bean
    public ExternalDataSource externalDataSource() {
        ExternalDataSource externalDataSource = new ExternalDataSource();
        externalDataSource.setUsername(username);
        externalDataSource.setPassword(password);
        externalDataSource.setUrl(url);
        return externalDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("datasource.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(Objects.requireNonNull(yaml.getObject()));
        return propertySourcesPlaceholderConfigurer;
    }
}
