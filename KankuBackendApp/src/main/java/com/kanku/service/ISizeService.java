package com.kanku.service;

import com.kanku.model.BatchProductSize;
import com.kanku.model.ProductOrder;
import com.kanku.model.Size;

import java.util.List;

public interface ISizeService {
    BatchProductSize addSize(BatchProductSize batchProductSize);

    List<Size> getSizeByProductId(Size size);

    void updateProductDetails(ProductOrder productOrder);

    List<Size> getUniqueProductSizes(Long productId);
}
