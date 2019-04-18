package com.example.plaid.controller;

import com.example.plaid.entity.BankAccount;
import com.example.plaid.entity.BankAccountOwner;
import com.example.plaid.entity.embed.BankAccountOwnerId;
import com.example.plaid.model.ACHAccount;
import com.example.plaid.model.ACHResponse;
import com.example.plaid.model.Institution;
import com.example.plaid.service.AccountOwnerService;
import com.example.plaid.service.AccountService;
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

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountOwnerService accountOwnerService;

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

        //保存数据进bank_account表
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountName(achAccount.getName());
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setRoutingNumber("123123");
        accountService.createAccount(bankAccount);

        //保存数据进bank_account_owner表
        BankAccountOwner accountOwner = new BankAccountOwner();
        accountOwner.setId(new BankAccountOwnerId(123L, 456L));
        accountOwnerService.createAccountOwner(accountOwner);

        log.info("end");


    }

    @GetMapping("/ACHAccount")
    public String getACHAccount(Model model){
        //查询DataAPI获取Account数据
        model.addAttribute("publickey",publickey);
        model.addAttribute("env",env);
        model.addAttribute("products",products);

        return "index";
    }

    @DeleteMapping("/ACHAccount")
    public int deleteAccount(){
        //删除bank_account以及bank_account_owner中对应的数据

        return 1;
    }

}