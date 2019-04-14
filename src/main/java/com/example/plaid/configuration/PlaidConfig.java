package com.example.plaid.configuration;

import com.plaid.client.PlaidClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaidConfig {

    @Bean
    public PlaidClient getInstance(){
        PlaidClient plaidClient = PlaidClient.newBuilder()
                .clientIdAndSecret("5caea99a2db15200120fb24e", "789be268e2ce8c19d8a1774c1b3c2b")
                .publicKey("a3da65cc014515b2300226d16180c7") // optional. only needed to call endpoints that require a public key
                .sandboxBaseUrl() // or equivalent, depending on which environment you're calling into
                .build();
        return plaidClient;
    }
}
