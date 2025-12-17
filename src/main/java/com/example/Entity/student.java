package com.example.project.Entity;


import java.time.LocalDate;

public class student{
    private int id;
    private String name;
    private String email;
    private LocalDate dob;
    private flost cgpa;
}
public int getid(){
    return id;
}
public void setid(int id){
    thisid=id;
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
public student(int id,String name,String email,LocalDate dob,float cgpa){
    thisid=id;
    this.name=name;
    this.email=email;
    this.dob=dob;
    this.cgpa=cgpa;
}