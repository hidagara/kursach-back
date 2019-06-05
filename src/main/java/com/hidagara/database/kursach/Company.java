package com.hidagara.database.kursach;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String abreviature;
    private String description;

    public Company() {

    }

    public Company(String name, String abreviature, String description) {
        this.name = name;
        this.abreviature = abreviature;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbreviature() {
        return abreviature;
    }

    public void setAbreviature(String abreviature) {
        this.abreviature = abreviature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
