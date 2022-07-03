package com.br.kafkaspotfy.customersaveservice.service;

import com.br.kafkaspotfy.customersaveservice.model.Customer;
import com.br.kafkaspotfy.customersaveservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public UUID execute(Customer customer) {
        customer.setId(UUID.randomUUID());
        customerRepository.save(customer);

        return customer.getId();
    }

}
