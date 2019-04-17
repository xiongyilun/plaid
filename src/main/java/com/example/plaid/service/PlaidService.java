package com.example.plaid.service;

import java.io.IOException;

public interface PlaidService {

    String getAccessToken(String publicToken) throws IOException;

    String getAccountNumber(String accessToken,String accountId) throws IOException;
}
