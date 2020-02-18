package com.example.demo.repository;

import com.example.demo.entity.PingXiWeight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PingXiWeightRepository extends JpaRepository<PingXiWeight,Long> {
    PingXiWeight findByNameAndDescribes(String name,String describes);
    PingXiWeight findByNameAndDescribe(String name,int describe);
}
