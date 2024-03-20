package com.java.effective.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing // 따로 config로 구성. test코드때문에.
@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

}
