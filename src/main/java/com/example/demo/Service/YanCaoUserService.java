package com.example.demo.Service;

import com.example.demo.entity.YanCaoUser;
import com.example.demo.repository.YanCaoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class YanCaoUserService implements UserDetailsService {
    @Autowired
    YanCaoUserRepository yanCaoUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        YanCaoUser user=yanCaoUserRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("用户："+user);
        return user;
    }
}
