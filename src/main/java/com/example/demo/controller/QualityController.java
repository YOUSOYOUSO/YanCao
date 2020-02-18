package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


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
    @Autowired
    YanNongRepository yanNongRepository;
    @Autowired
    HuaXueWeightRepository huaXueWeightRepository;
    @Autowired
    PingXiWeightRepository pingXiWeightRepository;
    @Autowired
    WaiGuanWeightRepository waiGuanWeightRepository;


    private Quality quality;

    @RequestMapping("/inputqualityinfo")
    public String inputQualityInfo(Principal principal, Model model) {
        List<YanNong> yanNongList = yanNongRepository.selectDistinctYanNongName();
        model.addAttribute("yanNongList", yanNongList);
        return "inputqualityinfo";
    }


    @RequestMapping("/getyantian")
    @ResponseBody
    public List<YanNong> getYanTian(String yannong_name) {
        System.out.println(yannong_name);
        List<YanNong> yanTianList = yanNongRepository.selectByYanNongName(yannong_name);

        for (YanNong yt : yanTianList
        ) {
            System.out.println(yt.getYantian());
        }
        return yanTianList;
    }

    @RequestMapping("/addquality")
    public String addQuality(Principal principal, Model model, String name, String date, Long yannong_id, String yantian) {
//name要对上
        System.out.println("用户名：" + principal.getName() + date + yannong_id);

        Date date1 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD");
        try {
            date1 = simpleDateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (qualityRepository.countByQualitynameAndUserid(name, yanCaoUserRepository.findByUsername(principal.getName()).getId()) == 0) {
            PingXi pingXi = new PingXi();
            HuaXue huaXue = new HuaXue();
            WaiGuan waiGuan = new WaiGuan();
            huaXueRepository.save(huaXue);
            pingXiRepository.save(pingXi);
            waiGuanRepository.save(waiGuan);
            Quality quality = new Quality(name,
                    yanCaoUserRepository.findByUsername(principal.getName()).getId(),
                    huaXue.getId(),
                    waiGuan.getId(),
                    pingXi.getId(),
                    false);
            quality.setCaigouriqi(date1);
            quality.setYanonong_id(yannong_id);
            qualityRepository.save(quality);
        }

        this.quality = qualityRepository.findByQualitynameAndUserid(name, yanCaoUserRepository.findByUsername(principal.getName()).getId());

        System.out.println("huaxue:" + quality.getHuaxueid() + "waiguan" + quality.getWaiguanid() + "pingxi" + quality.getPingxiid());
        HuaXue huaXue = huaXueRepository.findById(quality.getHuaxueid());
        WaiGuan waiGuan = waiGuanRepository.findById(quality.getWaiguanid());
        PingXi pingXi = pingXiRepository.findById(quality.getPingxiid());
        model.addAttribute("huaxue", huaXue);
        model.addAttribute("pingxi", pingXi);
        model.addAttribute("waiguan", waiGuan);
        return "editthreeform";

    }

    @RequestMapping("/updatequality")
    public String UpdateQuality(
            HuaXue huaXue, PingXi pingXi, WaiGuan waiGuan
    ) {
        System.out.println("bianjidehuaxueid" + huaXue.getId());
        if (huaXue.getId() == 0) {
            huaXue.setId(huaXueRepository.findById(quality.getHuaxueid()).getId());
            waiGuan.setId(waiGuanRepository.findById(quality.getWaiguanid()).getId());
            pingXi.setId(pingXiRepository.findById(quality.getPingxiid()).getId());
        }
        if (huaXue.getSbyyanjian() != 0 && huaXue.getXbyyanjian() != 0 && huaXue.getZongtang() != 0 &&
                huaXue.getHuanyuantang() != 0 && huaXue.getJia() != 0 && huaXue.getZonglv() != 0 && huaXue.getNiguding() != 0 &&
                huaXue.getZongdan() != 0 && pingXi.getXiangqizhi() != 0 && pingXi.getXiangqiliang() != 0 && pingXi.getZaqi() != 0 &&
                pingXi.getCijixing() != 0 && pingXi.getYuwei() != 0 && pingXi.getRanshaoxing() != 0 && pingXi.getHuidu() != 0 && pingXi.getNongdu() != 0 &&
                pingXi.getJintou() != 0 && pingXi.getChengtuanxing() != 0 && pingXi.getXinidu() != 0 && pingXi.getHuidu() != 0 &&
                pingXi.getGanzaogan() != 0 && waiGuan.getYanse_zt() != 0 && waiGuan.getYanse_pf() != 0 && waiGuan.getChengshudu_zt() != 0 &&
                waiGuan.getChengshudu_pf() != 0 && waiGuan.getYoufen_zt() != 0 && waiGuan.getYoufen_pf() != 0 && waiGuan.getJiegou_zt() != 0 &&
                waiGuan.getJiegou_pf() != 0 && waiGuan.getShenfen_zt() != 0 && waiGuan.getShenfen_pf() != 0 && waiGuan.getSedu_zt() != 0 && waiGuan.getSedu_pf() != 0) {
            quality.setFlag(true);
        } else
            quality.setFlag(false);

        qualityRepository.save(quality);
        huaXueRepository.save(huaXue);
        pingXiRepository.save(pingXi);
        waiGuanRepository.save(waiGuan);
        return "formsuccess";
    }

    @RequestMapping("/editquality")
    public String EditQuality(Model model, Long quality_id) {
        //System.out.println("gengxinid:"+quality_id.longValue());
        Optional<Quality> quality1 = qualityRepository.findById(quality_id);
        Quality quality = quality1.get();
        //System.out.println("chadaole:"+quality.getQualityname());
        WaiGuan waiGuan = waiGuanRepository.findById(quality.getWaiguanid());
        HuaXue huaXue = huaXueRepository.findById(quality.getHuaxueid());
        PingXi pingXi = pingXiRepository.findById(quality.getPingxiid());
        // System.out.println("huaxue waiguan pingxi id"+" "+huaXue.getId()+" "+waiGuan.getId()+" "+pingXi.getId());
        model.addAttribute("huaxue", huaXue);
        model.addAttribute("pingxi", pingXi);
        model.addAttribute("waiguan", waiGuan);
        return "editthreeform";
    }

    @RequestMapping("/findthreeform")
    public String FindThreeForm(Principal principal, Model model) {
        YanCaoRole adminrole = yanCaoRoleRepository.findByRolename("ROLE_ADMIN");
        if (yanCaoUserRepository.findByUsername(principal.getName()).getRoles().get(0).getId() != adminrole.getId()) {
            List<Quality> qualities = qualityRepository.findAllByUserid(yanCaoUserRepository.findByUsername(principal.getName()).getId());
            for (int i = 0; i < qualities.size(); i++) {
                if (qualities.get(i).isFlag())
                    qualities.get(i).setState("填写完毕");
                else
                    qualities.get(i).setState("未填写完");
            }
            model.addAttribute("qualities", qualities);
        } else {
            List<Quality> qualities = qualityRepository.findAll();
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

    @RequestMapping("/deletequality")
    public @ResponseBody
    boolean deletequality(Principal principal, Long quality_id) {
        quality.setQuality_id(quality_id);
        qualityRepository.delete(quality);
        waiGuanRepository.delete(waiGuanRepository.findById(quality.getWaiguanid()));
        huaXueRepository.delete(huaXueRepository.findById(quality.getHuaxueid()));
        pingXiRepository.delete(pingXiRepository.findById(quality.getPingxiid()));
        qualityRepository.delete(quality);
        return true;
    }

    @RequestMapping("/findlike")
    public String FindLike(Model model, Principal principal,
                           @RequestParam("key") String key
    ) {
        YanCaoRole adminrole = yanCaoRoleRepository.findByRolename("ROLE_ADMIN");
        if (yanCaoUserRepository.findByUsername(principal.getName()).getRoles().get(0).getId() != adminrole.getId()) {
            List<Quality> qualities = qualityRepository.findAllByQualitynameLikeAndUserid("%" + key + "%", yanCaoUserRepository.findByUsername(principal.getName()).getId());
            for (int i = 0; i < qualities.size(); i++) {
                if (qualities.get(i).isFlag())
                    qualities.get(i).setState("填写完毕");
                else
                    qualities.get(i).setState("未填写完");
            }
            model.addAttribute("qualities", qualities);
        } else {
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
    @RequestMapping("/test")
    public @ResponseBody void test(){
        String evaluate = new String();
        HuaXue huaXue=huaXueRepository.findById(1);
        PingXi pingXi=pingXiRepository.findById(1);
        WaiGuan waiGuan=waiGuanRepository.findById(1);
        List<HuaXueWeight> huaXueWeights=huaXueWeightRepository.findAll();
        double[] huaXueValue=huaXue.getArray();
        evaluate=evaluate+"化学状态:\n";
        int count=0;
        for(int i=0;i<9;i++){
            if(huaXueValue[i]>=huaXueWeights.get(i).getLow()&&huaXueValue[i]<=huaXueWeights.get(i).getHigh()){
                if(count!=0)
                    evaluate=evaluate+",";
                evaluate=evaluate+huaXueWeights.get(i).getName();
                count++;
            }
        }
        if(count!=0)
            evaluate=evaluate+"含量合格;\n";
        count=0;
        for(int i=0;i<9;i++){
            if(huaXueValue[i]<huaXueWeights.get(i).getLow()||huaXueValue[i]>huaXueWeights.get(i).getHigh()){
                if(count!=0)
                    evaluate=evaluate+",";
                evaluate=evaluate+huaXueWeights.get(i).getName();
                count++;
            }
        }
        if(count!=0)
            evaluate=evaluate+"含量不合格;\n";
        evaluate=evaluate+"评析状态:\n";
        String[] s1=new String[]{"香气质","香气量","杂气","刺激性","余味","燃烧性","灰度","浓度","劲头","成团性","细腻感","回甜感","干燥感"};
        int[] a1=pingXi.getArray();
        count=0;
        for(int i=0;i<13;i++){
            evaluate=evaluate+s1[i]+pingXiWeightRepository.findByNameAndDescribe(s1[i],a1[i]).getDescribes();
            if(i<12)
                evaluate=evaluate+",";
            else
                evaluate=evaluate+";\n";
            count++;
            if(count==5){
                evaluate=evaluate+"\n";
                count=0;
            }
        }
        evaluate=evaluate+"外观状态:\n";
        String[] s2=new String[]{"颜色","成熟度","油分","结构","身份","色度"};
        int[] a2=waiGuan.getArray();
        for(int i=0;i<6;i++){
            evaluate=evaluate+s2[i]+waiGuanWeightRepository.findByNameAndDescribe(s2[i],a2[i]).get(0).getDescribes();
            if(i<5)
                evaluate=evaluate+",";
            else
                evaluate=evaluate+"。";
        }
        System.out.println(evaluate);
    }
}
