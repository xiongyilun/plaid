package com.example.plaid.controller;

import com.example.plaid.service.ACHAccountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author nolan
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/accounts")
@Slf4j
public class ACHAccountsController {

    @Autowired
    ACHAccountsService achAccountsService;

    @GetMapping("/ach/index")
    public String index(){
        return "achpage";
    }

    @GetMapping("ach/link")
    @ResponseBody
    public String verify(){
        String accounts = achAccountsService.getACHAccounts();
        return accounts;
    }

    @DeleteMapping("ach/{id}")
    @ResponseBody
    public int removeACHAccount(@PathVariable(value = "id") int id){
        int delete = achAccountsService.removeACHAccounts(id);
        return delete;
    }
}
