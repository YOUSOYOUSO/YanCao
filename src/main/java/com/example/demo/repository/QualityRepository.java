package com.example.demo.repository;

import com.example.demo.entity.Quality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface QualityRepository extends JpaRepository<Quality,Long> {
    long countByQualitynameAndCaigouriqiAndYannongnameAndYantianAndUserid(String qualityname, Date caigouriqi, String yannongname, String yantian, long userid);;
    Quality findByQualitynameAndCaigouriqiAndYannongnameAndYantianAndUserid(String qualityname, Date caigouriqi, String yannongname, String yantian, long userid);;
    List<Quality> findByQualitynameLikeAndUserid(String qualityname,long id);
    List<Quality> findAllByUserid(long id);
    List<Quality> findAllByQualitynameLikeAndUserid(String qualityname,long id);
    List<Quality> findAllByQualitynameLike(String qualityname);
    List<Quality> findAllByYannongname(String yannongname);
    List<Quality> findAllByYannongnameAndYantian(String yannong,String yantian);
    List<Quality> findAllByCaigouriqiBetween(Date date1,Date date2);

    @Query("select q from Quality q where q.yannongname=?1")
    List<Quality> selectDateByYanNongName(String name);
}
