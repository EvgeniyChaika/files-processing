package com.chaika.files.service.studying.impl;

import com.chaika.files.repository.studying.GreetingRepository;
import com.chaika.files.service.studying.GreetingService;

/**
 * Created by echaika on 05.11.2018
 */
public class GreetingPrimaryServiceImpl implements GreetingService {

    private GreetingRepository greetingRepository;

    public GreetingPrimaryServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void printMessage() {
        greetingRepository.getEnglishGreeting();
    }
}
