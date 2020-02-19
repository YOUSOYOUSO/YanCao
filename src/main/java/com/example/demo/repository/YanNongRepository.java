package com.example.demo.repository;

import com.example.demo.entity.YanNong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface YanNongRepository extends JpaRepository<YanNong,Long> {

    @Query("select y from YanNong y where y.id in (select max(y.id) from YanNong y group by y.name)")
    List<YanNong> selectDistinctYanNongName();

    @Query("select y.yantian from YanNong y where y.id in (select max(y.id) from YanNong y where y.name=?1 group by y.yantian )")
    List<String> selectDistinctYanTianByYanNongName(String yannongname);


    @Query("select distinct y from YanNong y where y.name =?1")
    List<YanNong> selectByYanNongName(String name);

    void deleteByName(String name);
    YanNong findByNameAndAndYantian(String name,String yantian);
    List<YanNong> findAllByName(String name);
}
