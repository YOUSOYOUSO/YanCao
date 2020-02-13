package com.example.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="tb_yancaouser")
public class YanCaoUser implements UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="用户名")
    private String username;
    @Column(name="密码")
    private String password;
    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<YanCaoRole> roles;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        List<YanCaoRole> roles=this.getRoles();
        for (YanCaoRole role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<YanCaoRole> getRoles() {
        return roles;
    }

    public void setRoles(List<YanCaoRole> roles) {
        this.roles = roles;
    }

}
