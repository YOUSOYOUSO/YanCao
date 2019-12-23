package gcsj.entity;

import javax.persistence.*;

@Entity
@Table(name="huaxue")//表名
public class HuaXue {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="zongtang_pf")//总糖评分
    private int zongtang_pf;

    @Column(name="zonglv_pf")//氯评分
    private int zonglv_pf;

    @Column(name="niguding_pf")//尼古丁评分
    private int niguding_pf;

    @Column(name="jia_pf")//钾评分
    private int jia_pf;

    @Column(name="huanyuantang_pf")//还原糖评分
    private int huanyuantang_pf;

    @Column(name="zongdan_pf")//氮评分
    private int zongdan_pf;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getzongtang_pf() {
        return zongtang_pf;
    }
    public void setzongtang_pf(int zongtang_pf) {
        this.zongtang_pf = zongtang_pf;
    }

    public int getzonglv_pf() {
        return zonglv_pf;
    }
    public void setzonglv_pf(int zonglv_pf) {
        this.zonglv_pf = zonglv_pf;
    }

    public int getniguding_pf() {
        return niguding_pf;
    }
    public void niguding_pf(int niguding_pf) {
        this.niguding_pf = niguding_pf;
    }

    public int getjia_pf() {
        return jia_pf;
    }
    public void setjia_pf(int jia_pf) {
        this.jia_pf = jia_pf;
    }

    public int gethuanyuantang_pf() {
        return huanyuantang_pf;
    }
    public void sethuanyuantang_pf(int huanyuantang_pf) {
        this.huanyuantang_pf = huanyuantang_pf;
    }

    public int getzongdan_pf() {
        return zongdan_pf;
    }
    public void setzongdan_pf(int zongdan_pf) {
        this.zongdan_pf = zongdan_pf;
    }
}