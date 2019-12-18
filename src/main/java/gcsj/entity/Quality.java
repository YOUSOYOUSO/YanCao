package gcsj.entity;


import javax.persistence.*;

@Entity
@Table(name = "tb_quality")
public class Quality {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long quality_id;

    @Column(name="user_id")//颜色
    private long user_id;

    @Column(name="zhiliang_id")//颜色
    private long zhiliang_id;

    @Column(name="pingxi_id")//颜色
    private long pingxi_id;

    @Column(name="yanse_zt")//颜色
    private long huaxue_id;


}
