package com.clone.chat.dto;

import lombok.Data;

@Data
public class OrderDto {
    private int customerId;
    private String productName;
    private int orderQuantity;
}
