package com.example.plaid.dao;

import com.example.plaid.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<BankAccount, Long> {

}
