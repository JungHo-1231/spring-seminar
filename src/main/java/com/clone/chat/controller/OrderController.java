package com.clone.chat.controller;

import com.clone.chat.dto.OrderDto;
import com.clone.chat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void addNewOrder(@RequestBody OrderDto orderDto ) throws Exception {
        orderService.insertNewOrder(orderDto);
    }
}
