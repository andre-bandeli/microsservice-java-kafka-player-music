package com.br.kafkaspotfy.customersaveservice.controller;

import com.br.kafkaspotfy.customersaveservice.model.CustomerJson;
import com.br.kafkaspotfy.customersaveservice.service.SaveCustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private SaveCustomerService saveCustomerService;

    @PostMapping("/post")
    public String create(@RequestBody CustomerJson customerJson) throws ExecutionException, JsonProcessingException, InterruptedException {
        return saveCustomerService.execute(customerJson);
    }


}
