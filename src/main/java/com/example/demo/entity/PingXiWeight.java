package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_pingxiweight")
public class PingXiWeight {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="评析名")
    private String name;
    @Column(name="描述")
    private String describes;
    @Column(name="描述id")
    private int describe;
    @Column(name="权重")
    private int score;

    public PingXiWeight() {
        super();
    }

    public PingXiWeight(String name, String describes, int describe, int score) {
        super();
        this.name = name;
        this.describes = describes;
        this.describe = describe;
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

    public int getDescribe() {
        return describe;
    }

    public void setDescribe(int describe) {
        this.describe = describe;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
