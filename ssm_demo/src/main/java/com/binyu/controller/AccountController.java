package com.binyu.controller;

import com.binyu.domain.Account;
import com.binyu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @BelongsProject: ssm_demo
 * @BelongsPackage: com.binyu.controller
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-27 12:51
 * @Description:
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println ("controller findAll");
        List<Account> list = accountService.findAll ();
        model.addAttribute ( "list",list );
        return "findAll";
    }
    @RequestMapping("saveAcoount")
    public String saveAccount(Account account){
        System.out.println ("controller saveAccount");
        accountService.saveAccount ( account );
        return "saveAccount";
    }
}
