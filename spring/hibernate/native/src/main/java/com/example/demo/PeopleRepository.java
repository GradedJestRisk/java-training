package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Object[]> people (){
        String query = "SELECT id, content::TEXT FROM people";
        Query nativeQuery = entityManager.createNativeQuery(query);
        return nativeQuery.getResultList();
    }
}
