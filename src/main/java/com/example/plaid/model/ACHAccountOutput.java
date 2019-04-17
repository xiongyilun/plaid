package com.example.plaid.model;

import lombok.Data;

@Data
public class ACHAccountOutput {

    private String userName;
    private String institutionName;
    private String accountNumber;
}
