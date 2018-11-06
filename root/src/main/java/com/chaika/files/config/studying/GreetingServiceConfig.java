package com.chaika.files.config.studying;

import com.chaika.files.repository.UserRepository;
import com.chaika.files.service.studying.GreetingService;
import com.chaika.files.service.studying.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Created by echaika on 06.11.2018
 */
@Configuration
public class GreetingServiceConfig {

    @Bean
    GreetingServiceFactory greetingServiceFactory(UserRepository userRepository) {
        return new GreetingServiceFactory(userRepository);
    }

    @Bean
    @Primary
    @Profile({"en", "default"})
        //@IgnoreDuringScan
    GreetingService greetingPrimaryServiceImpl(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("en");
    }

    @Bean
    @Primary
    @Profile("ru")
        //@IgnoreDuringScan
    GreetingService greetingRussianServiceImpl(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("ru");
    }

    @Bean
    @Primary
    @Profile("fi")
        //@IgnoreDuringScan
    GreetingService greetingFinnishServiceImpl(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("fi");
    }
}
