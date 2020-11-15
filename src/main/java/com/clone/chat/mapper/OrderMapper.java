package com.clone.chat.mapper;

import com.clone.chat.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void insertOrder(OrderDto orderDto) throws Exception;
    int getCustomerMoney(int customerId) throws Exception;
    int getProductPrice(OrderDto orderDto) throws Exception;
    int getProductQuantity(OrderDto orderDto) throws Exception;

}
