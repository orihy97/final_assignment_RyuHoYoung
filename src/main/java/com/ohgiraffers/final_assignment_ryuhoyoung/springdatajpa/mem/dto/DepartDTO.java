package com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.dto;

public class DepartDTO {
    public static Class<? extends Object> depart;
    private int memDepart;
    private String departLeader;

    private String departCareer;

    public DepartDTO(){}

    public DepartDTO(int memDepart, String departLeader, String departCareer) {
        this.memDepart = memDepart;
        this.departLeader = departLeader;
        this.departCareer = departCareer;
    }

    public int getMemDepart() {
        return memDepart;
    }

    public void setMemDepart(int memClass) {
        this.memDepart = memDepart;
    }

    public String getDepartLeader() {
        return departLeader;
    }

    public void setDepartLeader(String classTea) {
        this.departLeader = departLeader;
    }

    public String getDepartCareer() {
        return departCareer;
    }

    public void setDepartCareer(String departCareer) {
        this.departCareer = departCareer;
    }

    @Override
    public String toString() {
        return "DepartDTO{" +
                "memDepart=" + memDepart +
                ", departLeader='" + departLeader + '\'' +
                ", departCareer='" + departCareer + '\'' +
                '}';
    }
}
