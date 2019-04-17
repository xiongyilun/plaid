package com.example.plaid.model;

import lombok.Data;

@Data
public class ACHAccount {

    private String id;
    private String mask;
    private String name;
    private String subtype;
    private String type;
}
