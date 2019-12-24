package gcsj.service;

import gcsj.entity.Quality;

import java.util.List;

public interface QualityService {
    List<Quality> getQualityList();
    Quality addQuality(Quality quality);
}
