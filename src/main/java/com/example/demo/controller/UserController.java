package com.example.demo.controller;


import com.example.demo.entity.YanCaoRole;
import com.example.demo.entity.YanCaoUser;
import com.example.demo.repository.YanCaoRoleRepository;
import com.example.demo.repository.YanCaoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
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

        if(yanCaoRoleRepository.count()==0){
            yanCaoRoleRepository.save(new YanCaoRole("ROLE_ADMIN"));
            yanCaoRoleRepository.save(new YanCaoRole("ROLE_USER"));
            YanCaoUser admin=new YanCaoUser();
            admin.setUsername("admin");
            admin.setPassword(ENCODER.encode("admin"));
            List<YanCaoRole> roles=new ArrayList<YanCaoRole>();
            roles.add(yanCaoRoleRepository.findByRolename("ROLE_ADMIN"));
            admin.setRoles(roles);
            yanCaoUserRepository.save(admin);
        }
        if(yanCaoUserRepository.findByUsername(username)!=null)
            return false;
        YanCaoUser yanCaoUser=new YanCaoUser();
        yanCaoUser.setUsername(username);
        yanCaoUser.setPassword(ENCODER.encode(password));
        List<YanCaoRole> roles=new ArrayList<YanCaoRole>();
        roles.add(yanCaoRoleRepository.findByRolename("ROLE_USER"));
        yanCaoUser.setRoles(roles);
        yanCaoUserRepository.save(yanCaoUser);
        return true;
    }
    @RequestMapping("/cpassword")
    public @ResponseBody  boolean changepassword(Principal principal, @RequestParam("oldpassword") String oldpassword,@RequestParam("password") String password){
        YanCaoUser yanCaoUser=yanCaoUserRepository.findByUsername(principal.getName());
        if (ENCODER.matches(oldpassword,yanCaoUser.getPassword())){
        yanCaoUser.setPassword(ENCODER.encode(password));
        yanCaoUserRepository.save(yanCaoUser);
        return true;}
        else{
            return false;
        }
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