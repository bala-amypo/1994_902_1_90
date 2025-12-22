package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.util.TextSimilarityUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateDetectionServiceImpl {

    private final TicketRepository ticketRepo;
    private final DuplicateDetectionLogRepository logRepo;

    public DuplicateDetectionServiceImpl(TicketRepository ticketRepo,
                                         DuplicateDetectionLogRepository logRepo) {
        this.ticketRepo = ticketRepo;
        this.logRepo = logRepo;
    }

    public void detectDuplicates(Ticket ticket) {
        List<Ticket> tickets = ticketRepo.findByStatus("OPEN");

        for (Ticket t : tickets) {
            double score = TextSimilarityUtil.similarity(
                    ticket.getDescription(),
                    t.getDescription()
            );

            if (score > 0.7) {
                DuplicateDetectionLog log = new DuplicateDetectionLog();
                log.setTicket(ticket);
                log.setMatchedTicket(t);
                log.setMatchScore(score);
                logRepo.save(log);
            }
        }
    }
}
