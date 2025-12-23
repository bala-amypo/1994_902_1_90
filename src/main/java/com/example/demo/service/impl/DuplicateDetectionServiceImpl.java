package com.example.demo.service.impl;

import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;

@Service   // 🔴 THIS IS MANDATORY
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    @Override
    public String checkDuplicate(Long ticketId) {
        // temporary logic
        return "NO_DUPLICATE";
    }
}
