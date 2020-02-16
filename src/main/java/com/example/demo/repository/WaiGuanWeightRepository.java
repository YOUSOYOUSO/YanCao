package com.example.demo.repository;

import com.example.demo.entity.WaiGuanWeight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaiGuanWeightRepository extends JpaRepository<WaiGuanWeight,Long> {
    WaiGuanWeight findByNameAndDescribesAndValues(String name,String describes,String values);
}
