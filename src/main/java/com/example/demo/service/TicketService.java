package com.example.demo.service;

import com.example.demo.entity.Ticket;
import java.util.List;

public interface TicketService {

    Ticket createTicket(Long userId, Long categoryId, Ticket ticket);

    Ticket getTicketById(Long id);

    List<Ticket> getAllTickets();
}
