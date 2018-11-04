package com.chaika.files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by echaika on 27.08.2018
 */

@SpringBootApplication
public class FilesProcessingApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FilesProcessingApplication.class, args);
    }
}
