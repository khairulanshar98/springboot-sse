package com.sse.example.sse.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Dummy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String hello;
    private String message;
    private String topic;
    private String payload;

    @Override
    public String toString() {
        return "Dummy{" +
                "id=" + id +
                ", hello='" + hello + '\'' +
                ", topic='" + topic + '\'' +
                ", message='" + message + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
