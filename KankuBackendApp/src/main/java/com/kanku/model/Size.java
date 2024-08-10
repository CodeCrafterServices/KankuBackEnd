package com.kanku.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long sizeId;
    private String sizeType;

    private Double productDropPrice;
    private Double productPrice;
    private Integer totalProductQuantity;
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "size")
    private List<ProductOrder> productOrders;


    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL)
    private List<SpecialOffers> specialOffers;



//    @ManyToMany(mappedBy = "sizes")
//    private List<Product> products;
}
