package com.clone.chat.service;

import com.clone.chat.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

     List<CustomerDto> getAllCustomers () throws Exception;

     void insertCustomer(CustomerDto customerDto) throws Exception;


}
