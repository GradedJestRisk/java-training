package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Thing {
    @Id
    private int id;

    @Column
    private String content;

    public Thing(){}

    public Thing(int id, String content){
        this.id = id;
        this.content = content;
    }

}