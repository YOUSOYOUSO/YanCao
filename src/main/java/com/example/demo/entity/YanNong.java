package com.example.demo.entity;

import javax.persistence.*;
@Entity
@Table(name="tb_yannong")
public class YanNong {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private long id;
        @Column(name="name")//对应的列名
        private String name;
        @Column(name="yantian")//对应的列名
        private String yantian;

        public YanNong(){

    }

    public YanNong(long id, String name, String yantian) {
        this.id = id;
        this.name = name;
        this.yantian = yantian;
    }

    public void setId(long id){
            this.id =id;
    }
    public String getYantian() {
        return yantian;
    }

    public void setYantian(String yantian) {
        this.yantian = yantian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }
}
