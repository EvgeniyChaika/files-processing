package com.chaika.files.service.studying.impl;

import com.chaika.files.repository.UserRepository;
import com.chaika.files.service.studying.GreetingService;

/**
 * Created by echaika on 05.11.2018
 */
public class GreetingPrimaryServiceImpl implements GreetingService {

    private UserRepository userRepository;

    public GreetingPrimaryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void printMessage() {
        System.out.println("Test profile EN");
    }
}
