package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.Query;
import java.security.Principal;
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
    @Autowired
    HuaXueWeightRepository huaXueWeightRepository;
    @RequestMapping("/analysisdata")
    public String analysisdata(Model model){
        List<YanNong>  yanNongList=yanNongRepository.selectDistinctYanNongName();
        model.addAttribute("yannongList",yanNongList);
        return "analysisdata";
    }

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
           // System.out.println("查找评吸状态："+s1[i]+a1[i]);
            pingxiscore+=pingXiWeightRepository.findByNameAndDescribe(s1[i],a1[i]).getScore();
        }
        String[] s2=new String[]{"颜色","成熟度","油分","结构","身份","色度"};
        int[] a2=waiGuan.getArray2();//待计算样品的外观的状态
        for(int i=0;i<6;i++){
            waiguanscore+=a2[i];
        }
        return waiguanscore+pingxiscore;
    }

    public void GetYannongdata(List<String> yantianList1,
                               List<String> distinctyearList,
                               List<List<Double>> scoress,
                               String yannongname
                               ){

        List<String> yantianList = yanNongRepository.selectDistinctYanTianByYanNongName(yannongname);
        List<Quality> yearList=qualityRepository.selectDateByYanNongName(yannongname);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy");
        for (Quality year:yearList
        ) {
            String y=simpleDateFormat.format(year.getCaigouriqi());
            boolean flag=true;
            for (int i=0;i<distinctyearList.size();i++){//去重
                if (y.equals(distinctyearList.get(i))){
                    flag=false;
                    break;
                }
            }
            if (flag){
                distinctyearList.add(y);
            }
        }
        Collections.sort(distinctyearList);
        Collections.sort(yantianList);
        System.out.println(yantianList);
        System.out.println(distinctyearList);


        for (int i=0;i<yantianList.size();i++){
            List<Double> scores =new ArrayList<>();
            String yantian =yantianList.get(i);
            System.out.println("烟田："+yantian);
            for (int j=0;j<distinctyearList.size();j++){
                String year =distinctyearList.get(j);
                System.out.println("年份："+year);
                //查找该烟田该年份的所有分数求平均
                double score=0;
                int count=0;
                for (int k=0;k<yearList.size();k++){
                    Quality ayearyantian =yearList.get(k);
                    if (ayearyantian.getYantian().equals(yantian)&&
                            simpleDateFormat.format(ayearyantian.getCaigouriqi()).equals(year)){
                        if(ayearyantian.isFlag()){
                            score+=CountScore(ayearyantian.getQuality_id());
                            count++;
                        }
                    }
                    if(count!=0){
                        score=score/count;
                    }
                    else {
                        score=0;
                    }
                }
                scores.add(score);
            }
            scoress.add(scores);
        }
        System.out.println(scoress);

        for (String yantian:yantianList
        ) {
            yantianList1.add('"'+yantian+'"');
        }
    }

    @RequestMapping("analysisyantian")
    String yantianfenxi(Model model,String yannongname){
        //yannongname="shit";
        List<List<Double>> scoress=new ArrayList<>();
        List<String> distinctyearList=new ArrayList<>();
        List<String> yantianList1=new ArrayList<>();
        List<List<Double>> newscoress=new ArrayList<>();


        GetYannongdata(yantianList1,distinctyearList,scoress,yannongname);

        if (!scoress.isEmpty()){
            for (int i=0;i<scoress.get(0).size();i++){
                List<Double> newscores=new ArrayList<>();
                for(int j=0;j<scoress.size();j++){
                    newscores.add(scoress.get(j).get(i));
                }
                newscoress.add(newscores);
            }
        }
        System.out.println("new"+newscoress);
        System.out.println("old"+scoress);

        model.addAttribute("scoress",newscoress);
        model.addAttribute("yantianList",yantianList1);
        model.addAttribute("distinctyearList",distinctyearList);
        return  "analysisyantian";
    }
    @RequestMapping("/analysisyantians")
    public String  analysisyantians(Model model,
                                    @RequestParam(required = false, value = "yannongnamelist[]")
                                    List<String> yannongnamelist){
        System.out.println("要进行对比的烟农"+yannongnamelist);

        List<List<Double>> allscoress=new ArrayList<>();
        List<Map<String,Double>> mapscoress=new ArrayList<>();
        List<String> alldistinctyearList=new ArrayList<>();
        List<String> allyantianList1=new ArrayList<>();

        if (yannongnamelist==null){
            return "error";
        }

        for (String yannongname:yannongnamelist
             ) {
            List<List<Double>> scoress=new ArrayList<>();
            List<String> distinctyearList=new ArrayList<>();
            List<String> yantianList1=new ArrayList<>();
            GetYannongdata(yantianList1,distinctyearList,scoress,yannongname);

            System.out.println("-----------------------------------");
            System.out.println("当前编辑的数据:"+distinctyearList+yantianList1+scoress);

            //找出出现过的年份存到alldistinctyearlist
            for (String year:distinctyearList
                 ) {
                boolean flag=true;
                for (int i=0;i<alldistinctyearList.size();i++){//去重
                    if (year.equals(alldistinctyearList.get(i))){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    alldistinctyearList.add(year);
                }
            }

            //计算每个烟农每年的分值存入map
            //初始化map
            int yearnumber=distinctyearList.size();
            Map<String,Double> avgscores = new HashMap<>();
            for (int i=0;i<yearnumber;i++){
                //System.out.println(i);
                //System.out.println(distinctyearList.get(i));
                avgscores.put(distinctyearList.get(i),0.0);
            }
            //开始计算每一年的平均值
            int [] counts=new int[yearnumber];
            System.out.println(counts);
            for (List<Double> scores:scoress
            ) {
                for (int i=0;i<yearnumber;i++){
                    if(scores.get(i)!=0){
                        avgscores.put(distinctyearList.get(i),avgscores.get(distinctyearList.get(i))+scores.get(i));
                        counts[i]++;
                    }
                }
            }
            for(int i=0;i<yearnumber;i++){
                if(counts[i]!=0){
                    avgscores.put(distinctyearList.get(i),avgscores.get(distinctyearList.get(i))/counts[i]);
                }else {
                    avgscores.put(distinctyearList.get(i),0.0);
                }
            }
            System.out.println("avg:"+avgscores);
            mapscoress.add(avgscores);
        }
        Collections.sort(alldistinctyearList);
        System.out.println(mapscoress);
        System.out.println(alldistinctyearList);
        System.out.println(yannongnamelist);

        //System.out.println(yannongnamelist.size());
        for (int i=0;i<yannongnamelist.size();i++){
            List<Double> scores =new ArrayList<>();
            for (int j=0;j<alldistinctyearList.size();j++){
                //System.out.println(i);
                //System.out.println(mapscoress.get(i));

                if (mapscoress.get(i).get(alldistinctyearList.get(j))!=null){
                    scores.add(mapscoress.get(i).get(alldistinctyearList.get(j)));
                }else {
                    scores.add(0.0);
                }
            }
            allscoress.add(scores);
        }
        System.out.println(allscoress);

        List<String > yannongnamelist1=new ArrayList<>();
        for (String name:yannongnamelist
        ) {
            yannongnamelist1.add('"'+name+'"');
        }

        List<List<Double>> newscoress=new ArrayList<>();
        if (!allscoress.isEmpty()){
            for (int i=0;i<allscoress.get(0).size();i++){
                List<Double> newscores=new ArrayList<>();
                for(int j=0;j<allscoress.size();j++){
                    newscores.add(allscoress.get(j).get(i));
                }
                newscoress.add(newscores);
            }
        }

        model.addAttribute("scoress",newscoress);
        model.addAttribute("yantianList",yannongnamelist1);
        model.addAttribute("distinctyearList",alldistinctyearList);

        return "analysisyantians";
    }
    @RequestMapping("/passrate")
    public String passrate(Model model) {
        List<YanNong> yanNongList = yanNongRepository.selectDistinctYanNongName();
        YanNong yanNong=new YanNong();
        if(yanNongList.get(0)!=null){
            yanNong=yanNongList.get(0);
            yanNong.setName("全部");
        yanNongList.add(yanNong);}
        model.addAttribute("yanNongList", yanNongList);
        return "passrate";
    }
    @RequestMapping("/getpassrate")
    public String getpassrate(@RequestParam("date")String date,@RequestParam("yannongname")String yannongname,Model model){
        int a = 0;
        try {
            a = Integer.parseInt(date);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

            String start=Integer.toString(a-1);
            String end=Integer.toString(a+1);
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
            List<Quality> qualities=new ArrayList<>();
            if(yannongname.equals("全部"))
                qualities=qualityRepository.findAllByCaigouriqiBetween(date1,date2);
            else
                qualities=qualityRepository.findAllByYannongnameAndCaigouriqiBetween(yannongname,date1,date2);
            int count1=0;
            int count2=0;
            for(Quality quality:qualities){
                if(isPass(quality)){
                    count1=count1+1;
                }
                else{
                    count2=count2+1;
                }
            }
            List<YanNong> yanNongList = yanNongRepository.selectDistinctYanNongName();
            YanNong yanNong=new YanNong();
            if(yanNongList.get(0)!=null){
                yanNong.setName("全部");
                yanNongList.add(yanNong);
            }
        model.addAttribute("yanNongList", yanNongList);
            model.addAttribute("pass",count1);
            model.addAttribute("dispass",count2);
            model.addAttribute("title","\""+yannongname+date+"年合格率\"");
        return "passrate";
    }
    public boolean isPass(Quality quality){
        HuaXue huaXue=huaXueRepository.findById(quality.getHuaxueid());
        List<HuaXueWeight> huaXueWeights=huaXueWeightRepository.findAll();
        double[] huaXueValue=huaXue.getArray();
        for(int i=0;i<9;i++){
            if(huaXueValue[i]<huaXueWeights.get(i).getLow()||huaXueValue[i]>huaXueWeights.get(i).getHigh()){
                return false;
            }
        }
        return true;
    }
}

