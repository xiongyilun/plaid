package com.example.plaid.service.impl;

import com.example.plaid.service.ACHAccountsService;
import org.springframework.stereotype.Service;

@Service("ACHAccountsService")
public class ACHAccountsServiceImpl implements ACHAccountsService {

    @Override
    public String getACHAccounts() {
        return "John Smith - Chase xxxx6875";
    }

    @Override
    public int removeACHAccounts(int id) {
        return 1;
    }
}
