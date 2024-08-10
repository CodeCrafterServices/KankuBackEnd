package com.kanku.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompletedOrderDetailsDto {
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