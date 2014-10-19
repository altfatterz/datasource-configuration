package com.backbase.progfun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
       Used for traditional deployment into a Servlet 3.0 container.
       SpringBootServletInitializer is a WebApplicationInitializer which is detected automatically by
       SpringServletContainerInitializer which itself is bootstrapped automatically by any Servlet 3.0 container

       Servlet 3.0 ServletContainerInitializer is designed to support code-based configuration as opposed to
       the traditional web.xml based approach.
    */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Autowired(required = false)
    DatabaseLoader databaseLoader;
}
