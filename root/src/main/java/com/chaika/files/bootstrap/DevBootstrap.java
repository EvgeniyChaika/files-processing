package com.chaika.files.bootstrap;

import com.chaika.files.model.Role;
import com.chaika.files.model.domain.User;
import com.chaika.files.repository.UserRepository;
import com.chaika.files.service.studying.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by echaika on 03.11.2018
 */
@Slf4j
@Component
//@IgnoreDuringScan
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    private GreetingService greetingService;

    @Autowired
    public DevBootstrap(UserRepository userRepository, GreetingService greetingService) {
        this.userRepository = userRepository;
        this.greetingService = greetingService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initRoles();
    }

    private void initRoles() {
        List<User> userList = userRepository.findAll();

        if (userList.isEmpty()) {
            User user1 = new User();
            user1.setUsername("UserTest");
            user1.setPassword("studying");
            user1.setAuthorities(Collections.singletonList(Role.USER));
            userList.add(user1);

            User user2 = new User();
            user2.setUsername("CustomerTest");
            user2.setPassword("studying");
            user2.setAuthorities(new ArrayList<>(Arrays.asList(Role.CUSTOMER, Role.ADMIN)));
            userList.add(user2);

            List<User> list = userRepository.saveAll(userList);
            log.info("Saved list - " + String.valueOf(list));
        }

        greetingService.printMessage();
    }
}
