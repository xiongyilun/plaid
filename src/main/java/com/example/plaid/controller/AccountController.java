package com.example.plaid.controller;

import com.example.plaid.model.ACHResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@Controller
public class AccountController {

    @Value("${plaid.publickey}")
    private String publickey;

    @Value("${plaid.products}")
    private String products;

    @Value("${plaid.env}")
    private String env;

    @PostMapping("/ACHAccount")
    @ResponseBody
    public void addACHAccount(@RequestBody ACHResponse achResponse) throws IOException {
        log.info("begin achResponse:{}", achResponse);
    }

}