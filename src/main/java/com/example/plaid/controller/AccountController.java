package com.example.plaid.controller;

import com.example.plaid.model.ACHAccount;
import com.example.plaid.model.ACHResponse;
import com.example.plaid.model.Institution;
import com.example.plaid.service.PlaidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@Controller
public class AccountController {

    @Autowired
    private PlaidService plaidService;

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
        ACHAccount achAccount = achResponse.getAchAccount();
        Institution institution = achResponse.getInstitution();
        String public_token = achResponse.getPublic_token();

        String accessToken = plaidService.getAccessToken(public_token);

        String accountNumber = plaidService.getAccountNumber(accessToken,achAccount.getId());

        log.info("end");

        //保存数据进bank_account以及bank_account_owner表

    }

    @GetMapping("/ACHAccount")
    public String getACHAccount(Model model){
        model.addAttribute("publickey",publickey);
        model.addAttribute("env",env);
        model.addAttribute("products",products);
        return "index";
    }

    @DeleteMapping("/ACHAccount")
    public int deleteAccount(){
        return 1;
    }


}
