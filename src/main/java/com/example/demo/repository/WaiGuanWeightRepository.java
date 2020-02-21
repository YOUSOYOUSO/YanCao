package com.example.demo.repository;

import com.example.demo.entity.WaiGuanWeight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaiGuanWeightRepository extends JpaRepository<WaiGuanWeight,Long> {
    WaiGuanWeight findByNameAndDescribesAndValues(String name,String describes,String values);
    List<WaiGuanWeight> findByNameAndDescribe(String name,int describe);
    WaiGuanWeight findByNameAndDescribeAndValue(String name,int describe,int value);
}
