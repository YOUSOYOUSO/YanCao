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

    @Autowired
    WaiGuanRepository waiGuanRepository;

    @RequestMapping("/allwaiguan")
    public List<WaiGuan > getAllWaiguan()
    {
        return waiGuanService.getWaiguanList();
    }

    @RequestMapping("/addwaiguan")
    public String insertWaiGuan(
            @RequestParam("yanse_zt") String yanse_zt,
            @RequestParam("yanse_pf") String yanse_pf,
            @RequestParam("chengshudu_zt") String chengshudu_zt,
            @RequestParam("chengshudu_pf") String chengshudu_pf,
            @RequestParam("youfen_zt") String youfen_zt,
            @RequestParam("youfen_pf") String youfen_pf,
            @RequestParam("jiegou_zt") String jiegou_zt,
            @RequestParam("jiegou_pf") String jiegou_pf,
            @RequestParam("shenfen_zt") String shenfen_zt,
            @RequestParam("shenfen_pf") String shenfen_pf,
            @RequestParam("sedu_zt") String sedu_zt,
            @RequestParam("sedu_pf") String sedu_pf
    )
    {
        WaiGuan waiGuan= new WaiGuan();
        waiGuan.setChengshudu_pf(Integer.parseInt(chengshudu_pf));
        waiGuan.setChengshudu_zt(chengshudu_zt);
        waiGuan.setJiegou_pf(Integer.parseInt(jiegou_pf));
        waiGuan.setJiegou_zt(jiegou_zt);
        waiGuan.setSedu_pf(Integer.parseInt(sedu_pf));
        waiGuan.setSedu_zt(sedu_zt);
        waiGuan.setShenfen_pf(Integer.parseInt(shenfen_pf));
        waiGuan.setShenfen_zt(shenfen_zt);
        waiGuan.setYanse_pf(Integer.parseInt(yanse_pf));
        waiGuan.setYanse_zt(yanse_zt);

        System.out.println("前台数据："+waiGuan.toString());
        waiGuanRepository.save(waiGuan);
        return "formsuccess";
    }
    @RequestMapping("/editwaiguan")
    public String  editWaiGuan(@RequestParam WaiGuan waiGuan)
    {

        return "waiguan";
    }

}
