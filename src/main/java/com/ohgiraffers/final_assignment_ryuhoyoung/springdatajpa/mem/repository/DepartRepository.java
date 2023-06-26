package com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.repository;


import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartRepository extends JpaRepository<Department, Integer> {

    @Query(value="SELECT mem_depart, depart_leader,depart_career FROM tbl_depart ORDER BY mem_depart DESC", nativeQuery = true)
    public List<Department> findAllDepart();
}

