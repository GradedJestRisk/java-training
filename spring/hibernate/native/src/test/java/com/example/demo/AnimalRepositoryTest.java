package com.example.demo;

import com.example.demo.entities.Thing;
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

    @Autowired
    ThingJpaRepository thingJpaRepository;

    @DisplayName("Hibernate Query Language (HQL) - JPQL")
    @Nested
    class HQL {

        @DisplayName("Read")
        @Nested
        class Read {

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

        @DisplayName("Write")
        @Nested
        class Write {

            @DisplayName("use save")
            @Test
            void test() {

                // given
                Thing rose = new Thing(3, "a rose");

                // when
                thingJpaRepository.save(rose);

                // then
                List <Thing> things = thingJpaRepository.findAll();
                assertThat(things).hasSize(3);
            }
        }
    }


}