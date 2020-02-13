package com.example.demo.repository;


import com.example.demo.entity.PingXi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PingXiRepository extends JpaRepository<PingXi, Long> {
    PingXi findById(long id);
}
