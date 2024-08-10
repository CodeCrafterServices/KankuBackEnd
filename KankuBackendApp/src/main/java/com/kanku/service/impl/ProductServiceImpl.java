package com.kanku.service.impl;

import com.kanku.model.Product;
import com.kanku.repository.IProductRepository;
import com.kanku.repository.ISpecialOfferRepository;
import com.kanku.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ISpecialOfferRepository specialOfferRepository;

//    final String PATH = "";

    @Override
    public Product addProduct(Product product, MultipartFile file) throws IOException {

        byte[] imageData = file.getBytes();
        product.setProductImage(imageData);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product,MultipartFile file) throws IOException {

        if(productRepository.existsById(product.getProductId())){

            Product pr=productRepository.findById(product.getProductId()).get();

            pr.setProductName(product.getProductName());
            pr.setProductDescription(product.getProductDescription());
            pr.setProductCategory(product.getProductCategory());

            byte[] imageData = file.getBytes();
            pr.setProductImage(imageData);
            return productRepository.save(pr);
        }
        return product;
    }

    @Override
    public Product deleteProduct(Product product) {

        if(productRepository.existsById(product.getProductId())){
            productRepository.deleteById(product.getProductId());
        }
        return null;
    }



    @Override
    public List<Product> getAllCategories() {
        List<Product> products = productRepository.findAll();
        Collection<Product> uniqueProducts = products.stream()
                .collect(Collectors.toMap(
                        Product::getProductCategory,
                        product -> product,
                        (existing, replacement) -> replacement
                ))
                .values();
        return new ArrayList<>(uniqueProducts);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductByProductId(id);
    }

    @Override
    public List<Product> getProductsByCategory(Product product) {
        return productRepository.getProductsByProductCategory(product.getProductCategory());
    }

    @Override
    public Product fetchLastProduct() {

        if(productRepository.findLastProduct().isPresent()){
            return productRepository.findLastProduct().get();
        }
        return null;
    }



}

