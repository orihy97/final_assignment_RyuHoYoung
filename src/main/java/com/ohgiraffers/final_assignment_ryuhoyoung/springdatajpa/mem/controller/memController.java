package com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.controller;

import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.common.Pagenation;
import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.common.PagingButtonInfo;
import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.dto.DepartDTO;
import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.dto.MemDTO;
import com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.service.MemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mem")
public class memController {
    private final MemService memService;
    private Integer memDepart;

    public memController(MemService memService){this.memService=memService;}

    @GetMapping("/{memCode}")
    public String findMemByCode(@PathVariable int memCode, Model model){
        MemDTO mem = memService.findMemByCode(memCode);
        model.addAttribute("mem",mem);

        return"mem/detail";
    }

    @GetMapping("/list")
    public String findMemList(@PageableDefault Pageable pageable, Model model) {
        /* page -> number, size, sort 파라미터가 Pageable 객체에 담긴다. */
        log.info("pageable : {}", pageable);

        Page<MemDTO> memList = memService.findMemList(pageable);

        log.info("조회한 내용 목록 : {}", memList.getContent());
        log.info("총 페이지 수 : {}", memList.getTotalPages());
        log.info("총 메뉴 수 : {}", memList.getTotalElements());
        log.info("해당 페이지에 표시 될 요소 수 : {}", memList.getSize());
        log.info("해당 페이지에 실제 요소 수 : {}", memList.getNumberOfElements());
        log.info("첫 페이지 여부 : {}", memList.isFirst());
        log.info("마지막 페이지 여부 : {}", memList.isLast());
        log.info("정렬 방식 : {}", memList.getSort());
        log.info("여러 페이지 중 현재 인덱스 : {}", memList.getNumber());

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(memList);
        model.addAttribute("paging", paging);
        model.addAttribute("memList", memList);

        return "mem/list";
    }

    @GetMapping("querymethod")
    public void queryMethodPage() {}
//
    @GetMapping("search")
    public String findByMemDepart(@RequestParam Integer memDepart, Model model) {

        List<MemDTO> memList = memService.findByMemDepart(memDepart);

        model.addAttribute("memList", memList);
        model.addAttribute("memDepart", memDepart);

        return "mem/searchResult";
    }
//
    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping(value="depart", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<DepartDTO> findClassList() {

        return memService.findAllDepart();
    }
//
    @PostMapping("/regist")
    public String registMem(MemDTO mem) {

        memService.registNewMem(mem);

        return "redirect:/mem/list";

    }
//
    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyMenu(MemDTO mem) {

        memService.modifyMem(mem);

        return "redirect:/mem/" + mem.getMemCode();
    }
//
    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete")
    public String deleteMem(@RequestParam Integer memCode) {

        memService.deleteMenu(memCode);

        return "redirect:/mem/list";
    }




}
