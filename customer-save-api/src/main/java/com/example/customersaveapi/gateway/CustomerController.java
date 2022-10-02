package com.example.customersaveapi.gateway;

import com.example.customersaveapi.model.CustomerJson;
import com.example.customersaveapi.service.SaveCustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("gateway/v1")
public class CustomerController {

    @Autowired
    private SaveCustomerService saveCustomerService;

    @PostMapping("/")
    public String create(@RequestBody CustomerJson customerJson) throws ExecutionException, JsonProcessingException, InterruptedException {
        return saveCustomerService.execute(customerJson);
    }


}
