package com.clone.chat.mapper;

import com.clone.chat.dto.OrderDto;
import com.clone.chat.dto.OrderResultDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    void insertOrder(OrderDto orderDto) throws Exception;
    int getCustomerMoney(int customerId) throws Exception;
    int getProductPrice(OrderDto orderDto) throws Exception;
    int getProductQuantity(OrderDto orderDto) throws Exception;
    void subtractCustomerMoney(OrderResultDto orderResultDto) throws Exception;
    void subtractProductQuantity(OrderResultDto orderResultDto) throws Exception;

}
