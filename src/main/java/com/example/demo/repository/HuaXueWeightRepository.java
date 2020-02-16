package com.example.demo.repository;

import com.example.demo.entity.HuaXue;
import com.example.demo.entity.HuaXueWeight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HuaXueWeightRepository extends JpaRepository<HuaXueWeight,Long> {
    HuaXueWeight findByName(String name);
}
