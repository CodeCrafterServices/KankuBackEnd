package com.kanku.service.impl;

import com.kanku.model.Sales;
import com.kanku.repository.ISalesRepository;
import com.kanku.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceImpl implements ISalesService {

    @Autowired
    private ISalesRepository salesRepository;

    @Override
    public Sales saleProduct(Sales sales) {
        return salesRepository.save(sales);
    }
}
