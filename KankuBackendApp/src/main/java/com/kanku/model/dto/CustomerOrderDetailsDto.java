package com.kanku.model.dto;

import lombok.Data;

@Data
public class CustomerOrderDetailsDto {

    private Long orderNumber;
    private String orderDate;
    private Integer orderQuantity;
    private String customerFullName;
    private String customerContactNumber;
    private String customerAddress;
    private String productCategory;
    private String productName;
    private String productDescription;
    private Double productUnitPrice;
    private byte[] productImage;
    private Double totalPrice;
    private Boolean deliveryStatus;
}
