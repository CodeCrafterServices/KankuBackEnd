package com.kanku.service.impl;

import com.kanku.model.Product;
import com.kanku.model.Size;
import com.kanku.model.SpecialOffers;
import com.kanku.repository.IProductRepository;
import com.kanku.repository.ISizeRepository;
import com.kanku.repository.ISpecialOfferRepository;
import com.kanku.service.ISpecialOffers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class SpecialOffersImpl implements ISpecialOffers {

    @Autowired
    private ISpecialOfferRepository specialOfferRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ISizeRepository sizeRepository;

    @Override
    public SpecialOffers specialOffer(SpecialOffers specialOffers, MultipartFile file) throws IOException {

        System.out.println(specialOffers.getProduct());
        Product product = productRepository.findById(specialOffers.getProduct().getProductId()).get();

        Size size = sizeRepository.findById(specialOffers.getSize().getSizeId()).get();

        size.setProductDropPrice(specialOffers.getDropPrice());
        sizeRepository.save(size);

        byte[] imageData = file.getBytes();
        specialOffers.setOfferPosterImage(imageData);
        specialOffers.setProduct(product);
        return specialOfferRepository.save(specialOffers);
    }

    @Scheduled(cron = "0 0 0 * * ?") // Run every day at midnight
    @Transactional
    @Override
    public void updateProductDropPrice() {
        LocalDate today = LocalDate.now();
        //LocalDate today = LocalDate.of(2023, 7, 8); // year, month, day
        List<SpecialOffers> expiredOffers = specialOfferRepository.findBySpecialOfferEndDateBefore(today);

        System.out.println(expiredOffers);
        for (SpecialOffers offer : expiredOffers) {
            Size size = offer.getSize();
            if (size != null) {
                size.setProductDropPrice(size.getProductPrice()); // Reset the drop price to the original price
                sizeRepository.save(size);
            }
        }
    }
}
