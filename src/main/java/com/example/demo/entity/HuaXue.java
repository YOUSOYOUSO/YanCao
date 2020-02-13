package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_huaxue")//表名
public class HuaXue {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="sbyyanjian")
    private int sbyyanjian;

    @Column(name="zbyyanjian")
    private int zbyyanjian;

    @Column(name="xbyyanjian")
    private int xbyyanjian;

    @Column(name="zongtang")
    private int zongtang;

    @Column(name="zonglv")
    private int zonglv;

    @Column(name="niguding")
    private int niguding;

    @Column(name="jia_pf")
    private int jia;

    @Column(name="huanyuantang")
    private int huanyuantang;

    @Column(name="zongdan")
    private int zongdan;
    public HuaXue(){
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSbyyanjian() {
        return sbyyanjian;
    }

    public void setSbyyanjian(int sbyyanjian) {
        this.sbyyanjian = sbyyanjian;
    }

    public int getZbyyanjian() {
        return zbyyanjian;
    }

    public void setZbyyanjian(int zbyyanjian) {
        this.zbyyanjian = zbyyanjian;
    }

    public int getXbyyanjian() {
        return xbyyanjian;
    }

    public void setXbyyanjian(int xbyyanjian) {
        this.xbyyanjian = xbyyanjian;
    }

    public int getZongtang() {
        return zongtang;
    }

    public void setZongtang(int zongtang) {
        this.zongtang = zongtang;
    }

    public int getZonglv() {
        return zonglv;
    }

    public void setZonglv(int zonglv) {
        this.zonglv = zonglv;
    }

    public int getNiguding() {
        return niguding;
    }

    public void setNiguding(int niguding) {
        this.niguding = niguding;
    }

    public int getJia() {
        return jia;
    }

    public void setJia(int jia) {
        this.jia = jia;
    }

    public int getHuanyuantang() {
        return huanyuantang;
    }

    public void setHuanyuantang(int huanyuantang) {
        this.huanyuantang = huanyuantang;
    }

    public int getZongdan() {
        return zongdan;
    }

    public void setZongdan(int zongdan) {
        this.zongdan = zongdan;
    }
}