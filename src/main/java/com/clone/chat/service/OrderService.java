package com.clone.chat.service;

import com.clone.chat.dto.OrderDto;

public interface OrderService {

    void insertNewOrder(OrderDto orderDto) throws Exception;

}
