package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl {

    private final TicketRepository ticketRepo;
    private final UserRepository userRepo;
    private final TicketCategoryRepository catRepo;

    public TicketServiceImpl(TicketRepository t, UserRepository u, TicketCategoryRepository c) {
        this.ticketRepo = t;
        this.userRepo = u;
        this.catRepo = c;
    }

    public Ticket createTicket(Long userId, Long catId, Ticket ticket) {
        if (ticket.getDescription().length() < 10) {
            throw new RuntimeException("description too short");
        }
        ticket.setUser(userRepo.findById(userId).orElseThrow(() -> new RuntimeException("not found")));
        ticket.setCategory(catRepo.findById(catId).orElseThrow(() -> new RuntimeException("not found")));
        return ticketRepo.save(ticket);
    }
}
