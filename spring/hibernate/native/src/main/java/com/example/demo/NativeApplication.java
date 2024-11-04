package com.example.demo;

import jakarta.persistence.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class NativeApplication {

	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(NativeApplication.class, args);
	}

//	https://spring.io/guides/gs/spring-boot
//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//
//			System.out.println("Hello, world!");
//			nativeQuerySelectJson();
//			nativeQuerySearchJson_JSON_PATH_QUERY();
//			nativeQuerySearchJson_REGEX_TILDE();
//
//		};
//	}

	private void nativeQuerySelectJson(){
		String query = "SELECT id, content::TEXT FROM people";
		Query nativeQuery = entityManager.createNativeQuery(query);
		List<Object[]> people = nativeQuery.getResultList();

		for (Object[] person : people) {
			System.out.println("id=" + person[0] + ", content=" + person[1]);
		}
	}

	private void nativeQuerySearchJson_JSON_PATH_QUERY(){
		String query = "SELECT id, JSONB_PATH_QUERY(content,'$.name')::TEXT FROM people";
		Query nativeQuery = entityManager.createNativeQuery(query);
		List<Object[]> people = nativeQuery.getResultList();

		for (Object[] person : people) {
			System.out.println("id=" + person[0] + ", name= " + person[1]);
		}
	}

	private void nativeQuerySearchJson_REGEX_TILDE(){
		String query = "SELECT id, content::TEXT FROM people WHERE content::TEXT ~ '.*name.*' ";
		Query nativeQuery = entityManager.createNativeQuery(query);
		List<Object[]> people = nativeQuery.getResultList();

		for (Object[] person : people) {
			System.out.println("id=" + person[0] + ", name= " + person[1]);
		}
	}

}
