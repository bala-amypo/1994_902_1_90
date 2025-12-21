package com.example.demo.service.Impl;

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

    public TicketServiceImpl(
            TicketRepository ticketRepo,
            UserRepository userRepo,
            TicketCategoryRepository categoryRepo) {
        this.ticketRepo = ticketRepo;
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
    }

    public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {

        if (ticket.getDescription().length() < 10) {
            throw new RuntimeException("description too short");
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("not found"));

        TicketCategory category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("not found"));

        ticket.setUser(user);
        ticket.setCategory(category);

        return ticketRepo.save(ticket);
    }

    public Ticket getTicket(Long id) {
        return ticketRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<Ticket> getTicketsByUser(Long userId) {
        return ticketRepo.findByUser_Id(userId);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }
}
