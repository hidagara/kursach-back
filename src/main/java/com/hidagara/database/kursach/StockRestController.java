package com.hidagara.database.kursach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StockRestController {

    @Autowired
    StockRepository stockRepository;

    @GetMapping("/market/{id}")
    public ResponseEntity<Optional<Stock>> getbyId(@PathVariable Integer id) {
        Optional<Stock> stock = stockRepository.findById(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @GetMapping("/market/list")
    public ResponseEntity<List<Stock>> getAllUsers() {
        List<Stock> user = stockRepository.findAll();
        return new ResponseEntity<List<Stock>>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/market/add", consumes = "application/json", produces = "application/json")
    public void addUser(@RequestBody Stock stock) {
        stockRepository.saveAndFlush(stock);
    }

    @DeleteMapping(path = "/market/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        stockRepository.deleteById(id);
    }

    @PatchMapping(path = "market/update", consumes = "application/json", produces = "application/json")
    public void updateUser(@RequestBody Stock stock) {
        stockRepository.save(stock);
    }
}
