package com.example.plaid.model;

import lombok.Data;

@Data
public class ACHResponse {

    private String public_token;

    private ACHAccount achAccount;

    private Institution institution;
}
