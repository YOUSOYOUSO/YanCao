package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_PingXi")//表名
public class PingXi {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "xiangqizhi")//香气质状态
    private int xiangqizhi;

    @Column(name = "xiangqiliang")//香气量状态
    private int xiangqiliang;


    @Column(name = "zaqi")//杂气状态
    private int zaqi;

    @Column(name = "cijixing")//刺激性状态
    private int cijixing;

    @Column(name = "yuwei")//余味状态
    private int yuwei;

    @Column(name = "ranshaoxing")//燃烧性状态
    private int ranshaoxing;

    @Column(name = "huidu")//灰色状态
    private int huidu;

    @Column(name = "nongdu")//浓度状态
    private int nongdu;
    @Column(name = "jintou")//浓度状态
    private int jintou;
    @Column(name = "chengtuanxing")//成团性状态
    private int chengtuanxing;

    @Column(name = "xinidu")//细腻度状态
    private int xinidu;

    @Column(name = "huitiangan")//回甜感状态
    private int huitiangan;

    @Column(name = "ganzaogan")//干燥感状态
    private int ganzaogan;
    public int[] getArray(){
        int[] array=new int[]{xiangqizhi,xiangqiliang,zaqi,cijixing,yuwei,ranshaoxing,huidu,nongdu,jintou,chengtuanxing,xinidu,huitiangan,ganzaogan};
        return array;
    }
    public PingXi(){
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getXiangqizhi() {
        return xiangqizhi;
    }

    public int getJintou() {
        return jintou;
    }

    public void setJintou(int jintou) {
        this.jintou = jintou;
    }

    public void setXiangqizhi(int xiangqizhi) {
        this.xiangqizhi = xiangqizhi;
    }

    public int getXiangqiliang() {
        return xiangqiliang;
    }

    public void setXiangqiliang(int xiangqiliang) {
        this.xiangqiliang = xiangqiliang;
    }

    public int getZaqi() {
        return zaqi;
    }

    public void setZaqi(int zaqi) {
        this.zaqi = zaqi;
    }

    public int getCijixing() {
        return cijixing;
    }

    public void setCijixing(int cijixing) {
        this.cijixing = cijixing;
    }

    public int getYuwei() {
        return yuwei;
    }

    public void setYuwei(int yuwei) {
        this.yuwei = yuwei;
    }

    public int getRanshaoxing() {
        return ranshaoxing;
    }

    public void setRanshaoxing(int ranshaoxing) {
        this.ranshaoxing = ranshaoxing;
    }

    public int getHuidu() {
        return huidu;
    }

    public void setHuidu(int huidu) {
        this.huidu = huidu;
    }

    public int getNongdu() {
        return nongdu;
    }

    public void setNongdu(int nongdu) {
        this.nongdu = nongdu;
    }

    public int getChengtuanxing() {
        return chengtuanxing;
    }

    public void setChengtuanxing(int chengtuanxing) {
        this.chengtuanxing = chengtuanxing;
    }

    public int getXinidu() {
        return xinidu;
    }

    public void setXinidu(int xinidu) {
        this.xinidu = xinidu;
    }

    public int getHuitiangan() {
        return huitiangan;
    }

    public void setHuitiangan(int huitiangan) {
        this.huitiangan = huitiangan;
    }

    public int getGanzaogan() {
        return ganzaogan;
    }

    public void setGanzaogan(int ganzaogan) {
        this.ganzaogan = ganzaogan;
    }
}