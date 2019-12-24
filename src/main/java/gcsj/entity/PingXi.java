package gcsj.entity;

import javax.persistence.*;

@Entity
@Table(name="PingXi")//表名
public class PingXi {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "xiangqizhi_zt")//香气质状态
    private String xiangqizhi_zt;
    @Column(name = "xiangqizhi_pf")//香气质评分
    private int xiangqizhi_pf;

    @Column(name = "xiangqiliang_zt")//香气量状态
    private String xiangqiliang_zt;
    @Column(name = "xiangqiliang_pf")//香气量评分
    private int xiangqiliang_pf;

    @Column(name = "zaqi_zt")//杂气状态
    private String zaqi_zt;
    @Column(name = "zaqi_pf")//杂气评分
    private int zaqi_pf;

    @Column(name = "cijixing_zt")//刺激性状态
    private String cijixing_zt;
    @Column(name = "cijixing_pf")//刺激性评分
    private int cijixing_pf;

    @Column(name = "yuwei_zt")//余味状态
    private String yuwei_zt;
    @Column(name = "yuwei_pf")//余味评分
    private int yuwei_pf;

    @Column(name = "ranshaoxing_zt")//燃烧性状态
    private String ranshaoxing_zt;
    @Column(name = "ranshaoxing_pf")//燃烧性评分
    private int ranshaoxing_pf;

    @Column(name = "huidu_zt")//灰色状态
    private String huidu_zt;
    @Column(name = "huidu_pf")//灰色评分
    private int huidu_pf;

    @Column(name = "nongdu_zt")//浓度状态
    private String nongdu_zt;
    @Column(name = "nongdu_pf")//浓度评分
    private int nongdu_pf;

    @Column(name = "chengtuanxing_zt")//成团性状态
    private String chengtuanxing_zt;
    @Column(name = "chengtuanxing_pf")//成团性评分
    private int chengtuanxing_pf;

    @Column(name = "xinidu_zt")//细腻度状态
    private String xinidu_zt;
    @Column(name = "xinidu_pf")//细腻度评分
    private int xinidu_pf;

    @Column(name = "huitiangan_zt")//回甜感状态
    private String huitiangan_zt;
    @Column(name = "huitiangan_pf")//回甜感评分
    private int huitiangan_pf;

    @Column(name = "ganzaogan_zt")//干燥感状态
    private String ganzaogan_zt;
    @Column(name = "ganzaogan_pf")//干燥感评分
    private int ganzaogan_pf;

    public PingXi(long id, String xiangqizhi_zt, int xiangqizhi_pf, String xiangqiliang_zt, int xiangqiliang_pf, String zaqi_zt, int zaqi_pf, String cijixing_zt, int cijixing_pf, String yuwei_zt, int yuwei_pf, String ranshaoxing_zt, int ranshaoxing_pf, String huidu_zt, int huidu_pf, String nongdu_zt, int nongdu_pf, String chengtuanxing_zt, int chengtuanxing_pf, String xinidu_zt, int xinidu_pf, String huitiangan_zt, int huitiangan_pf, String ganzaogan_zt, int ganzaogan_pf) {
        this.id = id;
        this.xiangqizhi_zt = xiangqizhi_zt;
        this.xiangqizhi_pf = xiangqizhi_pf;
        this.xiangqiliang_zt = xiangqiliang_zt;
        this.xiangqiliang_pf = xiangqiliang_pf;
        this.zaqi_zt = zaqi_zt;
        this.zaqi_pf = zaqi_pf;
        this.cijixing_zt = cijixing_zt;
        this.cijixing_pf = cijixing_pf;
        this.yuwei_zt = yuwei_zt;
        this.yuwei_pf = yuwei_pf;
        this.ranshaoxing_zt = ranshaoxing_zt;
        this.ranshaoxing_pf = ranshaoxing_pf;
        this.huidu_zt = huidu_zt;
        this.huidu_pf = huidu_pf;
        this.nongdu_zt = nongdu_zt;
        this.nongdu_pf = nongdu_pf;
        this.chengtuanxing_zt = chengtuanxing_zt;
        this.chengtuanxing_pf = chengtuanxing_pf;
        this.xinidu_zt = xinidu_zt;
        this.xinidu_pf = xinidu_pf;
        this.huitiangan_zt = huitiangan_zt;
        this.huitiangan_pf = huitiangan_pf;
        this.ganzaogan_zt = ganzaogan_zt;
        this.ganzaogan_pf = ganzaogan_pf;
    }

    public String getXiangqizhi_zt() {
        return xiangqizhi_zt;
    }

    public void setXiangqizhi_zt(String xiangqizhi_zt) {
        this.xiangqizhi_zt = xiangqizhi_zt;
    }

    public int getXiangqizhi_pf() {
        return xiangqizhi_pf;
    }

    public void setXiangqizhi_pf(int xiangqizhi_pf) {
        this.xiangqizhi_pf = xiangqizhi_pf;
    }

    public String getXiangqiliang_zt() {
        return xiangqiliang_zt;
    }

    public void setXiangqiliang_zt(String xiangqiliang_zt) {
        this.xiangqiliang_zt = xiangqiliang_zt;
    }

    public int getXiangqiliang_pf() {
        return xiangqiliang_pf;
    }

    public void setXiangqiliang_pf(int xiangqiliang_pf) {
        this.xiangqiliang_pf = xiangqiliang_pf;
    }

    public String getZaqi_zt() {
        return zaqi_zt;
    }

    public void setZaqi_zt(String zaqi_zt) {
        this.zaqi_zt = zaqi_zt;
    }

    public int getZaqi_pf() {
        return zaqi_pf;
    }

    public void setZaqi_pf(int zaqi_pf) {
        this.zaqi_pf = zaqi_pf;
    }

    public String getCijixing_zt() {
        return cijixing_zt;
    }

    public void setCijixing_zt(String cijixing_zt) {
        this.cijixing_zt = cijixing_zt;
    }

    public int getCijixing_pf() {
        return cijixing_pf;
    }

    public void setCijixing_pf(int cijixing_pf) {
        this.cijixing_pf = cijixing_pf;
    }

    public String getYuwei_zt() {
        return yuwei_zt;
    }

    public void setYuwei_zt(String yuwei_zt) {
        this.yuwei_zt = yuwei_zt;
    }

    public int getYuwei_pf() {
        return yuwei_pf;
    }

    public void setYuwei_pf(int yuwei_pf) {
        this.yuwei_pf = yuwei_pf;
    }

    public String getRanshaoxing_zt() {
        return ranshaoxing_zt;
    }

    public void setRanshaoxing_zt(String ranshaoxing_zt) {
        this.ranshaoxing_zt = ranshaoxing_zt;
    }

    public int getRanshaoxing_pf() {
        return ranshaoxing_pf;
    }

    public void setRanshaoxing_pf(int ranshaoxing_pf) {
        this.ranshaoxing_pf = ranshaoxing_pf;
    }

    public String getHuidu_zt() {
        return huidu_zt;
    }

    public void setHuidu_zt(String huidu_zt) {
        this.huidu_zt = huidu_zt;
    }

    public int getHuidu_pf() {
        return huidu_pf;
    }

    public void setHuidu_pf(int huidu_pf) {
        this.huidu_pf = huidu_pf;
    }

    public String getNongdu_zt() {
        return nongdu_zt;
    }

    public void setNongdu_zt(String nongdu_zt) {
        this.nongdu_zt = nongdu_zt;
    }

    public int getNongdu_pf() {
        return nongdu_pf;
    }

    public void setNongdu_pf(int nongdu_pf) {
        this.nongdu_pf = nongdu_pf;
    }

    public String getChengtuanxing_zt() {
        return chengtuanxing_zt;
    }

    public void setChengtuanxing_zt(String chengtuanxing_zt) {
        this.chengtuanxing_zt = chengtuanxing_zt;
    }

    public int getChengtuanxing_pf() {
        return chengtuanxing_pf;
    }

    public void setChengtuanxing_pf(int chengtuanxing_pf) {
        this.chengtuanxing_pf = chengtuanxing_pf;
    }

    public String getXinidu_zt() {
        return xinidu_zt;
    }

    public void setXinidu_zt(String xinidu_zt) {
        this.xinidu_zt = xinidu_zt;
    }

    public int getXinidu_pf() {
        return xinidu_pf;
    }

    public void setXinidu_pf(int xinidu_pf) {
        this.xinidu_pf = xinidu_pf;
    }

    public String getHuitiangan_zt() {
        return huitiangan_zt;
    }

    public void setHuitiangan_zt(String huitiangan_zt) {
        this.huitiangan_zt = huitiangan_zt;
    }

    public int getHuitiangan_pf() {
        return huitiangan_pf;
    }

    public void setHuitiangan_pf(int huitiangan_pf) {
        this.huitiangan_pf = huitiangan_pf;
    }

    public String getGanzaogan_zt() {
        return ganzaogan_zt;
    }

    public void setGanzaogan_zt(String ganzaogan_zt) {
        this.ganzaogan_zt = ganzaogan_zt;
    }

    public int getGanzaogan_pf() {
        return ganzaogan_pf;
    }

    public void setGanzaogan_pf(int ganzaogan_pf) {
        this.ganzaogan_pf = ganzaogan_pf;
    }
}