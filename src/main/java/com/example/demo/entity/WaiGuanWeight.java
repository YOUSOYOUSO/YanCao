package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_waiguanweight")
public class WaiGuanWeight {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="外观名")
    private String name;
    @Column(name="描述")
    private String describes;
    @Column(name="取值")
    private String values;
    @Column(name="描述id")
    private int describe;
    @Column(name="取值id")
    private int value;
    @Column(name="权重")
    private int score;

    public WaiGuanWeight() {
        super();
    }

    public WaiGuanWeight(String name, String describes, String values, int describe, int value, int score) {
        this.name = name;
        this.describes = describes;
        this.values = values;
        this.describe = describe;
        this.value = value;
        this.score = score;
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public int getDescribe() {
        return describe;
    }

    public void setDescribe(int describe) {
        this.describe = describe;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
