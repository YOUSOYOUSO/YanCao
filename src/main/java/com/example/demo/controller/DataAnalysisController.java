package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class DataAnalysisController {
    @Autowired
    QualityRepository qualityRepository;
    @Autowired
    HuaXueRepository huaXueRepository;
    @Autowired
    PingXiRepository pingXiRepository;
    @Autowired
    WaiGuanRepository waiGuanRepository;
    @Autowired
    WaiGuanWeightRepository waiGuanWeightRepository;
    @Autowired
    PingXiWeightRepository pingXiWeightRepository;
    @Autowired
    YanNongRepository yanNongRepository;

    @RequestMapping("/tablesubmit")
    public String table(@RequestParam("date")String date){
        String start=date.substring(0,4);
        String end=date.substring(7,11);
        int a = 0,b=0;
        try {

            a = Integer.parseInt(start)-1;

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            b = Integer.parseInt(end)+1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        start=Integer.toString(a);
        end=Integer.toString(b);
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
        List<String> yannongs=new ArrayList<>();
        int[] years=new int[]{};
        double[] scores=new double[]{};
        for(Quality quality:qualities){
            if(quality.isFlag()){
                int position = 0;
                if(yannongs.indexOf(quality.getYannongname())==-1) {
                    position=yannongs.size();
                    yannongs.add(quality.getYannongname());
                }
            }
        }
            System.out.println(yannongs);
        
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
       // String[] s2=new String[]{"颜色","成熟度","油分","结构","身份","色度"};
        int[] a2=waiGuan.getArray2();//待计算样品的外观的状态
        for(int i=0;i<6;i++){
            waiguanscore+=a2[i];
        }
        return waiguanscore+pingxiscore;
    }

    @RequestMapping("analysisyantian")
    String yantianfenxi(Model model){
        List<String> yantianList = yanNongRepository.selectDistinctYanTianByYanNongName("shit");
        List<Date> yearList=qualityRepository.selectDateByYanNongName("shit");
        List<String> usefulyearList=new ArrayList<>();
        System.out.println(yantianList);
        System.out.println(yearList);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy");

        for (Date year:yearList
             ) {
            String y=simpleDateFormat.format(year);
            boolean flag=true;
            for (int i=0;i<usefulyearList.size();i++){//去重
                if (y.equals(usefulyearList.get(i))){
                    flag=false;
                    break;
                }
            }
            if (flag){
                usefulyearList.add(y);
            }
        }
        System.out.println(usefulyearList);
        model.addAttribute("usefulyantianList",usefulyearList);
        model.addAttribute("yearList",yearList);


        return  "analysisyantian";
    }

}
