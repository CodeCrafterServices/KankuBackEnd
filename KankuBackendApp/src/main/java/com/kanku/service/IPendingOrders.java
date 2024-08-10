package com.kanku.service;

import com.kanku.model.dto.PendingOrderDetailsDto;

import java.util.List;

public interface IPendingOrders {
    List<PendingOrderDetailsDto> getAllPendingOrders();
}
