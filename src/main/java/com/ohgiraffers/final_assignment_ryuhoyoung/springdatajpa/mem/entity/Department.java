package com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_depart")
public class Department {
    @Id
    @Column(name="mem_depart")
    private int memDepart;

    @Column(name="depart_leader")
    private String departLeader;
    @Column(name="depart_career")
    private String departCareer;
    public Department(){}

    public Department(int memDepart, String departLeader, String departCareer) {
        this.memDepart = memDepart;
        this.departLeader = departLeader;
        this.departCareer = departCareer;
    }

    public int getMemDepart() {
        return memDepart;
    }

    public void setMemDepart(int memDepart) {
        this.memDepart = memDepart;
    }

    public String getDepartLeader() {
        return departLeader;
    }

    public void setDepartLeader(String departLeader) {
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
        return "Class{" +
                "memClass=" + memDepart +
                ", classTea='" + departLeader + '\'' +
                ", classMent='" + departCareer + '\'' +
                '}';
    }
}
