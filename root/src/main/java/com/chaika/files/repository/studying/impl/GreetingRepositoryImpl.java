package com.chaika.files.repository.studying.impl;

import com.chaika.files.repository.studying.GreetingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by echaika on 06.11.2018
 */
@Component
public class GreetingRepositoryImpl implements GreetingRepository {

    private static final Logger logger = LoggerFactory.getLogger(GreetingRepository.class);

    @Override
    public void getEnglishGreeting() {
        logger.info("Test profile EN");
    }

    @Override
    public void getFinnishGreeting() {
        logger.info("Test profile FI");
    }

    @Override
    public void getRussianGreeting() {
        logger.info("Test profile RU");
    }
}
