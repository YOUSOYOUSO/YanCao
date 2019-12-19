package gcsj.entity;

import javax.persistence.*;
import com.alibaba.fastjson.*;
@Entity
@Table(name="tb_waiguan")//表名
public class WaiGuan {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long waiguan_id;

    @Column(name="yanse_zt")//颜色
    private String yanse_zt;

    @Column(name="yanse_pf")//对应的列名
    private int yanse_pf;

    @Column(name="chengshudu_zt")//成熟度
    private String chengshudu_zt;

    @Column(name="chengshudu_pf")//对应的列名
    private int chengshudu_pf;

    @Column(name="youfen_zt")//油分
    private String youfen_zt;

    @Column(name="youfen_pf")//对应的列名
    private int youfen_pf;

    @Column(name="jiegou_zt")//结构
    private String jiegou_zt;

    @Column(name="jiegou_pf")//对应的列名
    private int jiegou_pf;

    @Column(name="shenfen_zt")//身份
    private String shenfen_zt;

    @Column(name="shenfen_pf")//对应的列名
    private int shenfen_pf;

    @Column(name="sedu_zt")//色度
    private String sedu_zt;

    @Column(name="sedu_pf")//对应的列名
    private int sedu_pf;


    public WaiGuan(){

    }
    public WaiGuan(String youfen_zt, int youfen_pf, String jiegou_zt, int jiegou_pf, String shenfen_zt, int shenfen_pf, String sedu_zt, int sedu_pf) {

        this.youfen_zt = youfen_zt;
        this.youfen_pf = youfen_pf;
        this.jiegou_zt = jiegou_zt;
        this.jiegou_pf = jiegou_pf;
        this.shenfen_zt = shenfen_zt;
        this.shenfen_pf = shenfen_pf;
        this.sedu_zt = sedu_zt;
        this.sedu_pf = sedu_pf;
    }

    public long getWaiguan_id() {
        return waiguan_id;
    }

    public void setWaiguan_id(long waiguan_id) {
        this.waiguan_id = waiguan_id;
    }

    public String getYanse_zt() {
        return yanse_zt;
    }

    public void setYanse_zt(String yanse_zt) {
        this.yanse_zt = yanse_zt;
    }

    public int getYanse_pf() {
        return yanse_pf;
    }

    public void setYanse_pf(int yanse_pf) {
        this.yanse_pf = yanse_pf;
    }

    public String getChengshudu_zt() {
        return chengshudu_zt;
    }

    public void setChengshudu_zt(String chengshudu_zt) {
        this.chengshudu_zt = chengshudu_zt;
    }

    public int getChengshudu_pf() {
        return chengshudu_pf;
    }

    public void setChengshudu_pf(int chengshudu_pf) {
        this.chengshudu_pf = chengshudu_pf;
    }

    public String getYoufen_zt() {
        return youfen_zt;
    }

    public void setYoufen_zt(String youfen_zt) {
        this.youfen_zt = youfen_zt;
    }

    public int getYoufen_pf() {
        return youfen_pf;
    }

    public void setYoufen_pf(int youfen_pf) {
        this.youfen_pf = youfen_pf;
    }

    public String getJiegou_zt() {
        return jiegou_zt;
    }

    public void setJiegou_zt(String jiegou_zt) {
        this.jiegou_zt = jiegou_zt;
    }

    public int getJiegou_pf() {
        return jiegou_pf;
    }

    public void setJiegou_pf(int jiegou_pf) {
        this.jiegou_pf = jiegou_pf;
    }

    public String getShenfen_zt() {
        return shenfen_zt;
    }

    public void setShenfen_zt(String shenfen_zt) {
        this.shenfen_zt = shenfen_zt;
    }

    public int getShenfen_pf() {
        return shenfen_pf;
    }

    public void setShenfen_pf(int shenfen_pf) {
        this.shenfen_pf = shenfen_pf;
    }

    public String getSedu_zt() {
        return sedu_zt;
    }

    public void setSedu_zt(String sedu_zt) {
        this.sedu_zt = sedu_zt;
    }

    public int getSedu_pf() {
        return sedu_pf;
    }

    public void setSedu_pf(int sedu_pf) {
        this.sedu_pf = sedu_pf;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this) + "\n";
    }
}
