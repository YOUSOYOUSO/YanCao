package com.example.demo.repository;

import com.example.demo.entity.Quality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QualityRepository extends JpaRepository<Quality,Long> {
    long countByQualitynameAndUserid(String qualityname,long id);
    Quality findByQualitynameAndUserid(String qualityname,long id);
    List<Quality> findByQualitynameLikeAndUserid(String qualityname,long id);
    List<Quality> findAllByUserid(long id);
    List<Quality> findAllByQualitynameLikeAndUserid(String qualityname,long id);
}
