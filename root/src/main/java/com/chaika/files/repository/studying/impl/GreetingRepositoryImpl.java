package com.chaika.files.repository.studying.impl;

import com.chaika.files.repository.studying.GreetingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by echaika on 06.11.2018
 */
@Component
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public void getEnglishGreeting() {
        System.out.println("Test profile EN");
    }

    @Override
    public void getFinnishGreeting() {
        System.out.println("Test profile FI");
    }

    @Override
    public void getRussianGreeting() {
        System.out.println("Test profile RU");
    }
}
