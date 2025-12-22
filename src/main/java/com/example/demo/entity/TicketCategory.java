package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TicketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @PrePersist
    public void prePersist() {
    }
}
