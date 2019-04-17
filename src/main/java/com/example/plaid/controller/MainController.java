package com.example.plaid.controller;

import com.example.plaid.model.ACHAccount;
import com.example.plaid.model.ACHResponse;
import com.example.plaid.model.Institution;
import com.plaid.client.PlaidClient;
import com.plaid.client.request.AuthGetRequest;
import com.plaid.client.request.ItemPublicTokenExchangeRequest;
import com.plaid.client.response.AuthGetResponse;
import com.plaid.client.response.ItemPublicTokenExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;


@RestController
public class MainController {

    @Autowired
    PlaidClient plaidClient;

    @RequestMapping("/get_access_token")
    @ResponseBody
    public void get_access_token(@RequestBody ACHResponse achResponse) throws IOException {
        String accessToken = null;

        ACHAccount achAccount = achResponse.getAchAccount();
        Institution institution = achResponse.getInstitution();
        String public_token = achResponse.getPublic_token();

        //获取access_token
        Response<ItemPublicTokenExchangeResponse> response = plaidClient.service()
                .itemPublicTokenExchange(new ItemPublicTokenExchangeRequest(public_token)).execute();

        if (response.isSuccessful()) {
            accessToken = response.body().getAccessToken();
        }

        //获取account数据
        Response<AuthGetResponse> authGetResponse = plaidClient.service()
                .authGet(new AuthGetRequest(accessToken)).execute();

        String accountNumber = null;

        if (response.isSuccessful()) {
            List<AuthGetResponse.NumberACH> numberACHList = authGetResponse.body().getNumbers().getACH();
            for (AuthGetResponse.NumberACH numberACH : numberACHList) {
                if (numberACH.getAccountId().equals(achAccount.getId())) {
                    accountNumber = numberACH.getAccount();
                    break;
                }
            }
        }

    }


}
