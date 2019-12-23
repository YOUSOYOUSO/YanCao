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

/**
 * Created by chao on 2017/4/19.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    WaiGuanService waiGuanService;


    private String filePath;
    /**
     * 打开密码修改界面
     * @return
     */
    @RequestMapping("/test")
    public String test(){
        return "testleftindex";
    }



    @RequestMapping("/pass")
    public String toPass(){
        return "userbak";
    }

    /**
     * 菜单管理--展现菜单
     * @return
     */
    @RequestMapping("/showMenu")
    public String showMenu(Model model){
        return waiGuanService.showMenu(model);
    }

    /**
     * 菜单管理--添加菜品
     * @param model
     * @param menu
     * @return
     */



}
