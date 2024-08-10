package com.kanku.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    private String supplierName;

    @Column(unique = true)
    private String supplierEmail;

    @Column(unique = true)
    private String supplierContact;

    private String supplierAddress;

    private LocalDate supplierDate;
}
