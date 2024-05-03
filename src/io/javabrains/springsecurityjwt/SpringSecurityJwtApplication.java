package io.javabrains.springsecurityjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringSecurityJwtApplication extends SpringBootServletInitializer
{
    public static void main(String[] args) {
        SpringApplication.run((Class)SpringSecurityJwtApplication.class, args);
    }
}
