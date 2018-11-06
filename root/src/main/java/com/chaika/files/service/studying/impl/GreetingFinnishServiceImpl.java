package com.chaika.files.service.studying.impl;

import com.chaika.files.repository.studying.GreetingRepository;
import com.chaika.files.service.studying.GreetingService;

/**
 * Created by echaika on 05.11.2018
 */
public class GreetingFinnishServiceImpl implements GreetingService {

    private GreetingRepository greetingRepository;

    public GreetingFinnishServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void printMessage() {
        greetingRepository.getFinnishGreeting();
    }
}
