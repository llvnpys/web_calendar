package com.example.web_calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WebCalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCalendarApplication.class, args);
    }

}
