package com.kanku.service;

import com.kanku.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    Product addProduct(Product product, MultipartFile file) throws IOException;

    List<Product> getAllProducts();

    Product updateProduct(Product product,MultipartFile file) throws IOException;

    Product deleteProduct(Product product);

    List<Product> getAllCategories();

    Product getProductById(Long id);

    List<Product> getProductsByCategory(Product product);

    Product fetchLastProduct();

}
