package com.kanku.controller;

import com.kanku.model.Product;
import com.kanku.model.Size;
import com.kanku.model.SpecialOffers;
import com.kanku.service.ISpecialOffers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;


@RestController
@RequestMapping("/specialOffer")
@CrossOrigin("*")
public class SpecialOfferController {

    @Autowired
    private ISpecialOffers specialOffer;

    @PostMapping("/specialOffer")
    public ResponseEntity<?> specialOffer(@ModelAttribute("offerTitle") String offerTitle,
                                          @ModelAttribute("offerDescription") String offerDescription,
                                          @ModelAttribute("product") Product product,
                                          @ModelAttribute("dropPrice")Double dropPrice,
                                          @ModelAttribute("specialOfferStartDate") LocalDate specialOfferStartDate,
                                          @ModelAttribute("specialOfferEndDate") LocalDate specialOfferEndDate,
                                          @RequestParam("offerPosterImage") MultipartFile file) throws IOException {

        SpecialOffers specialOffers=new SpecialOffers();
        specialOffers.setOfferTitle(offerTitle);
        specialOffers.setOfferDescription(offerDescription);

        //
        Product pr=new Product();
        pr.setProductId(1L);
        specialOffers.setProduct(pr);

        Size size=new Size();
        size.setSizeId(9L);
        specialOffers.setSize(size);
        //

        specialOffers.setDropPrice(dropPrice);
        specialOffers.setSpecialOfferStartDate(specialOfferStartDate);
        specialOffers.setSpecialOfferEndDate(specialOfferEndDate);
        return ResponseEntity.ok(specialOffer.specialOffer(specialOffers,file));
    }

    @PutMapping("/updateSpecialOffer")
    public ResponseEntity<?> updateSpecialOffer(){
        specialOffer.updateProductDropPrice();
        return ResponseEntity.ok("special offer expired...!");
    }
}
