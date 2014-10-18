package com.backbase.progfun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired(required = false)
    DatabaseLoader databaseLoader;

    @Autowired
    PageRepository pageRepository;

    @PostConstruct
    void init() {
        for (Page page : pageRepository.findAll()) {
            LOGGER.info(page.toString());
        }    
    }
}
