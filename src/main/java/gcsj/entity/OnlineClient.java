package gcsj.entity;

import javax.persistence.*;

@Entity
@Table(name="client")//表名
public class OnlineClient {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="name")//对应的列名
    private String name;

    @Column(name="ip")//对应的列名
    private String ip;

    @Column(name="isOpen")//对应的列名
    private Boolean isOpen;


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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public void setIsOpen(boolean b) {
    }
}