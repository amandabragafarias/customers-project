package com.customers.service;

import com.customers.entity.Customer;
import com.customers.repository.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CustomerService {
    @Inject
    CustomerRepository customerRepository;

    public void createNew(Customer customer){
        customerRepository.persist(customer);
    }
    public List<Customer> findAll(){
        return customerRepository.findAll().list();
    }

    public Customer findById(Long id){
      return customerRepository.findById(id);
    }
}
