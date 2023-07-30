package com.example.adaptit;

public class Bursary {
    public String name;
    public String companyName;
    public String description;

    public Bursary(String name, String companyName, String description) {
        this.name = name;
        this.companyName = companyName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
