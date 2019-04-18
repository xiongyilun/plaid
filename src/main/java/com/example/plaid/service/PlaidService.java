package com.example.plaid.service;

import com.plaid.client.response.AuthGetResponse;

import java.io.IOException;

public interface PlaidService {

    String getAccessToken(String publicToken) throws IOException;

    AuthGetResponse.NumberACH getACHAccount(String accessToken, String accountId) throws IOException;
}
