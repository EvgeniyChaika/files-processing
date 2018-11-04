package com.chaika.files.bootstrap;

import com.chaika.files.models.domain.User;
import com.chaika.files.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by echaika on 03.11.2018
 */

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;

    @Autowired
    public DevBootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initRoles();
    }

    private void initRoles() {
        List<User> userList = userRepository.findAll();

        if (userList.isEmpty()) {
            User user1 = new User();
            user1.setUsername("TestUser1");
            userList.add(user1);

            User user2 = new User();
            user2.setUsername("TestUser2");
            userList.add(user2);

            userRepository.saveAll(userList);
        }
    }
}
