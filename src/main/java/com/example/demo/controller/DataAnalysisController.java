package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class DataAnalysisController {
    @Autowired
    QualityRepository qualityRepository;
    @Autowired
    YanNongRepository yanNongRepository;
    @Autowired
    PingXiRepository pingXiRepository;
    @Autowired
    WaiGuanRepository waiGuanRepository;
    @Autowired
    HuaXueRepository huaXueRepository;
    @Autowired
    PingXiWeightRepository pingXiWeightRepository;
    @RequestMapping("/tablesubmit")
    public String table(@RequestParam("date")String date, Model model){
        String start=date.substring(0,4);
        String end=date.substring(7,11);
        int a = 0,b=0;
        try {

            a = Integer.parseInt(start);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            b = Integer.parseInt(end);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<Integer> years=new ArrayList<>();
        for(int i=a;i<=b;i++){
            years.add(i);
        }
        List<List<Quality>> qualitiess=new ArrayList<>();
        for(Integer each:years){
        start=Integer.toString(each-1);
        end=Integer.toString(each+1);
        start=start+"-12-31";
        end=end+"-01-01";
        Date date1 = null;
        Date date2 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD");
        try {
            date1 = simpleDateFormat.parse(start);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            date2 = simpleDateFormat.parse(end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Quality> qualities=qualityRepository.findAllByCaigouriqiBetween(date1,date2);
        qualitiess.add(qualities);
    }
        List<YanNong> yanNongs=yanNongRepository.selectDistinctYanNongName();
        int yanlongcount=yanNongs.size();
        List<List<Double>> scoress=new ArrayList<>();
        List<String> yannongs=new ArrayList<>();
        for(int i=0;i<yanlongcount;i++){
            yannongs.add(yanNongs.get(i).getName());
        }
        for(List<Quality> qualities:qualitiess){
            List<Double> scores=new ArrayList<>();
            List<Integer> counts=new ArrayList<>();
            for(int i=0;i<yanlongcount;i++){
                scores.add(0.0);
                counts.add(0);
            }
            for(Quality quality:qualities){
                if(quality.isFlag()){
                    int position =yannongs.indexOf(quality.getYannongname());
                    scores.set(position,scores.get(position)+CountScore(quality.getQuality_id()));
                    counts.set(position,counts.get(position)+1);
                }
            }
            for(int i=0;i<yanlongcount;i++){
                if(counts.get(i)!=0)
                    scores.set(i,scores.get(i)/counts.get(i));
            }
            scoress.add(scores);
        }
        for(int i=0;i<yannongs.size();i++){
            yannongs.set(i,"\""+yannongs.get(i)+"\"");
        }
        List<List<Double>> ynscoress=new ArrayList<>();
        List<List<Double>> nyscoress=new ArrayList<>();
        model.addAttribute("years",years);
        model.addAttribute("yannongs",yannongs);
        model.addAttribute("scoress",scoress);
        return "table";
    }
    public int CountScore(long quality_id){
        Optional<Quality> quality1= qualityRepository.findById(quality_id);
        Quality quality=quality1.get();
        int pingxiscore=0;
        int waiguanscore=0;
        PingXi pingXi=pingXiRepository.findById(quality.getPingxiid());
        WaiGuan waiGuan=waiGuanRepository.findById(quality.getWaiguanid());
        String[] s1=new String[]{"香气质","香气量","杂气","刺激性","余味","燃烧性","灰度","浓度","劲头","成团性","细腻感","回甜感","干燥感"};
        int[] a1=pingXi.getArray();//待计算样品的评吸的状态
        for(int i=0;i<13;i++){
            pingxiscore+=pingXiWeightRepository.findByNameAndDescribe(s1[i],a1[i]).getScore();
        }
        String[] s2=new String[]{"颜色","成熟度","油分","结构","身份","色度"};
        int[] a2=waiGuan.getArray2();//待计算样品的外观的状态
        for(int i=0;i<6;i++){
            waiguanscore+=a2[i];
        }
        return waiguanscore+pingxiscore;
    }
}

