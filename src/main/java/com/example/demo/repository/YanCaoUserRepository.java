package com.example.demo.repository;

import com.example.demo.entity.YanCaoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YanCaoUserRepository extends JpaRepository<YanCaoUser, Long> {
    YanCaoUser findByUsername(String name);
}
