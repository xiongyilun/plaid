package com.example.plaid.controller;

import com.plaid.client.PlaidClient;
import com.plaid.client.request.AccountsBalanceGetRequest;
import com.plaid.client.request.ItemPublicTokenExchangeRequest;
import com.plaid.client.response.Account;
import com.plaid.client.response.AccountsBalanceGetResponse;
import com.plaid.client.response.ItemPublicTokenExchangeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
public class MainController {

    @Autowired
    PlaidClient plaidClient;

    private String accessToken;

    @RequestMapping("/get_access_token")
    public void get_access_token (String public_token) throws IOException {
        Response<ItemPublicTokenExchangeResponse> response = plaidClient.service()
                .itemPublicTokenExchange(new ItemPublicTokenExchangeRequest(public_token)).execute();

        if (response.isSuccessful()) {
            accessToken = response.body().getAccessToken();
        }
        
    }

    @RequestMapping("/balance")
    public List<Account> getBalance() throws IOException {
        List<Account> accountList = null;
        Response<AccountsBalanceGetResponse> response = plaidClient.service()
                .accountsBalanceGet(new AccountsBalanceGetRequest(accessToken)).execute();

        if (response.isSuccessful()) {
            accountList = response.body().getAccounts();
        }
        return accountList;

    }

}
