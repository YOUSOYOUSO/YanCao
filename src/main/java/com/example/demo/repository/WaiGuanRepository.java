package com.example.demo.repository;

import com.example.demo.entity.WaiGuan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaiGuanRepository extends JpaRepository<WaiGuan,Long> {
    WaiGuan findById(long id);
}
