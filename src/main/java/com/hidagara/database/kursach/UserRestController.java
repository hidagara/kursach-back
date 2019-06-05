package com.hidagara.database.kursach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserByName(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user/list")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> user = userRepository.findAll();
        return new ResponseEntity<List<User>>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/user/add", consumes = "application/json", produces = "application/json")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping(path = "/user/delete", consumes = "application/json", produces = "application/json")
    public void deleteUser(@RequestBody User user) {
        userRepository.delete(user);
    }

    @PatchMapping(path = "user/update", consumes = "application/json", produces = "application/json")
    public void updateUser(@RequestBody User user) {

    }

    @GetMapping("/user/addwallet/{name}")
    public ResponseEntity<User> addWalletToUser(@PathVariable String name) {
        User user = userRepository.findByName(name);
        List<Wallet> walletList = new ArrayList<>();
        Wallet wallet = new Wallet(user);
        walletList.add(wallet);
        user.setWallets(walletList);
        userRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
