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
    private Ticket matchedTicket;

    private double matchScore;

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setMatchedTicket(Ticket matchedTicket) {
        this.matchedTicket = matchedTicket;
    }

    public void setMatchScore(double matchScore) {
        this.matchScore = matchScore;
    }
}
