package com.kanku.controller;

import com.kanku.model.Product;
import com.kanku.model.ProductOrder;
import com.kanku.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(
            @ModelAttribute("productName") String productName,
            @ModelAttribute("productDescription") String productDescription,
//            @ModelAttribute("productDate") LocalDate productDate,
            @RequestParam("productImage") MultipartFile file,
            @ModelAttribute("productCategory") String productCategory) throws IOException {
        Product product = new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductCategory(productCategory);
        product.setProductDate(LocalDate.now());
        System.out.println(productName);

        return ResponseEntity.ok(productService.addProduct(product,file));
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts(){

        System.out.println(productService.getAllProducts());
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.deleteProduct(product));
    }


    @PatchMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(
            @ModelAttribute("productId") Long productId,
            @ModelAttribute("productName") String productName,
            @ModelAttribute("productDescription") String productDescription,
            @RequestParam("productImage") MultipartFile file,
            @ModelAttribute("productCategory") String productCategory
    ) throws IOException {

        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductCategory(productCategory);
        System.out.println(productName);
        return ResponseEntity.ok(productService.updateProduct(product,file));
    }


    @GetMapping("/getProductCategories")
    public ResponseEntity<?> getAllProductCategories(){
        return ResponseEntity.ok(productService.getAllCategories());
    }

    @PostMapping("/getProductByCategory")
    public ResponseEntity<?> getProductByCategory(@RequestBody Product product){

        return ResponseEntity.ok(productService.getProductsByCategory(product));
    }

    @GetMapping("/getLastProduct")
    public ResponseEntity<?> getLastProduct(){

        return ResponseEntity.ok(productService.fetchLastProduct());
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.getProductById(id));
    }


}

