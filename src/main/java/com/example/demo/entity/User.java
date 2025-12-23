package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String password;
    private String role;

    @Column(unique = true)
    private String email;

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getFullName(){
        return fullName;
    }
    public void setFullName(){
        this.
    }

    public String getEmail() {
        return email;
    }
}
