package com.example.demo.controller;

import irita.sdk.client.IritaClient;
import irita.sdk.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SdkController {
    @Autowired
    private IritaClient iritaClient;

    @GetMapping("query_account")
    public Account queryAccount() {
        return iritaClient.getBaseClient().queryAccount("iaa1ytemz2xqq2s73ut3ys8mcd6zca2564a5lfhtm3");
    }
}
