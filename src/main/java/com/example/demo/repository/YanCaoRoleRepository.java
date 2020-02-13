package com.example.demo.repository;

import com.example.demo.entity.YanCaoRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YanCaoRoleRepository extends JpaRepository<YanCaoRole, Long> {
    YanCaoRole findByRolename(String rolename);
}
