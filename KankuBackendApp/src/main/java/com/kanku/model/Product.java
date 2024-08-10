package com.kanku.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productId")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;


    @Column(columnDefinition = "LONGTEXT")
    private String productDescription;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] productImage;
    private LocalDate productDate;
    private String productCategory;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    private List<ProductOrder> productOrders;


    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Size> sizes;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SpecialOffers> specialOffers;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    @JsonIgnore
//    @JsonManagedReference
//    private List<Stock> stocks;
}
