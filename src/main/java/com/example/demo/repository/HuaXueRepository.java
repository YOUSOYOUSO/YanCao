package com.example.demo.repository;


import com.example.demo.entity.HuaXue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

public interface HuaXueRepository extends JpaRepository<HuaXue, Long> {
    HuaXue findById(long id);
}