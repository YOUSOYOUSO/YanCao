package gcsj.entity;


import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_quality")
public class Quality {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long quality_id;

    @Column(name="qualityname")
    private String qualityname;

    @Column(name="caigouriqi")
    private Date caigouriqi;


    @Column(name="user_id")
    private long user_id;

    @OneToOne
    @JoinColumn(name="waiguan_id")
    private WaiGuan waiguan_id;

    @Column(name="pingxi_id")//颜色
    private long pingxi_id;

    @Column(name="yanse_zt")//颜色
    private long huaxue_id;

    public String getQualityname() {
        return qualityname;
    }

    public void setQualityname(String qualityname) {
        this.qualityname = qualityname;
    }

    public Date getCaigouriqi() {
        return caigouriqi;
    }

    public void setCaigouriqi(Date caigouriqi) {
        this.caigouriqi = caigouriqi;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this) + "\n";
    }
}
