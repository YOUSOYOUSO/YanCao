package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tb_huaxue")//表名
public class HuaXue {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="sbyyanjian")
    private double sbyyanjian;

    @Column(name="zbyyanjian")
    private double zbyyanjian;

    @Column(name="xbyyanjian")
    private double xbyyanjian;

    @Column(name="zongtang")
    private double zongtang;

    @Column(name="zonglv")
    private double zonglv;

    @Column(name="niguding")
    private double niguding;

    @Column(name="jia_pf")
    private double jia;

    @Column(name="huanyuantang")
    private double huanyuantang;

    @Column(name="zongdan")
    private double zongdan;
    public HuaXue(){
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


public double[] getArray(){
        double[] array;
        array= new double[]{sbyyanjian, zbyyanjian,xbyyanjian,zongtang,huanyuantang,jia,zonglv,niguding,zongdan};
    return array;
}

    public double getZbyyanjian() {
        return zbyyanjian;
    }

    public void setZbyyanjian(double zbyyanjian) {
        this.zbyyanjian = zbyyanjian;
    }

    public double getXbyyanjian() {
        return xbyyanjian;
    }

    public void setXbyyanjian(double xbyyanjian) {
        this.xbyyanjian = xbyyanjian;
    }

    public double getZongtang() {
        return zongtang;
    }

    public void setZongtang(double zongtang) {
        this.zongtang = zongtang;
    }

    public double getZonglv() {
        return zonglv;
    }

    public void setZonglv(double zonglv) {
        this.zonglv = zonglv;
    }

    public double getNiguding() {
        return niguding;
    }

    public void setNiguding(double niguding) {
        this.niguding = niguding;
    }

    public double getJia() {
        return jia;
    }

    public void setJia(double jia) {
        this.jia = jia;
    }

    public double getHuanyuantang() {
        return huanyuantang;
    }

    public void setHuanyuantang(double huanyuantang) {
        this.huanyuantang = huanyuantang;
    }

    public double getZongdan() {
        return zongdan;
    }

    public void setZongdan(double zongdan) {
        this.zongdan = zongdan;
    }


    public double getSbyyanjian() {
        return sbyyanjian;
    }

    public void setSbyyanjian(double sbyyanjian) {
        this.sbyyanjian = sbyyanjian;
    }
}