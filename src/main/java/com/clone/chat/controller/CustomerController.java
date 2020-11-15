package com.clone.chat.controller;

import com.clone.chat.dto.CustomerDto;
import com.clone.chat.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() throws Exception {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public void addNewCustomer(@RequestBody CustomerDto customerDto) throws Exception {
        customerService.insertCustomer(customerDto);
    }

}
