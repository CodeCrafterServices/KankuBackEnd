package com.kanku.repository;

import com.kanku.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<ProductOrder,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM order_info WHERE delivery_status=0")
    List<ProductOrder> getAllPendingOrders();

    @Query(nativeQuery = true,value = "SELECT * FROM order_info WHERE delivery_status=1")
    List<ProductOrder> getAllCompletedOrders();
}
