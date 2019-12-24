package gcsj.controller;


import gcsj.service.WaiGuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FormController {
    @Autowired
    WaiGuanService waiGuanService;

    @RequestMapping("/test")
    public String test(){
        return "testleftindex";
    }


    @RequestMapping("/pass")
    public String toPass(){
        return "userbak";
    }


    @RequestMapping("/showMenu")
    public String showMenu(Model model){
        return waiGuanService.showMenu(model);
    }





}
