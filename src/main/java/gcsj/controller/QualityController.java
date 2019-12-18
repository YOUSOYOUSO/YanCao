package gcsj.controller;

import gcsj.entity.Quality;
import gcsj.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QualityController {

    @Autowired
    QualityService qualityService;

    @RequestMapping("/allquality")
    public List<Quality> getAllQuality(){
        return qualityService.getQualityList();
    }
}
