package com.icat.retalimitaop.controller;


import com.icat.retalimitaop.service.Test;
import com.icat.retalimitaop.util.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Test test;

    @GetMapping(value = "test")
    public MyResult get(){
        return test.getResults();
    }
    @GetMapping(value = "test2")
    public MyResult get2(){
        return test.getResultTwo();
    }

}
