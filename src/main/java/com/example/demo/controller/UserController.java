package com.example.demo.controller;


import com.example.demo.entity.YanCaoRole;
import com.example.demo.entity.YanCaoUser;
import com.example.demo.repository.YanCaoRoleRepository;
import com.example.demo.repository.YanCaoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Autowired
    YanCaoUserRepository yanCaoUserRepository;

    @Autowired
    YanCaoRoleRepository yanCaoRoleRepository;
    @RequestMapping("/addadmin")
    public @ResponseBody  boolean addadmin(
            @RequestParam("username") String username,
            @RequestParam("password") String password){
        System.out.println("ROLE中数据数："+yanCaoRoleRepository.count());
        if(yanCaoRoleRepository.count()==0){
            yanCaoRoleRepository.save(new YanCaoRole("ROLE_ADMIN"));
            yanCaoRoleRepository.save(new YanCaoRole("ROLE_USER"));
        }
        if(yanCaoUserRepository.findByUsername(username)!=null)
            return false;
        YanCaoUser yanCaoUser=new YanCaoUser();
        yanCaoUser.setUsername(username);
        yanCaoUser.setPassword(ENCODER.encode(password));
        List<YanCaoRole> roles=new ArrayList<YanCaoRole>();
        roles.add(yanCaoRoleRepository.findByRolename("ROLE_ADMIN"));
        yanCaoUser.setRoles(roles);
        yanCaoUserRepository.save(yanCaoUser);
        return true;
    }
    @RequestMapping({"/logout"})
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {//清除认证
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "/login";

    }
}