package com.chaika.files.service.test.impl;

import com.chaika.files.service.test.GreetingService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by echaika on 05.11.2018
 */
@Service
@Primary
public class GreetingPrimaryServiceImpl implements GreetingService {

    @Override
    public void printMessage() {
        System.out.println("Test profile EN");
    }
}
