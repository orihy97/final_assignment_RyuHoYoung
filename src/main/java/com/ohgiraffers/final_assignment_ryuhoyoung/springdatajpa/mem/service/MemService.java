package com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.service;

import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.dto.DepartDTO;
import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.dto.MemDTO;
import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.entity.Department;
import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.entity.Mem;
import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.repository.DepartRepository;
import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.repository.MemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemService {

    private final DepartRepository departRepository;
    private final MemRepository memRepository;
    private final ModelMapper modelMapper;

    public MemService(MemRepository memRepository, DepartRepository departRepositoryRepository, ModelMapper modelMapper) {
        this.memRepository = memRepository;
        this.departRepository = departRepositoryRepository;
        this.modelMapper = modelMapper;
    }

    /* 1. 메뉴 코드로 메뉴 하나 조회 : findById */
    public MemDTO findMemByCode(int MemCode) {

        Mem mem = memRepository.findById(MemCode).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(mem, MemDTO.class);
    }

//    /* 2-1. 메뉴 테이블의 모든 행 조회 : findAll(Sort) */
//    public List<MemDTO> findMemList() {
//
//        List<Mem> menuList = memRepository.findAll(Sort.by("memCode").descending());
//
//        return menuList.stream().map(menu -> modelMapper.map(menu, MemDTO.depart)).collect(Collectors.toList());
//    }

    /* 2-2. 메뉴 테이블의 요청 된 페이지에 맞는 요소 조회 : findAll(Pageable) */
    public Page<MemDTO> findMemList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()  - 1,
                pageable.getPageSize(),
                Sort.by("memCode").descending());

        Page<Mem> memList = memRepository.findAll(pageable);

        return memList.map(mem -> modelMapper.map(mem, MemDTO.class));
    }

    /* 3. 입력 받은 가격을 초과하는 메뉴 목록 조회 : Query Method Test */
    public List<MemDTO> findByMemDepart(Integer memDepart) {

        List<Mem> memList = memRepository.findByMemDepartGreaterThan(memDepart);

        return memList.stream().map(mem -> modelMapper.map(mem, MemDTO.class)).collect(Collectors.toList());
    }
//
    /* 4. 카테고리 목록 조회 : JPQL or Native Query 사용 */
    public List<DepartDTO> findAllDepart() {

        List<Department> categoryList = departRepository.findAllDepart();

        return (List<DepartDTO>) categoryList.stream().map(category -> modelMapper.map(category, DepartDTO.class)).collect(Collectors.toList());
    }
//
    /* 5. 메뉴 등록 : save */
    @Transactional
    public void registNewMem(MemDTO newMem) {

        memRepository.save(modelMapper.map(newMem, Mem.class));

    }
//
    @Transactional
    public void modifyMem(MemDTO mem) {
        Mem foundMem = memRepository.findById(mem.getMemCode()).orElseThrow(IllegalArgumentException::new);
        foundMem.setMemName(mem.getMemName());
    }
//
    @Transactional
    public void deleteMenu(Integer memCode) {

        memRepository.deleteById(memCode);
    }
}

