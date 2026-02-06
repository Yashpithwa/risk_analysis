package com.example.cross_currency_risk.domain;


import jakarta.persistence.*;

@Entity
@Table(name= "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true,nullable=false)
    private String name;

    public Role(){}

    public Role(String name){
        this.name=name;
    }

    public long getId(){return  id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
}
