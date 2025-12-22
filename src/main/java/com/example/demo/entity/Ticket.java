package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String status;

    @ManyToOne
    private User user;

    @ManyToOne
    private TicketCategory category;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(TicketCategory category) {
        this.category = category;
    }
}
