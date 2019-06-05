package com.hidagara.database.kursach;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository  extends JpaRepository<Wallet, Integer>  {
    List<Wallet> findByUserId(Integer id);
}