package gcsj.controller;

import gcsj.entity.Quality;
import gcsj.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.DataTruncation;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class QualityController {

    @Autowired
    QualityService qualityService;

    @RequestMapping("/allquality")
    public String getAllQuality(Model model){

        List<Quality> qualityList= qualityService.getQualityList();
        model.addAttribute("qualityList",qualityList);
        return "allquality";
    }

    @RequestMapping("/inputqualityinfo")
    public String inputInfo(){
        return "inputqualityinfo";
    }

    @RequestMapping("/addquality")
    public  String  addQuality(String name, String date){
        Quality quality= new Quality();
        quality.setQualityname(name);
        Date date1=null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1=format1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        quality.setCaigouriqi(date1);
        quality=qualityService.addQuality(quality);
        System.out.println("addquality"+quality.toString());
        return "editthreeform";
    }

    @RequestMapping("/editthreeform")
    public String addform(Model model){

        return "editthreeform";
    }





}
