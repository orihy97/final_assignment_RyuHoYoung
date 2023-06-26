package com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.repository;


import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.entity.Mem;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemRepository extends JpaRepository<Mem, Integer> {

//    List<Mem> findByMemDepartGreaterThan(Integer memDepart);
//
//    List<Mem> findByMemCodeGreaterThanOrderByMemCode(Integer memCode);
//
//    List<Mem> findByMemDepartGreaterThan(Integer memDepart, Sort sort);
List<Mem> findByMemDepartGreaterThan(Integer memDepart);

    List<Mem> findByMemCodeGreaterThanOrderByMemCode(Integer memCode);

    List<Mem> findByMemDepartGreaterThan(Integer memDepart, Sort sort);
}