package com.sparta.mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaAuditing
@EnableScheduling
@SpringBootApplication
public class MiniApplication {
//  public static final String APPLICATION_LOCATIONS = "spring.config.location="
//          + "classpath:application.yml,"
//          + "/app/config/springboot-webservice/real-application.yml";
//
//  public static void main(String[] args) {
//    new SpringApplicationBuilder(MiniApplication.class)
//            .properties(APPLICATION_LOCATIONS)
//            .run(args);
//  }
  public static void main(String[] args) {
    SpringApplication.run(MiniApplication.class, args);
  }

}
