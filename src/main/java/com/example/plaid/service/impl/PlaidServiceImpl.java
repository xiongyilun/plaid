package com.example.plaid.service.impl;

import com.example.plaid.service.PlaidService;
import com.plaid.client.PlaidClient;
import com.plaid.client.request.AuthGetRequest;
import com.plaid.client.request.ItemPublicTokenExchangeRequest;
import com.plaid.client.response.AuthGetResponse;
import com.plaid.client.response.ItemPublicTokenExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class PlaidServiceImpl implements PlaidService {

    @Autowired
    PlaidClient plaidClient;

    @Override
    public String getAccessToken(String publicToken) throws IOException {
        String accessToken = null;
        //获取access_token
        Response<ItemPublicTokenExchangeResponse> response = plaidClient.service()
                .itemPublicTokenExchange(new ItemPublicTokenExchangeRequest(publicToken)).execute();

        if (response.isSuccessful()) {
            accessToken = response.body().getAccessToken();
        }

        return accessToken;
    }

    @Override
    public String getAccountNumber(String accessToken,String accountId) throws IOException {
        //获取account数据
        Response<AuthGetResponse> authGetResponse = plaidClient.service()
                .authGet(new AuthGetRequest(accessToken)).execute();

        String accountNumber = null;

        if (authGetResponse.isSuccessful()) {
            List<AuthGetResponse.NumberACH> numberACHList = authGetResponse.body().getNumbers().getACH();
            for (AuthGetResponse.NumberACH numberACH : numberACHList) {
                if (numberACH.getAccountId().equals(accountId)) {
                    accountNumber = numberACH.getAccount();
                    break;
                }
            }
        }

        return accountNumber;
    }
}
