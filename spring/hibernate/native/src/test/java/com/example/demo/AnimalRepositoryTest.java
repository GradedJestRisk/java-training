package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AnimalRepositoryTest {

    @Autowired
    private AnimalRepository animalRepository;

    @DisplayName("Hibernate Query Language (HQL) - JPQL")
    @Nested
    class HQL {

        @DisplayName("#createQuery")
        @Nested
        class CreateQuery {

            @DisplayName("Use Entity name Animal, not table name animal")
            @Test
            void test() {

                // given
                // animalRepository is injected

                // when
                List<Object[]> animals = animalRepository.animals();

                // then
                assertThat(animals).hasSize(2);
            }
        }
    }


}