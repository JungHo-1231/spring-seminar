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
        // 회원이 보유한 금액이 얼마인지 알아내기
        int customerMoney = orderMapper.getCustomerMoney(orderDto.getCustomerId());
        System.out.println("회원이 보유한 금액 " +customerMoney);

        // 상품 가격 알아내기 * 상품 주문 수량 알아내기
        int productPrice = orderMapper.getProductPrice(orderDto);
        System.out.println("상품 가격 "  + productPrice);

        int orderQuantity = orderDto.getOrderQuantity();
        System.out.println("주문 수량 " + orderQuantity);

        int totalOrderPrice = productPrice * orderQuantity;
        if (customerMoney <totalOrderPrice ){
            System.out.println("회원 보유 금액 : " +customerMoney  + " 총 주문 금액 " + totalOrderPrice);
            System.out.println("회원의 금액이 부족합니다");
            return;
        }


        // 상품 재고보다 주문 상품 수량이 더 많은 지 확인하기
        int productQuantity = orderMapper.getProductQuantity(orderDto);

        if (productQuantity < orderQuantity){
            System.out.println("재고가 부족합니다");
            return;
        }

        orderMapper.insertOrder(orderDto);



    }
}
