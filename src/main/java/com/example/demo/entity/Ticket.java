package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    private User user;

    @ManyToOne
    private TicketCategory category;

    @PrePersist
    public void prePersist() {
    }
}
