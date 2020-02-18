package com.example.demo.entity;


import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_quality")
public class Quality {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long quality_id;

    @Column(name="产品编号")
    private String qualityname;

    @Column(name="用户id")
    private long userid;
    @Column(name="化学id")
    private long huaxueid;
    @Column(name="外观id")
    private long waiguanid;
    @Column(name="评吸id")
    private long pingxiid;
    @Column(name="添加完毕")
    private boolean flag;
    @Column(name="采购日期")
    private Date caigouriqi;
    @Column(name="烟农名称")
    private  String yannongname;
    @Column(name = "yantian")
    private  String yantian;

    private String state;
    public Quality(){
        super();
    }

    public long getQuality_id() {
        return quality_id;
    }


   public Quality(String qualityname,long userid,long huaxueid,long waiguanid,long pingxiid,boolean flag){
        this.qualityname=qualityname;
        this.userid=userid;
        this.huaxueid=huaxueid;
        this.waiguanid=waiguanid;
        this.pingxiid=pingxiid;
        this.flag=flag;
   }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setQuality_id(long quality_id) {
        this.quality_id = quality_id;
    }

    public String getQualityname() {
        return qualityname;
    }

    public void setQualityname(String qualityname) {
        this.qualityname = qualityname;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getHuaxueid() {
        return huaxueid;
    }

    public void setHuaxueid(long huaxueid) {
        this.huaxueid = huaxueid;
    }

    public long getWaiguanid() {
        return waiguanid;
    }

    public void setWaiguanid(long waiguanid) {
        this.waiguanid = waiguanid;
    }

    public long getPingxiid() {
        return pingxiid;
    }

    public void setPingxiid(long pingxiid) {
        this.pingxiid = pingxiid;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this) + "\n";
    }



    public Date getCaigouriqi() {
        return caigouriqi;
    }

    public void setCaigouriqi(Date caigouriqi) {
        this.caigouriqi = caigouriqi;
    }

    public String getYantian() {
        return yantian;
    }

    public void setYantian(String yantian) {
        this.yantian = yantian;
    }


    public String getYannongname() {
        return yannongname;
    }

    public void setYannongname(String yannongname) {
        this.yannongname = yannongname;
    }
}
