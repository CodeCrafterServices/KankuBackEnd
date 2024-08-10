package com.kanku.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @ManyToMany
    @JoinTable(name = "size_cart")
    private List<Size> sizes;
    private LocalDate cartDate;


//    @ManyToMany
//    @JoinTable(name = "customers_carts",
//    joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "cartId"),
//    inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customerId"))
//    @JsonBackReference
    private Long customer_id;

    private Integer cartProductQuantity;
}
