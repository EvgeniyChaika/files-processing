package com.chaika.files;

import com.chaika.files.config.annotation.IgnoreDuringScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

/**
 * Created by echaika on 27.08.2018
 */

@SpringBootApplication
@ComponentScan(excludeFilters = @Filter(IgnoreDuringScan.class))
public class FilesProcessingApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FilesProcessingApplication.class, args);
    }
}
