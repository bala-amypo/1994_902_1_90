package com.example.demo.config;

import com.example.demo.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
  private final Key key;
  private final long jwtExpirationMs;

  public JwtUtil(@Value("${app.jwtSecret}") String jwtSecret, @Value("${app.jwtExpirationMs}") long jwtExpirationMs) {
    this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    this.jwtExpirationMs = jwtExpirationMs;
  }

  public String generateToken(User u) {
    Date now = new Date();
    Date exp = new Date(now.getTime() + jwtExpirationMs);
    return Jwts.builder().setSubject(u.getEmail())
        .addClaims(
            Map.of("role", u.getRole(), "email", u.getEmail(), "userId", u.getId() == null ? "" : u.getId().toString()))
        .setIssuedAt(now).setExpiration(exp).signWith(key).compact();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  public Claims getClaims(String token) {
    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
  }

  public String getEmailFromToken(String token) {
    return getClaims(token).getSubject();
  }
}
