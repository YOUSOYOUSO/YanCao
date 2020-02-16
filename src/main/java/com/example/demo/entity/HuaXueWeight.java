package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_huaxueweight")
public class HuaXueWeight {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="化学名")
    private String name;
    @Column(name="权重")
    private double weight;

    public HuaXueWeight() {
        super();
    }

    public HuaXueWeight(String name, double weight) {
        super();
        this.name = name;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
