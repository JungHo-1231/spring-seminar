package com.clone.chat.service;

import com.clone.chat.dto.CustomerDto;
import com.clone.chat.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws Exception {
        return customerMapper.getAllUser();
    }

    @Override
    public void insertCustomer(CustomerDto customerDto) throws Exception {
        customerMapper.insertCustomer(customerDto);
    }
}
