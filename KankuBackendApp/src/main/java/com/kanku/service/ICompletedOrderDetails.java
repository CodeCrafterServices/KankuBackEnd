package com.kanku.service;

import com.kanku.model.dto.CompletedOrderDetailsDto;

import java.util.List;

public interface ICompletedOrderDetails {

    List<CompletedOrderDetailsDto> getAllCompletedOrders();
}
