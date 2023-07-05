package com.customers.controller;

import com.customers.entity.Customer;
import com.customers.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.ArrayList;
import java.util.List;

@Path("/api/customers")
public class CustomerController {
    @Inject
    CustomerService customerService;
    
    @POST
    @Transactional
    public void createNew(Customer customer){
        customerService.createNew(customer);
    }
    
    @GET
    public List<Customer> retriveCustomers(){
        List<Customer> customers = new ArrayList<>();
        try {
            customers = customerService.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }
   @GET
   @Path("/api/customers/{id}")
    public Customer findById(Long id){
      Customer customer = null;
        try {
            customer = customerService.findById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    } 
}
