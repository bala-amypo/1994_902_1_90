package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepo;
    private final UserRepository userRepo;
    private final TicketCategoryRepository categoryRepo;

    public TicketServiceImpl(TicketRepository ticketRepo,
                             UserRepository userRepo,
                             TicketCategoryRepository categoryRepo) {
        this.ticketRepo = ticketRepo;
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
        User user = userRepo.findById(userId).orElseThrow();
        TicketCategory category = categoryRepo.findById(categoryId).orElseThrow();

        ticket.setUser(user);
        ticket.setCategory(category);

        return ticketRepo.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }
}
