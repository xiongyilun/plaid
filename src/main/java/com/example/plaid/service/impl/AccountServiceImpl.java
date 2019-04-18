package com.example.plaid.service.impl;

import com.example.plaid.dao.AccountDao;
import com.example.plaid.entity.BankAccount;
import com.example.plaid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public BankAccount createAccount(BankAccount bankAccount) {
        return accountDao.save(bankAccount);
    }

    @Override
    public BankAccount deleteAccount(BankAccount bankAccount) {
        return null;
    }
}
