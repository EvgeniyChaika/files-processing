package com.chaika.files.repository.studying.impl;

import com.chaika.files.repository.studying.GreetingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by echaika on 06.11.2018
 */
@Slf4j
@Component
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public void getEnglishGreeting() {
        log.debug("Test profile EN");
    }

    @Override
    public void getFinnishGreeting() {
        log.info("Test profile FI");
    }

    @Override
    public void getRussianGreeting() {
        log.info("Test profile RU");
    }
}
