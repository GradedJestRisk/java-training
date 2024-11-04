package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "animal")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @Column(columnDefinition = "id")
    private int id;

    @Column(name = "content")
    private String content;

}