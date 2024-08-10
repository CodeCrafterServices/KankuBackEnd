package com.kanku.service.impl;

import com.kanku.model.Supplier;
import com.kanku.repository.ISupplierRepository;
import com.kanku.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;

    @Override
    public Supplier addSupplier(Supplier supplier) {
        supplier.setSupplierDate(LocalDate.now());
        return supplierRepository.save(supplier);
    }
}
