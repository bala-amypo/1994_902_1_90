package com.example.project.Entity;

import jakarta.persistence.Entity;
import jakarta.presistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.id;

@Entity

public class studentEntity{
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    public int getId{
        return id;
    }
public void setid(Integer id){
    this.id=id;
}
public String getName(){
    return name;
}
public void setName(String name){
    this.name=name;
}
public void setEmail(String email){
    this.email=email;
}
public void setDob(LocalDate dob){
    this.dob=dob;
}
public float getCgpa(){
    return cgpa;
}
public void setCgpa(float cgpa){
    this.cgpa=cgpa;
}
public student(Integer id,String name,String email,LocalDate dob,float cgpa){
    thisid=id;
    this.name=name;
    this.email=email;
    this.dob=dob;
    this.cgpa=cgpa;
}