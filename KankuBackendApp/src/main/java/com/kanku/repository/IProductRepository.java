package com.kanku.repository;

import com.kanku.model.Product;
import com.kanku.model.SpecialOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Native;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

//    @Modifying
//    @Transactional
//    @Query("UPDATE Product SET productDropPrice=:dropPrice WHERE productId=:productId")
//    int updateProductDropPrice(@Param("productId") Long productId, @Param("dropPrice") Double dropPrice);

    List<Product> getProductsByProductCategory(String productCategory);

    @Query(nativeQuery = true,value = "SELECT * FROM `product` WHERE product_id=(SELECT MAX(product_id) FROM `product`)")
    Optional<Product> findLastProduct();

    Product getProductByProductId(Long id);
}
