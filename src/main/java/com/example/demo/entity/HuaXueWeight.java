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
    @Column(name="上限")
    private double high;
    @Column(name="下限")
    private double low;

    public HuaXueWeight() {
        super();
    }

    public HuaXueWeight(String name, double high, double low) {
        this.name = name;
        this.high = high;
        this.low = low;
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

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }
}
