package com.example.plaid.configuration;

import com.plaid.client.PlaidClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaidConfig {

    @Value("${plaid.clientId}")
    public String clientId;

    @Value("${plaid.secret}")
    public String secret;

    @Value("${plaid.publickey}")
    public String publickey;

    @Bean
    public PlaidClient getInstance(){

        PlaidClient plaidClient = PlaidClient.newBuilder()
                .clientIdAndSecret(clientId, secret)
                .publicKey(publickey)
                .sandboxBaseUrl()
                .build();
        return plaidClient;
    }
}
