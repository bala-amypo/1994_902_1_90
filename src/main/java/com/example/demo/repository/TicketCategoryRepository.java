package com.example.demo.repository;

import com.example.demo.model.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {
  Optional<TicketCategory> findByCategoryName(String categoryName);

  boolean existsByCategoryName(String categoryName);
}
