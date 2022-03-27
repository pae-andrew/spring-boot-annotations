package ru.learnUp.lesson21.springboottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootTestApplication {

		private static final Logger log = LoggerFactory.getLogger(SpringBootTestApplication.class);

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);

		MyGame.gameProcess(context);
	}
}
