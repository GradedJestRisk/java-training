package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Object[]> animals (){
        String querySource = "SELECT id, content FROM Animal";
        Query query = entityManager.createQuery(querySource);
        return query.getResultList();
    }
}
