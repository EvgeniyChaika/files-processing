package com.chaika.files.config;

import com.chaika.files.config.datasource.ExternalDataSource;
import com.chaika.files.config.jms.JmsTestSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by echaika on 06.11.2018
 */
@Configuration
@PropertySource("classpath:jms.properties")
public class PropertyConfig {

    @Value("${mysql.datasource.username}")
    private String username;
    @Value("${mysql.datasource.password}")
    private String password;
    @Value("${mysql.datasource.url}")
    private String url;

    @Value("${jms.test.username}")
    private String jmsUsername;
    @Value("${jms.test.password}")
    private String jmsPassword;
    @Value("${jms.test.url}")
    private String jmsUrl;

    private final Environment environment;

    private static final Logger logger = LoggerFactory.getLogger(PropertyConfig.class);

    @Autowired
    public PropertyConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ExternalDataSource externalDataSource() {
        ExternalDataSource externalDataSource = new ExternalDataSource();
        externalDataSource.setUsername(username);
        externalDataSource.setPassword(password);
        externalDataSource.setUrl(url);
        logger.info("Active profiles - {}", Arrays.toString(environment.getActiveProfiles()));
        logger.info("Environment TEST_ENV value - {}", environment.getProperty("TEST_ENV"));
        return externalDataSource;
    }

    @Bean
    public JmsTestSource jmsTestSource() {
        JmsTestSource jmsTestSource = new JmsTestSource();
        jmsTestSource.setUsername(jmsUsername);
        jmsTestSource.setPassword(jmsPassword);
        jmsTestSource.setUrl(jmsUrl);
        logger.info(jmsTestSource.toString());
        return jmsTestSource;
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
