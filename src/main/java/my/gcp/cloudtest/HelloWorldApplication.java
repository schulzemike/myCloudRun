package my.gcp.cloudtest;

import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** This class serves as an entry point for the Spring Boot app. */
@SpringBootApplication
public class HelloWorldApplication {

  private static final Logger logger = LoggerFactory.getLogger(HelloWorldApplication.class);

  public static void main(final String[] args) {
    SpringApplication.run(HelloWorldApplication.class, args);
  }
}

