package com.chaika.files.service.studying;

import com.chaika.files.repository.UserRepository;
import com.chaika.files.service.studying.impl.GreetingFinnishServiceImpl;
import com.chaika.files.service.studying.impl.GreetingPrimaryServiceImpl;
import com.chaika.files.service.studying.impl.GreetingRussianServiceImpl;

/**
 * Created by echaika on 06.11.2018
 */
public class GreetingServiceFactory {


    private UserRepository userRepository;

    public GreetingServiceFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GreetingService createGreetingService(String lang) {
        switch (lang) {
            case "en":
                return new GreetingPrimaryServiceImpl(userRepository);
            case "fi":
                return new GreetingFinnishServiceImpl(userRepository);
            case "ru":
                return new GreetingRussianServiceImpl(userRepository);
            default:
                return new GreetingPrimaryServiceImpl(userRepository);
        }
    }
}
