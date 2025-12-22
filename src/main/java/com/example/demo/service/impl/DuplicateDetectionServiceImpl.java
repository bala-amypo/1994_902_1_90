package com.example.demo.service.impl;

import com.example.demo.entity.DuplicateDetectionLog;
import com.example.demo.entity.Ticket;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateDetectionServiceImpl {

    private final TicketRepository ticketRepo;
    private final DuplicateDetectionLogRepository logRepo;

    public DuplicateDetectionServiceImpl(
            TicketRepository ticketRepo,
            DuplicateDetectionLogRepository logRepo) {
        this.ticketRepo = ticketRepo;
        this.logRepo = logRepo;
    }

    public void detectDuplicates(Ticket ticket) {
        List<Ticket> tickets = ticketRepo.findAll();

        for (Ticket t : tickets) {
            double score = calculateSimilarity(
                    ticket.getDescription(),
                    t.getDescription()
            );

            if (score > 0.5) {
                DuplicateDetectionLog log = new DuplicateDetectionLog();
                log.setTicket(ticket);
                log.setMatchedTicket(t);
                log.setMatchScore(score);
                logRepo.save(log);
            }
        }
    }

    // ✅ ALTERNATE METHOD (no util class)
    private double calculateSimilarity(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0.0;
        }
        if (text1.equalsIgnoreCase(text2)) {
            return 1.0;
        }
        return 0.3;
    }
}
