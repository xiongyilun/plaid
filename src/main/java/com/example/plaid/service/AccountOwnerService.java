package com.example.plaid.service;


import com.example.plaid.entity.BankAccountOwner;

public interface AccountOwnerService {

    BankAccountOwner createAccountOwner(BankAccountOwner bankAccountOwner);

    BankAccountOwner deleteAccountOwner(BankAccountOwner bankAccountOwner);
}
