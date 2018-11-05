package com.chaika.files.service.test.impl;

import com.chaika.files.service.test.GreetingService;
import org.springframework.stereotype.Service;

/**
 * Created by echaika on 05.11.2018
 */
@Service
public class GreetingFinnishServiceImpl implements GreetingService {

    @Override
    public void printMessage() {
        System.out.println("Test profile FI");
    }
}
