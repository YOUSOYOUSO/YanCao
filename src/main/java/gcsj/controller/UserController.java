package gcsj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import gcsj.entity.User;
import gcsj.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/users")
    public String findUsers() {
        List<User> users=userRepository.findAll();
        System.out.println("findAll...");
        for (User user : users) {
            System.out.println("name="+user.getName()+"    password="+user.getPasswd());
        }

        return "hello all users";
    }

    @PostMapping("/adduser")
    public String modifyPassWd(
            @RequestParam("name") String name,
            @RequestParam("password") String password){

        User user = new User();
        user.setName(name);
        user.setPasswd(password);
        System.out.println("新增用户"+user.getName()+user.getPasswd());
        userRepository.save(user);
        return "成功";
    }
}