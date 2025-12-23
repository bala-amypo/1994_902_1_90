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
    private LocalDateTime createdAt;

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
        this.fullname=fullname;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String Password){
        this.password=password;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role=role;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getCreatedAt(){
        return cre
    }
    public User(Long id,String fullName,String email,String password,String role,)
}
