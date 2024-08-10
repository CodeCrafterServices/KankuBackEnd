package com.kanku.service;

import com.kanku.model.TransactionDetails;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    TransactionDetails createTransaction(Double amount);
}
