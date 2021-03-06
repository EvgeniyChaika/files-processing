package com.chaika.files.config;

import com.chaika.files.config.datasource.ExternalDataSource;
import com.chaika.files.config.jms.JmsTestSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by echaika on 06.11.2018
 */
@Slf4j
@Configuration
@PropertySource("classpath:jms.properties")
@ConfigurationProperties(prefix = "test")
public class PropertyConfig {

    @Value("${mysql.datasource.username}")
    private String username;
    @Value("${mysql.datasource.password}")
    private String password;
    @Value("${mysql.datasource.url}")
    private String url;

    /**
     * YAML list properties example
     */
    private List<String> names;

    public void setNames(List<String> names) {
        this.names = names;
    }

    /** ---- */

    @Value("${jms.test.username}")
    private String jmsUsername;
    @Value("${jms.test.password}")
    private String jmsPassword;
    @Value("${jms.test.url}")
    private String jmsUrl;

    private final Environment environment;

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
        log.info("Active profiles - {}", Arrays.toString(environment.getActiveProfiles()));
        log.info("Environment TEST_ENV value - {}", environment.getProperty("TEST_ENV")); // TEST_ENV=Test environment value
        log.info("YAML test names - {}", names);
        return externalDataSource;
    }

    @Bean
    public JmsTestSource jmsTestSource() {
        JmsTestSource jmsTestSource = new JmsTestSource();
        jmsTestSource.setUsername(jmsUsername);
        jmsTestSource.setPassword(jmsPassword);
        jmsTestSource.setUrl(jmsUrl);
        log.info(jmsTestSource.toString());
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
