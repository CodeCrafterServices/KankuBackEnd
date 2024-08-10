package com.kanku.service;

import com.kanku.model.SpecialOffers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ISpecialOffers {
    SpecialOffers specialOffer(SpecialOffers specialOffers, MultipartFile file) throws IOException;

    void updateProductDropPrice();
}
