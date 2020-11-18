package com.clone.chat.service;

import com.clone.chat.dto.OrderDto;
import com.clone.chat.dto.OrderResultDto;
import com.clone.chat.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        int orderQuantity = orderDto.getOrderQuantity();
        int customerMoney = orderMapper.getCustomerMoney(orderDto.getCustomerId());
        int productQuantity = orderMapper.getProductQuantity(orderDto);
        int productPrice = orderMapper.getProductPrice(orderDto);
        int updateCustomerMoney = customerMoney - productPrice;
        int updateProductQuantity = productQuantity - orderQuantity;

        OrderResultDto  orderResultDto = new OrderResultDto(orderDto.getCustomerId(),
                    orderDto.getProductName(), updateCustomerMoney, updateProductQuantity
                );
        boolean customerHaveEnoughMoney = checkCustomerHaveEnoughMoney(orderDto);
        boolean productHaveEnoughQuantity = checkProductHaveEnoughQuantity(orderDto);

        if(customerHaveEnoughMoney && productHaveEnoughQuantity){

            // 상품 주문 완료
            orderMapper.insertOrder(orderDto);

            // 상품 주문 완료와 동시에 주문 회원 돈 차감
            transactionTest(orderResultDto);
            // 회원 테이블에 남은 업데이트
        }

        if(updateCustomerMoney <0){
            System.out.println("잔액이 부족합니다. 돈 확인하세요.");
        } else {
            System.out.println("회원 남은 돈 " + updateCustomerMoney);
        }


    }

    @Transactional
    public void transactionTest(OrderResultDto orderResultDto) throws Exception {
            // 회원이 가지고 있던 금액 - 상품 주문 금액
            // 기존 상품 수량이 차감되어야 한다.
            // 상품 수량 - 고객이 주문한 상품
        orderMapper.subtractCustomerMoney(orderResultDto);
        orderMapper.subtractProductQuantity(orderResultDto);

        System.out.println("주문이 성공적으로 완료되었습니다.");
    }

    public boolean checkCustomerHaveEnoughMoney(OrderDto orderDto) throws Exception {
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
            return false;
        }

        return true;
    }

    public boolean checkProductHaveEnoughQuantity(OrderDto orderDto) throws Exception {
        int orderQuantity = orderDto.getOrderQuantity();
        // 상품 재고보다 주문 상품 수량이 더 많은 지 확인하기
        int productQuantity = orderMapper.getProductQuantity(orderDto);

        if (productQuantity < orderQuantity){
            System.out.println("재고가 부족합니다");
            return false;
        }
        return true;
    }
}
