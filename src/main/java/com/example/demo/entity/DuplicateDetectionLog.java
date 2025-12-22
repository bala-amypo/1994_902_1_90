package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private DuplicateRule rule;

    private Double score;

    @PrePersist
    public void prePersist() {
    }
}
