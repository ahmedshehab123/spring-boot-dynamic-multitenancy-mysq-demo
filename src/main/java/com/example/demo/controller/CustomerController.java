package com.example.demo.controller;


import com.example.demo.model.entity.Customer;
import com.example.demo.model.repo.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {
    @Autowired
    ICustomerRepository repository;




    @GetMapping(value = "/customer")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAll() {
        // Return the DTO List:
        return (List<Customer>) repository.findAll();
    }


}
