package com.example.demo.controller;

import com.example.demo.entity.Quality;
import com.example.demo.repository.QualityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class DataAnalysisController {
    @Autowired
    QualityRepository qualityRepository;
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
    
}
