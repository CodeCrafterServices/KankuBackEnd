package com.kanku.repository;

import com.kanku.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISizeRepository extends JpaRepository<Size,Long> {

    Optional<Size> findByProduct_ProductIdAndSizeId(Long productId, Long sizeId);

    List<Size> getAllByProductProductId(Long id);

    @Query("SELECT s FROM Size s WHERE s.product.productId = :productId GROUP BY s.sizeType")
    List<Size> findDistinctSizesByProductId(@Param("productId") Long productId);

}
