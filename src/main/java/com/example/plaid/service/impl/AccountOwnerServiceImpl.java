package com.example.plaid.service.impl;

import com.example.plaid.dao.AccountOwnerDao;
import com.example.plaid.entity.BankAccountOwner;
import com.example.plaid.service.AccountOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountOwnerServiceImpl implements AccountOwnerService {

    @Autowired
    AccountOwnerDao accountOwnerDao;

    @Override
    public BankAccountOwner createAccountOwner(BankAccountOwner bankAccountOwner) {
        return accountOwnerDao.save(bankAccountOwner);
    }

    @Override
    public BankAccountOwner deleteAccountOwner(BankAccountOwner bankAccountOwner) {
        return null;
    }
}
