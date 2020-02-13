package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_yancaorole")
public class YanCaoRole {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="角色名")
    private String rolename;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    public YanCaoRole(){super();}
    public YanCaoRole(String rolename){super();this.rolename=rolename;}
}
