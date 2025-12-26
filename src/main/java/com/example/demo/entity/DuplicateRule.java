package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "duplicate_rules", uniqueConstraints = { @UniqueConstraint(columnNames = "ruleName") })
public class DuplicateRule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String ruleName;
  @NotBlank
  private String matchType; // KEYWORD / SIMILARITY / EXACT_MATCH
  private Double threshold = 0.8;
  private LocalDateTime createdAt = LocalDateTime.now();

  public DuplicateRule() {
  }

  public DuplicateRule(String ruleName, String matchType, Double threshold) {
    this.ruleName = ruleName;
    this.matchType = matchType;
    this.threshold = threshold;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRuleName() {
    return ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }

  public String getMatchType() {
    return matchType;
  }

  public void setMatchType(String matchType) {
    this.matchType = matchType;
  }

  public Double getThreshold() {
    return threshold;
  }

  public void setThreshold(Double threshold) {
    this.threshold = threshold;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
