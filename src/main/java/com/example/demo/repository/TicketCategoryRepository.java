package com.example.demo.repository;

import com.example.demo.entity.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCategoryRepository
        extends JpaRepository<TicketCategory, Long> {
}
