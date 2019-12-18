package gcsj.controller;

import gcsj.entity.WaiGuan;
import gcsj.repository.WaiGuanRepository;
import gcsj.service.WaiGuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WaiGuanController {

    @Autowired
    WaiGuanService waiGuanService;

    @RequestMapping("/allwaiguan")
    public List<WaiGuan > getAllWaiguan()
    {
        return waiGuanService.getWaiguanList();
    }

    @RequestMapping("/insertwaiguan")
    public List<WaiGuan > insertWaiGuan(@RequestParam WaiGuan waiGuan)
    {
        System.out.println("前台数据："+waiGuan.toString());
        return null;
    }

}
