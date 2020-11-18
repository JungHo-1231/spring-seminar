package com.clone.chat.dto;

public class OrderResultDto {
    private int customerId;
    private String productName;
    private int updateCustomerMoney;
    private int updateProductQuantity;


    public OrderResultDto(int customerId, String productName, int updateCustomerMoney, int updateProductQuantity) {
        this.customerId = customerId;
        this.productName = productName;
        this.updateCustomerMoney = updateCustomerMoney;
        this.updateProductQuantity = updateProductQuantity;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUpdateCustomerMoney() {
        return updateCustomerMoney;
    }

    public void setUpdateCustomerMoney(int updateCustomerMoney) {
        this.updateCustomerMoney = updateCustomerMoney;
    }

    public int getUpdateProductQuantity() {
        return updateProductQuantity;
    }

    public void setUpdateProductQuantity(int updateProductQuantity) {
        this.updateProductQuantity = updateProductQuantity;
    }

    @Override
    public String toString() {
        return "OrderResultDto{" +
                "customerId=" + customerId +
                ", productName='" + productName + '\'' +
                ", updateCustomerMoney=" + updateCustomerMoney +
                ", updateProductQuantity=" + updateProductQuantity +
                '}';
    }
}


