package com.clone.chat.mapper;

import com.clone.chat.dto.CustomerDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<CustomerDto> getAllUser() throws Exception;

    void insertCustomer(CustomerDto customerDto) throws Exception;
    int getCustomerMoney(int id) throws Exception;
}
