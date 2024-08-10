package com.kanku.service.impl;

import com.kanku.model.TransactionDetails;
import com.kanku.service.PaymentService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final String KEY = "rzp_test_SCO1EwtS1TIsW2";
    private static final String SECRET_KEY = "II4oblDZDwP3ytzeFy3eLXTF";
    @Override
    public TransactionDetails createTransaction(Double amount) {
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("amount", (amount * 100));
            jsonObject.put("currency","INR");
            RazorpayClient client = new RazorpayClient(KEY, SECRET_KEY);
            Order order = client.orders.create(jsonObject);
            return prepareTransactionDetails(order);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public TransactionDetails prepareTransactionDetails(Order order){
        String orderId = order.get("id");
        String currency = order.get("currency");
        Integer amount = order.get("amount");
        String key = order.get("key");
        return new TransactionDetails(orderId,currency,amount, KEY);
    }
}