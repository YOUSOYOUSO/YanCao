package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.relation.Role;
import java.security.Principal;
import java.util.List;


@Controller
public class QualityController {

    @Autowired
    QualityRepository qualityRepository;
    @Autowired
    HuaXueRepository huaXueRepository;
    @Autowired
    YanCaoUserRepository yanCaoUserRepository;
    @Autowired
    YanCaoRoleRepository yanCaoRoleRepository;
    @Autowired
    PingXiRepository pingXiRepository;
    @Autowired
    WaiGuanRepository waiGuanRepository;
    private Quality quality;

    @RequestMapping("/addquality")
    public  String  addQuality(Principal principal,Model model, String name){
        System.out.println("用户名："+principal.getName());
    if(qualityRepository.countByQualitynameAndUserid(name,yanCaoUserRepository.findByUsername(principal.getName()).getId())==0) {
        PingXi pingXi=new PingXi();
        HuaXue huaXue=new HuaXue();
        WaiGuan waiGuan=new WaiGuan();
        huaXueRepository.save(huaXue);
        pingXiRepository.save(pingXi);
        waiGuanRepository.save(waiGuan);
        Quality quality= new Quality(name,yanCaoUserRepository.findByUsername(principal.getName()).getId(),pingXi.getId(),huaXue.getId(),waiGuan.getId(),false);
        qualityRepository.save(quality);
    }
        this.quality=qualityRepository.findByQualitynameAndUserid(name,yanCaoUserRepository.findByUsername(principal.getName()).getId());
        HuaXue huaXue=huaXueRepository.findById(quality.getHuaxueid());
        WaiGuan waiGuan=waiGuanRepository.findById(quality.getWaiguanid());
        PingXi pingXi=pingXiRepository.findById(quality.getPingxiid());
        model.addAttribute("huaxue",huaXue);
        model.addAttribute("pingxi",pingXi);
        model.addAttribute("waiguan",waiGuan);
        return "editthreeform";

    }

    @RequestMapping("/updatequality")
    public String UpdateQuality(
            @RequestParam("sbyyanjian") int sbyyanjian,
            @RequestParam("zbyyanjian") int zbyyanjian,
            @RequestParam("xbyyanjian") int xbyyanjian,
            @RequestParam("zongtang") int zongtang,
            @RequestParam("huanyuantang") int huanyuantang,
            @RequestParam("jiahanliang") int jiahanliang,
            @RequestParam("lvhanliang") int lvhanliang,
            @RequestParam("niguding") int niguding,
            @RequestParam("danhanliang") int danhanliang,
            @RequestParam("xiangqizhi") int xiangqizhi,
            @RequestParam("xiangqiliang") int xiangqiliang,
            @RequestParam("zaqi") int zaqi,
            @RequestParam("cijixing") int cijixing,
            @RequestParam("yuwei") int yuwei,
            @RequestParam("ranshaoxing") int ranshaoxing,
            @RequestParam("huise") int huise,
            @RequestParam("nongdu") int nongdu,
            @RequestParam("jintou") int jintou,
            @RequestParam("chengtuanxing") int chengtuanxing,
            @RequestParam("xinidu") int xinidu,
            @RequestParam("huitiangan") int huitiangan,
            @RequestParam("ganzaodu") int ganzaodu,
            @RequestParam("yanse_zt") int yanse_zt,
            @RequestParam("yanse_pf") int yanse_pf,
            @RequestParam("chengshudu_zt") int chengshudu_zt,
            @RequestParam("chengshudu_pf") int chengshudu_pf,
            @RequestParam("youfen_zt") int youfen_zt,
            @RequestParam("youfen_pf") int youfen_pf,
            @RequestParam("jiegou_zt") int jiegou_zt,
            @RequestParam("jiegou_pf") int jiegou_pf,
            @RequestParam("shenfen_zt") int shenfen_zt,
            @RequestParam("shenfen_pf") int shenfen_pf,
            @RequestParam("sedu_zt") int sedu_zt,
            @RequestParam("sedu_pf") int sedu_pf

    ){
        HuaXue huaXue=huaXueRepository.findById(quality.getHuaxueid());
        WaiGuan waiGuan=waiGuanRepository.findById(quality.getWaiguanid());
        PingXi pingXi=pingXiRepository.findById(quality.getPingxiid());

        if(sbyyanjian!=0&&zbyyanjian!=0&&xbyyanjian!=0&&zongtang!=0&&
                huanyuantang!=0&&jiahanliang!=0&&lvhanliang!=0&&niguding!=0&&
                danhanliang!=0&&xiangqizhi!=0&&xiangqiliang!=0&&zaqi!=0&&
                cijixing!=0&&yuwei!=0&&ranshaoxing!=0&&huise!=0&&nongdu!=0&&
                jintou!=0&&chengtuanxing!=0&&xinidu!=0&&huitiangan!=0&&
                ganzaodu!=0&&yanse_zt!=0&&yanse_pf!=0&&chengshudu_zt!=0&&
                chengshudu_pf!=0&&youfen_zt!=0&&youfen_pf!=0&&jiegou_zt!=0&&
                jiegou_pf!=0&&shenfen_zt!=0&&shenfen_pf!=0&&sedu_zt!=0&&sedu_pf!=0){
            quality.setFlag(true);
        }
        else
            quality.setFlag(false);

        huaXue.setSbyyanjian(sbyyanjian);
        huaXue.setZbyyanjian(zbyyanjian);
        huaXue.setXbyyanjian(xbyyanjian);
        huaXue.setZongtang(zongtang);
        huaXue.setHuanyuantang(huanyuantang);
        huaXue.setJia(jiahanliang);
        huaXue.setZonglv(lvhanliang);
        huaXue.setNiguding(niguding);
        huaXue.setZongdan(danhanliang);

        pingXi.setXiangqizhi(xiangqizhi);
        pingXi.setXiangqiliang(xiangqiliang);
        pingXi.setZaqi(zaqi);
        pingXi.setCijixing(cijixing);
        pingXi.setYuwei(yuwei);
        pingXi.setRanshaoxing(ranshaoxing);
        pingXi.setHuidu(huise);
        pingXi.setNongdu(nongdu);
        pingXi.setJintou(jintou);
        pingXi.setChengtuanxing(chengtuanxing);
        pingXi.setXinidu(xinidu);
        pingXi.setHuitiangan(huitiangan);
        pingXi.setGanzaogan(ganzaodu);

        waiGuan.setYanse_zt(yanse_zt);
        waiGuan.setYanse_pf(yanse_pf);
        waiGuan.setChengshudu_pf(chengshudu_pf);
        waiGuan.setChengshudu_zt(chengshudu_zt);
        waiGuan.setYoufen_zt(youfen_zt);
        waiGuan.setYoufen_pf(youfen_pf);
        waiGuan.setJiegou_zt(jiegou_zt);
        waiGuan.setJiegou_pf(jiegou_pf);
        waiGuan.setShenfen_pf(shenfen_pf);
        waiGuan.setShenfen_zt(shenfen_zt);
        waiGuan.setSedu_zt(sedu_zt);
        waiGuan.setSedu_pf(sedu_pf);
        qualityRepository.save(quality);
        huaXueRepository.save(huaXue);
        pingXiRepository.save(pingXi);
        waiGuanRepository.save(waiGuan);
        return "formsuccess";
    }
    @RequestMapping("/findthreeform")
    public String FindThreeForm(Principal principal,Model model){
        YanCaoRole adminrole=yanCaoRoleRepository.findByRolename("ROLE_ADMIN");
        if(yanCaoUserRepository.findByUsername(principal.getName()).getRoles().get(0).getId()!= adminrole.getId()){
        List<Quality> qualities=qualityRepository.findAllByUserid(yanCaoUserRepository.findByUsername(principal.getName()).getId());
        for(int i=0;i<qualities.size();i++){
            if(qualities.get(i).isFlag())
                qualities.get(i).setState("填写完毕");
            else
                qualities.get(i).setState("未填写完");
        }
        model.addAttribute("qualities",qualities);
        }else{
            List<Quality> qualities=qualityRepository.findAll();
            for(int i=0;i<qualities.size();i++){
                if(qualities.get(i).isFlag())
                    qualities.get(i).setState("填写完毕");
                else
                    qualities.get(i).setState("未填写完");
            }
            model.addAttribute("qualities",qualities);
        }
        return "findthreeform";
    }
    @RequestMapping("/deletequality")
    public @ResponseBody boolean deletequality(Principal principal,String qualityname){
        Quality quality=qualityRepository.findByQualitynameAndUserid(qualityname,yanCaoUserRepository.findByUsername(principal.getName()).getId());
        waiGuanRepository.delete(waiGuanRepository.findById(quality.getWaiguanid()));
        huaXueRepository.delete(huaXueRepository.findById(quality.getHuaxueid()));
        pingXiRepository.delete(pingXiRepository.findById(quality.getPingxiid()));
        qualityRepository.delete(quality);
        return true;
    }
    @RequestMapping("/findlike")
    public String FindLike(Model model,Principal principal,
                           @RequestParam("key") String key
    ){
        YanCaoRole adminrole=yanCaoRoleRepository.findByRolename("ROLE_ADMIN");
        if(yanCaoUserRepository.findByUsername(principal.getName()).getRoles().get(0).getId()!= adminrole.getId()) {
            List<Quality> qualities = qualityRepository.findAllByQualitynameLikeAndUserid("%" + key + "%", yanCaoUserRepository.findByUsername(principal.getName()).getId());
            for (int i = 0; i < qualities.size(); i++) {
                if (qualities.get(i).isFlag())
                    qualities.get(i).setState("填写完毕");
                else
                    qualities.get(i).setState("未填写完");
            }
            model.addAttribute("qualities", qualities);
        } else{
            List<Quality> qualities = qualityRepository.findAllByQualitynameLike("%" + key + "%");
            for (int i = 0; i < qualities.size(); i++) {
                if (qualities.get(i).isFlag())
                    qualities.get(i).setState("填写完毕");
                else
                    qualities.get(i).setState("未填写完");
            }
            model.addAttribute("qualities", qualities);
        }
        return "findthreeform";
    }
@RequestMapping("/fuck")
    public String fuck(String name){
        return "fuck";
}


}
