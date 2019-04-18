package com.example.plaid.dao;

import com.example.plaid.entity.BankAccountOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountOwnerDao extends JpaRepository<BankAccountOwner, Long> {
}
