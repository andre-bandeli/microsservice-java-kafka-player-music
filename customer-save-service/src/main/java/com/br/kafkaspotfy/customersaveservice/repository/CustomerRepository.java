package com.br.kafkaspotfy.customersaveservice.repository;

import com.br.kafkaspotfy.customersaveservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {


}
