package com.chaika.files.service.studying;

import com.chaika.files.repository.studying.GreetingRepository;
import com.chaika.files.service.studying.impl.GreetingFinnishServiceImpl;
import com.chaika.files.service.studying.impl.GreetingPrimaryServiceImpl;
import com.chaika.files.service.studying.impl.GreetingRussianServiceImpl;

/**
 * Created by echaika on 06.11.2018
 */
public class GreetingServiceFactory {


    private GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang) {
        switch (lang) {
            case "en":
                return new GreetingPrimaryServiceImpl(greetingRepository);
            case "fi":
                return new GreetingFinnishServiceImpl(greetingRepository);
            case "ru":
                return new GreetingRussianServiceImpl(greetingRepository);
            default:
                return new GreetingPrimaryServiceImpl(greetingRepository);
        }
    }
}
