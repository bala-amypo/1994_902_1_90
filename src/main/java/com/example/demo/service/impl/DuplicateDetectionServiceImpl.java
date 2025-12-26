package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.model.DuplicateRule;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;
import com.example.demo.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepository;
    private final DuplicateRuleRepository ruleRepository;
    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionServiceImpl(TicketRepository ticketRepository,
            DuplicateRuleRepository ruleRepository,
            DuplicateDetectionLogRepository logRepository) {
        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.logRepository = logRepository;
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {

        Ticket base = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        List<Ticket> openTickets = ticketRepository.findByStatus("OPEN");
        List<DuplicateRule> rules = ruleRepository.findAll();
        List<DuplicateDetectionLog> logs = new ArrayList<>();

        for (Ticket other : openTickets) {

            Long baseId = base.getId();
            Long otherId = other.getId();

            if (baseId != null && otherId != null && baseId.equals(otherId)) {
                continue; // skip same ticket
            }

            for (DuplicateRule rule : rules) {

                double score = 0;

                switch (rule.getMatchType()) {

                    case "EXACT_MATCH" -> {
                        if (base.getSubject() != null &&
                                other.getSubject() != null &&
                                base.getSubject().equalsIgnoreCase(other.getSubject())) {
                            score = 1.0;
                        }
                    }

                    case "KEYWORD" -> {
                        score = TextSimilarityUtil.similarity(
                                base.getSubject() + " " + base.getDescription(),
                                other.getSubject() + " " + other.getDescription());
                    }

                    case "SIMILARITY" -> {
                        score = TextSimilarityUtil.similarity(
                                base.getDescription(),
                                other.getDescription());
                    }
                }

                // If rule applies
                if (score >= rule.getThreshold()) {
                    DuplicateDetectionLog log = new DuplicateDetectionLog(base, other, score);
                    log.setDetectedAt(LocalDateTime.now());
                    logs.add(logRepository.save(log));
                }
            }
        }
        return logs;
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }

    @Override
    public DuplicateDetectionLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detection log not found"));
    }
}
