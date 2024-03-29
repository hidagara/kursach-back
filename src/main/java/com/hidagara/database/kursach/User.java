package com.hidagara.database.kursach;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "email_address")
    private String email;
    private String password;
    private String country;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Wallet> wallets = new ArrayList<>();

    public User() {

    }

    public User(String name, String email, String password, String country) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}