package com.hidagara.database.kursach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CompanyRestController {

    @Autowired
    private CompanyRepository companyRepository;


    @GetMapping("/company/{id}")
    public ResponseEntity<Optional<Company>> getCompanyById(@PathVariable Integer id) {
        Optional<Company> company = companyRepository.findById(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/company/list")
    public ResponseEntity<List<Company>> getAllUsers() {
        List<Company> company = companyRepository.findAll();
        return new ResponseEntity<List<Company>>(company, HttpStatus.OK);
    }

    @PutMapping(path = "/company/add", consumes = "application/json", produces = "application/json")
    public void addUser(@RequestBody Company company) {
        companyRepository.save(company);
    }

    @DeleteMapping(path = "/company/delete", consumes = "application/json", produces = "application/json")
    public void deleteUser(@RequestBody Company company) {
        companyRepository.delete(company);
    }

    @PatchMapping(path = "company/update", consumes = "application/json", produces = "application/json")
    public void updateUser(@RequestBody Company user) {

    }

}
