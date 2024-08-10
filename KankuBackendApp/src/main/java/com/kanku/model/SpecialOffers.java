package com.kanku.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class SpecialOffers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialOfferId;

    private String offerTitle;
    private String offerDescription;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] offerPosterImage;
    private Double dropPrice;
    private LocalDate specialOfferStartDate;
    private LocalDate specialOfferEndDate;
}
