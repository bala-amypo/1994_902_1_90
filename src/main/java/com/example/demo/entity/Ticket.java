package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private TicketCategory category;

    private String subject;
    private String description;
    private String status = "OPEN";
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getSubject() { return subject; }
    public String getDescription() { return description; }
    public void setUser(User user) { this.user = user; }
    public void setCategory(TicketCategory category) { this.category = category; }
}
