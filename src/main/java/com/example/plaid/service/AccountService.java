package com.example.plaid.service;

import com.example.plaid.entity.BankAccount;

public interface AccountService {

    BankAccount createAccount(BankAccount bankAccount);

    BankAccount deleteAccount(BankAccount bankAccount);

}
