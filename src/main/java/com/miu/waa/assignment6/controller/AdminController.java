package com.miu.waa.assignment6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @GetMapping
    public String getAdmin(){
        return "This URL for admin only ";
    }
}
