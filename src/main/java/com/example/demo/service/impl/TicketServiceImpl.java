package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Ticket;
import com.example.demo.model.User;
import com.example.demo.model.TicketCategory;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.TicketCategoryRepository;
import com.example.demo.service.TicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
  private final TicketRepository repo;
  private final UserRepository userRepo;
  private final TicketCategoryRepository categoryRepo;

  public TicketServiceImpl(TicketRepository repo, UserRepository userRepo, TicketCategoryRepository categoryRepo) {
    this.repo = repo;
    this.userRepo = userRepo;
    this.categoryRepo = categoryRepo;
  }

  @Override
  public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
    User u = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    TicketCategory c = categoryRepo.findById(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    if (ticket.getSubject() == null || ticket.getSubject().isBlank())
      throw new IllegalArgumentException("Subject required");
    if (ticket.getDescription() == null || ticket.getDescription().length() < 10)
      throw new IllegalArgumentException("Description too short");
    ticket.setUser(u);
    ticket.setCategory(c);
    return repo.save(ticket);
  }

  @Override
  public Ticket getTicket(Long ticketId) {
    return repo.findById(ticketId).orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
  }

  @Override
  public List<Ticket> getTicketsByUser(Long userId) {
    return repo.findByUser_Id(userId);
  }

  @Override
  public List<Ticket> getAllTickets() {
    return repo.findAll();
  }
}
