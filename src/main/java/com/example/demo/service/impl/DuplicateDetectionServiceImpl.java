package com.example.demo.service.impl;

import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.util.TextSimilarityUtil;
import org.springframework.stereotype.service;
import java.util.*;

@Service
public class DuplicateDetectionServiceImpl
        implements DuplicateDetectionService {

    private final TicketRepository ticketRepo;
    private final DuplicateRuleRepository ruleRepo;
    private final DuplicateDetectionLogRepository logRepo;

    public DuplicateDetectionServiceImpl(
            TicketRepository ticketRepo,
            DuplicateRuleRepository ruleRepo,
            DuplicateDetectionLogRepository logRepo) {
        this.ticketRepo = ticketRepo;
        this.ruleRepo = ruleRepo;
        this.logRepo = logRepo;
    }

    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {

        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("not found"));

        List<DuplicateDetectionLog> logs = new ArrayList<>();

        for (Ticket t : ticketRepo.findByStatus("OPEN")) {
            if (!t.getId().equals(ticketId)) {
                double score = TextSimilarityUtil.similarity(
                        ticket.getDescription(), t.getDescription());

                if (score >= 0.5) {
                    DuplicateDetectionLog log = new DuplicateDetectionLog();
                    log.setTicket(ticket);
                    log.setMatchedTicket(t);
                    log.setMatchScore(score);
                    logs.add(logRepo.save(log));
                }
            }
        }
        return logs;
    }

    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepo.findByTicket_Id(ticketId);
    }

    public DuplicateDetectionLog getLog(Long id) {
        return logRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}
