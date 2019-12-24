package gcsj.service.impl;

import gcsj.entity.Quality;
import gcsj.repository.QualityRepository;
import gcsj.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualityServiceImpl  implements QualityService {

    @Autowired
    QualityRepository qualityRepository;


    @Override
    public List<Quality> getQualityList() {
        return qualityRepository.findAll();
    }

    @Override
    public Quality addQuality(Quality quality) {
        qualityRepository.save(quality);
        return quality;
    }
}
