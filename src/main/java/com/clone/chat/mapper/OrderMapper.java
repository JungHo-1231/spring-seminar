package com.clone.chat.mapper;

import com.clone.chat.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void insertOrder(OrderDto orderDto) throws Exception;
    Integer getCustomerMoney(int customerId) throws Exception;

}
