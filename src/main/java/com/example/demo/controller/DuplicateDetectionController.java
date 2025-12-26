package com.example.demo.controller;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Duplicate Detection")
@RestController
@RequestMapping("/api/detection")
public class DuplicateDetectionController {
  private final DuplicateDetectionService service;

  public DuplicateDetectionController(DuplicateDetectionService service) {
    this.service = service;
  }

  @GetMapping("/run/{ticketId}")
  public ResponseEntity<List<DuplicateDetectionLog>> run(@PathVariable Long ticketId) {
    return ResponseEntity.ok(service.detectDuplicates(ticketId));
  }

  @GetMapping("/ticket/{ticketId}")
  public ResponseEntity<List<DuplicateDetectionLog>> logs(@PathVariable Long ticketId) {
    return ResponseEntity.ok(service.getLogsForTicket(ticketId));
  }

  @GetMapping("/{id}")
  public ResponseEntity<DuplicateDetectionLog> get(@PathVariable Long id) {
    return ResponseEntity.ok(service.getLog(id));
  }
}
