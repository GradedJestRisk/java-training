package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PeopleRepositoryTest {

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    void test(){

        // given
        // peopleRepository is injected

        // when
        List<Object[]> people = peopleRepository.people();

        // then
        assertThat(people).hasSize(2);
    }

}