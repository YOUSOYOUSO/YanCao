package gcsj.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_user")//表名
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="name")//对应的列名
    private String name;
    @Column(name="password")//对应的列名

    private String passwd;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}