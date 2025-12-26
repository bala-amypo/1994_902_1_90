package com.example.demo.repository;

import com.example.demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
  List<Ticket> findByCategory_Id(Long categoryId);

  List<Ticket> findByUser_Id(Long userId);

  List<Ticket> findByStatus(String status);

  List<Ticket> findBySubjectContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String s1, String s2);
}
