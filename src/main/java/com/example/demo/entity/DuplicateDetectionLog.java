package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Ticket matchedTicket;

    private Double matchScore;
    private LocalDateTime detectedAt;

    @PrePersist
    public void onCreate() {
        detectedAt = LocalDateTime.now();
    }

    // setters
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    public void setMatchedTicket(Ticket matchedTicket) { this.matchedTicket = matchedTicket; }
    public void setMatchScore(Double matchScore) { this.matchScore = matchScore; }
}
