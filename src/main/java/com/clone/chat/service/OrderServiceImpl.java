package com.clone.chat.service;

import com.clone.chat.dto.OrderDto;
import com.clone.chat.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void insertNewOrder(OrderDto orderDto) throws Exception {
        // 회원이 총 얼마 있는지 알아내기
        int _customerMoney = orderMapper.getCustomerMoney(orderDto.getCustomerId());
        Integer customerMoney = Optional.ofNullable(_customerMoney).orElse(0);
        System.out.println(customerMoney);

        // 상품 가격 알아내기 * 수량 알아내기

//        int productPrice

    }
}
