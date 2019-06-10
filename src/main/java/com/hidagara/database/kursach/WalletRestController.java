package com.hidagara.database.kursach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WalletRestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletRepository walletRepository;

    @GetMapping("/wallet/{userId}")
    public ResponseEntity<List<Wallet>> getWalletByUserId(@PathVariable String userId) {
        List<Wallet> wallet = walletRepository.findByUserId(Integer.valueOf(userId));
//        User user = userRepository.findByName(name);
        return new ResponseEntity<List<Wallet>>(wallet, HttpStatus.OK);
    }



}
