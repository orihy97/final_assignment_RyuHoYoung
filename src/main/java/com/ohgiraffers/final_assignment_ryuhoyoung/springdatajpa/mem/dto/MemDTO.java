package com.ohgiraffers.final_assignment_ryuhoyoung.springdatajpa.mem.dto;

public class MemDTO {
    public static Class<? extends MemDTO> depart;
    private int memCode;


    private String memName;

    private String memGender;

    private int memDepart;

    private String memAddress;

    public MemDTO() {

    }

    public MemDTO(int memCode, String memName, String memGender, int memDepart, String memAddress) {
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
        return "MemDTO{" +
                "memCode=" + memCode +
                ", memName='" + memName + '\'' +
                ", memGender='" + memGender + '\'' +
                ", memDepart=" + memDepart +
                ", memAddress='" + memAddress + '\'' +
                '}';
    }
}
