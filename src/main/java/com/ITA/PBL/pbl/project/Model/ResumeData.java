package com.ITA.PBL.pbl.project.Model;

import java.util.List;

public class ResumeData {

    private String name;
    private String email;
    private String phone;
    private List<String> skills;

    // Constructor
    public ResumeData(String name, String email, String phone, List<String> skills) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<String> getSkills() {
        return skills;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
