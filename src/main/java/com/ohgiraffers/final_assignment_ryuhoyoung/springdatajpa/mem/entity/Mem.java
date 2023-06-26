package com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_mem")
public class Mem {
    public static Class<? extends Mem> depart;
    @Id
    @Column(name="mem_code")
    private int memCode;

    @Column(name="mem_name")
    private String memName;
    @Column(name="mem_gender")
    private String memGender;
    @Column(name="mem_depart")
    private int memDepart;
    @Column(name="mem_address")
    private String memAddress;

public Mem(){}

    public Mem(int memCode, String memName, String memGender, int memDepart, String memAddress) {
        this.memCode = memCode;
        this.memName = memName;
        this.memGender = memGender;
        this.memDepart = memDepart;
        this.memAddress = memAddress;
    }

    public int getMemCode() {
        return memCode;
    }

    public void setMemCode(int memCode) {
        this.memCode = memCode;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemGender() {
        return memGender;
    }

    public void setMemGender(String memGender) {
        this.memGender = memGender;
    }

    public int getMemDepart() {
        return memDepart;
    }

    public void setMemDepart(int memDepart) {
        this.memDepart = memDepart;
    }

    public String getMemAddress() {
        return memAddress;
    }

    public void setMemAddress(String memAddress) {
        this.memAddress = memAddress;
    }

    @Override
    public String toString() {
        return "Mem{" +
                "memCode=" + memCode +
                ", memName='" + memName + '\'' +
                ", memGender='" + memGender + '\'' +
                ", memDepart=" + memDepart +
                ", memAddress='" + memAddress + '\'' +
                '}';
    }
}
