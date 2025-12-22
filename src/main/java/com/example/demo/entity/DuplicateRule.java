package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DuplicateRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ruleName;

    private Double threshold;

    @PrePersist
    public void prePersist() {
    }
}
